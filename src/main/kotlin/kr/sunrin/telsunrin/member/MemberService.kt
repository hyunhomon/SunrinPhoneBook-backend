package kr.sunrin.telsunrin.member

import java.util.*

interface MemberService {
	fun findMember(uuid: UUID): MemberDtoRes

	fun findAllMembers(): MutableList<MemberDtoRes>

	fun createMember(member: MemberDtoReq): MemberDtoRes

	fun updateMember(uuid: UUID, member: MemberDtoReq, description: String, profileImage: String): Boolean

	fun deleteMember(uuid: UUID): Boolean
}