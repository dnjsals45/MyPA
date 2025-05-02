package seongmin.mypa.application.auth

import seongmin.mypa.domain.auth.OAuthUserInfo

interface OAuthProvider {
    fun getUserInfo(authCode: String): OAuthUserInfo
}