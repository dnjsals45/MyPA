package seongmin.mypa.interfaces.api.auth

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import seongmin.mypa.application.auth.oauth.KakaoOAuthProvider
import java.net.URI

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val kakaoOAuthProvider: KakaoOAuthProvider,
) {
    @GetMapping("/login/kakao")
    fun getCode(): ResponseEntity<Unit> {
        val redirectUrl = kakaoOAuthProvider.getAuthorizationUrl()

        return ResponseEntity.status(HttpStatus.FOUND)
            .location(URI.create(redirectUrl))
            .build()
    }

    @GetMapping("/callback/kakao")
    fun handleCallback(@RequestParam code: String): ResponseEntity<Unit> {
        val userInfo = kakaoOAuthProvider.getUserInfo(code)
        return ResponseEntity.ok().build()
    }
}