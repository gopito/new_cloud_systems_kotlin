import org.junit.Assert.assertEquals
import data.CountryRequest
import org.junit.Test

class CountryTest {
    val countryRequest = CountryRequest()

    @Test
    fun amountOfCountriesTest() {
        assertEquals(countryRequest.amountOfCountries(), 138)
    }
}

