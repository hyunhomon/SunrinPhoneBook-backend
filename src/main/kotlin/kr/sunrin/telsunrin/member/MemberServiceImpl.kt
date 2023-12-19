package kr.sunrin.telsunrin.member

import kr.sunrin.telsunrin.global.exceptions.MemberNotFoundException
import java.util.*
import java.util.stream.Collectors
import kotlin.jvm.optionals.getOrNull

class MemberServiceImpl(
	private val memberRepository: MemberRepository
) : MemberService {
	override fun findMember(uuid: UUID): MemberDtoRes {
		val member = memberRepository.findById(uuid).getOrNull()

		if (member != null) {
			return member.toDto()
		} else {
			throw MemberNotFoundException("Cannot find member (uuid: $uuid)")
		}
	}

	override fun findAllMembers(): MutableList<MemberDtoRes> =
		memberRepository.findAll().stream()
			.map { member -> member.toDto() }
			.toList()
	

	override fun createMember(member: MemberDtoReq): MemberDtoRes =
		memberRepository.save(member.toEntity()).toDto()

	override fun updateMember(uuid: UUID, member: MemberDtoReq, description: String, profileImage: String): Boolean {
		val foundMember = memberRepository.findById(uuid).getOrNull()

		if (foundMember != null) {
			foundMember.update(member, description, profileImage)

			return true
		} else {
			throw MemberNotFoundException("Cannot find member (uuid: $uuid)")
		}
	}

	override fun deleteMember(uuid: UUID): Boolean {
		try {
			memberRepository.deleteById(uuid)

			return true
		} catch (exception: Exception) {
			return false
		}
	}
}