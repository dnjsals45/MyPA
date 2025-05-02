package seongmin.mypa.member.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.Comment
import seongmin.mypa.common.model.SoftDeleteEntity

@Entity
@Table(name = "member")
class Member (
    @Column(name = "email", nullable = false)
    @Comment("회원 이메일")
    val email: String,

    @Column(name = "nickname", nullable = false)
    @Comment("회원 닉네임")
    val nickname: String,

    @Column(name = "profile_image")
    @Comment("회원 프로필 이미지")
    val profileImage: String? = null,

    @Column(nullable = false, length = 10)
    @Comment("소셜 로그인 타입")
    val socialType: String,

    @Column(nullable = false, length = 100)
    @Comment("소셜 로그인 ID")
    var socialId: String,

    @Column(name = "refresh_token", length = 500)
    @Comment("리프레시 토큰")
    var refreshToken: String? = null
) : SoftDeleteEntity() {
}