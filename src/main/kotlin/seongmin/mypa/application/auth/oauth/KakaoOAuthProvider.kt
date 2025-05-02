package seongmin.mypa.application.auth.oauth

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.util.UriComponentsBuilder
import seongmin.mypa.application.auth.OAuthProvider
import seongmin.mypa.domain.auth.OAuthUserInfo

@Component
class KakaoOAuthProvider (
    @Qualifier("kakaoOauthRestClient")
    private val restClient: RestClient
) : OAuthProvider {
    @Value("\${oauth.kakao.client-id}")
    private lateinit var clientId: String

    @Value("\${oauth.kakao.redirect-uri}")
    private lateinit var redirectUri: String

    fun getAuthorizationUrl(): String {
        val uri = UriComponentsBuilder.fromUriString("https://kauth.kakao.com/oauth/authorize")
            .queryParam("response_type", "code")
            .queryParam("client_id", clientId)
            .queryParam("redirect_uri", redirectUri)
            .build()
            .toUri()

        return uri.toString()
    }

    override fun getUserInfo(authCode: String): OAuthUserInfo {
        val tokenResponse = getToken(authCode)
        val userInfo = getUserInfoFromKakao(tokenResponse["access_token"].asText())
        return KakaoUserInfo(userInfo)
    }

    private fun getToken(authCode: String): JsonNode {
        val uri = UriComponentsBuilder.fromUriString("https://kauth.kakao.com/oauth/token")
            .queryParam("grant_type", "authorization_code")
            .queryParam("client_id", clientId)
            .queryParam("redirect_uri", redirectUri)
            .queryParam("code", authCode)
            .build()
            .toUriString()

        return restClient.post()
            .uri(uri)
            .retrieve()
            .body(JsonNode::class.java)
            ?: throw RuntimeException("카카오 토큰 응답 실패")
    }

    private fun getUserInfoFromKakao(accessToken: String): JsonNode {
        return restClient.get()
            .uri("https://kapi.kakao.com/v2/user/me")
            .header("Authorization", "Bearer $accessToken")
            .retrieve()
            .body(JsonNode::class.java)
            ?: throw IllegalStateException("카카오 유저 정보 조회 실패")
    }
}