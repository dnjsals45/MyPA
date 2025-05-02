package seongmin.mypa.domain.auth

interface OAuthUserInfo {
    fun getSocialId(): String
    fun getEmail(): String?
    fun getNickname(): String?
    fun getProfileImage(): String?
}