package seongmin.mypa.auth.domain.oauth

interface OAuthUserInfo {
    fun getSocialId(): String
    fun getEmail(): String?
    fun getNickname(): String?
    fun getProfileImage(): String?
}