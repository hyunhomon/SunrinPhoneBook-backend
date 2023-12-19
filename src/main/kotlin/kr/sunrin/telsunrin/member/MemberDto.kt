package kr.sunrin.telsunrin.member

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.sunrin.telsunrin.global.enums.Department
import kr.sunrin.telsunrin.global.enums.Gender
import org.hibernate.validator.constraints.Length
import java.util.UUID

data class MemberDtoReq (
	val phoneNumber: String,

	val name: String,

	val studentId: Int,

	val department: Department,

	val password: String,

	val gender: Gender,
) {
	fun toEntity() = Member(
		uuid = null,
		phoneNumber = this.phoneNumber,
		name = this.name,
		studentId = this.studentId,
		department = this.department,
		password = this.password,
		gender = this.gender,
		description = null,
		profileImage = null
	)
}

data class MemberDtoRes (
	val uuid: UUID?,

	val phoneNumber: String,

	val name: String,

	val studentId: Int,

	val department: Department,

	val gender: Gender,
)