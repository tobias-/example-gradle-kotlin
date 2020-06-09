package org.example.domain

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CDLLicenseTest {

  @Test
  fun `Test create and find license`() {
    CDLLicense(
      licenseNumber = 1234,
      name = "Patrick Gilmore",
      licenseTypes = setOf(
        LicenseType.C,
        LicenseType.B
      )
    ).save()

    val foundLicense = CDLLicense.findByLicenseNumber(1234)
    assertNotNull(foundLicense)
    assertEquals("Patrick Gilmore", foundLicense.name)
    assertTrue(foundLicense.licenseTypes.containsAll(setOf(LicenseType.C, LicenseType.B)))
  }

  @Test
  fun `Test create and find license with endorsements`() {
    CDLLicense(
      licenseNumber = 4567,
      name = "Patrick Gilmore",
      licenseTypes = setOf(
        LicenseType.C,
        LicenseType.B
      ),
      endorsements = setOf(
        Endorsement.H,
        Endorsement.P
      )
    ).save()

    val foundLicense = CDLLicense.findByLicenseNumber(4567)
    assertNotNull(foundLicense)
    assertEquals("Patrick Gilmore", foundLicense.name)
    assertTrue(foundLicense.licenseTypes.containsAll(setOf(LicenseType.C, LicenseType.B)))
    assertTrue(foundLicense.endorsements?.containsAll(setOf(Endorsement.H, Endorsement.P)) == true)
  }

  @Test
  fun `Test create and find license with endorsements set to null`() {
    CDLLicense(
      licenseNumber = 7890,
      name = "Patrick Gilmore",
      licenseTypes = setOf(
        LicenseType.C,
        LicenseType.B
      ),
      endorsements = null
    ).save()

    val foundLicense = CDLLicense.findByLicenseNumber(7890)
    assertNotNull(foundLicense)
    assertEquals("Patrick Gilmore", foundLicense.name)
    assertTrue(foundLicense.licenseTypes.containsAll(setOf(LicenseType.C, LicenseType.B)))
    assertNull(foundLicense.endorsements)
  }
}
