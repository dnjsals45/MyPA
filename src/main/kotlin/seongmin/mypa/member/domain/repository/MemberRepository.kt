package seongmin.mypa.member.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import seongmin.mypa.member.domain.model.Member

interface MemberRepository: JpaRepository<Member, Long> {
    fun findBySocialId(socialId: String): Member?
}