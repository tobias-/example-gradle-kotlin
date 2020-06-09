package org.example.domain

import io.ebean.annotation.DbArray
import io.ebean.annotation.DbEnumType
import io.ebean.annotation.DbEnumValue
import org.example.domain.finder.CDLLicenseFinder
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class CDLLicense(
  @Column(unique = true)
  val licenseNumber: Int,
  val name: String,
  @DbArray
  val licenseTypes: Set<LicenseType> = emptySet(),
  @DbArray
  val endorsements: Set<Endorsement>? = null
) : BaseModel() {
  companion object Find : CDLLicenseFinder()
}


enum class Endorsement(
  @get:DbEnumValue(storage = DbEnumType.INTEGER)
  val dbVal: Int
) {
  H(0),
  X(1),
  P(2),
  T(3)
}

enum class LicenseType(
  @get:DbEnumValue(storage = DbEnumType.INTEGER)
  val dbVal: Int
) {
  A(0),
  B(1),
  C(2)
}
