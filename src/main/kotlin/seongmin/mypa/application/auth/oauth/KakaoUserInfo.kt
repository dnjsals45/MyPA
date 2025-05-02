package seongmin.mypa.application.auth.oauth

import com.fasterxml.jackson.databind.JsonNode
import seongmin.mypa.domain.auth.OAuthUserInfo

class KakaoUserInfo (
    private val attributes: JsonNode
) :OAuthUserInfo {
    override fun getSocialId(): String {
        return attributes["id"].asText()
    }

    override fun getEmail(): String? {
        return attributes["kakao_account"]?.get("email")?.asText()
    }

    override fun getNickname(): String? {
        return attributes["properties"]?.get("nickname")?.asText()
    }

    override fun getProfileImage(): String? {
        return attributes["properties"]?.get("profile_image")?.asText()
    }
}