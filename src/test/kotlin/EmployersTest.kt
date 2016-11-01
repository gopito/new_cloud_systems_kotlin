import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matchers.contains
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import data.CountryRequest
import data.EmployersRequest
import org.junit.Test

class EmployersTest {
    val countryRequest = CountryRequest()

    @Test
    fun CompanyInCountryTest() {
        val russia = countryRequest.getArea("Россия")
        val employers = EmployersRequest("новые облачные", russia).execute()
        println("employers found = ${employers.items}")
        assertThat(employers.items, contains(hasProperty("name", `is`("Новые Облачные Технологии"))))
    }
}