package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.CDLLicense
import org.example.domain.query.QCDLLicense

abstract class CDLLicenseFinder : Finder<Long, CDLLicense>(CDLLicense::class.java) {

  fun findByLicenseNumber(licenseNumber: Int): CDLLicense? {
    return QCDLLicense()
      .licenseNumber.eq(licenseNumber)
      .findOne()
  }
}
