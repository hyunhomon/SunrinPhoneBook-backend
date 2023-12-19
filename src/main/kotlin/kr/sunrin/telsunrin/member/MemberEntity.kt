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

@Entity
data class Member (
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	val uuid: UUID?,

	@Column(nullable = false, updatable = true, unique = true, length = 11)
	var phoneNumber: String,

	@Column(nullable = false, updatable = true, unique = false)
	var name: String,

	@Column(nullable = false, updatable = true, unique = false, length = 5)
	var studentId: Int,

	@Column(nullable = false, updatable = true, unique = false)
	@Enumerated(EnumType.STRING)
	var department: Department,

	@Column(nullable = false, updatable = true, unique = false)
	@Length(max = 300)
	var description: String?,

	@Column(nullable = false, updatable = true, unique = false)
	@Length(min = 4, max = 30)
	var password: String,

	@Column(nullable = false, updatable = false, unique = false)
	@Enumerated(EnumType.STRING)
	val gender: Gender,

	@Column(nullable = false, updatable = false, unique = true)
	var profileImage: String?
) {
	fun toDto() = MemberDtoRes(
			uuid = this.uuid,
			phoneNumber = this.phoneNumber,
			name = this.name,
			studentId = this.studentId,
			department = this.department,
			gender = this.gender
		)

	fun update(dto: MemberDtoReq, description: String?, profileImage: String?) {
		this.phoneNumber = dto.phoneNumber
		this.name = dto.name
		this.studentId = dto.studentId
		this.department = dto.department
		this.description = description
		this.profileImage = profileImage
	}
}