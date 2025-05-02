package seongmin.mypa.auth.domain.oauth

interface OAuthProvider {
    fun getUserInfo(authCode: String): OAuthUserInfo
}