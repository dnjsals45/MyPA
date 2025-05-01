package seongmin.mypa.domain.member

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

    @Column(nullable = false, length = 10)
    @Comment("소셜 로그인 타입")
    val socialType: String,

    @Column(nullable = false, length = 100)
    @Comment("소셜 로그인 ID")
    var socialId: String
) : SoftDeleteEntity() {
}