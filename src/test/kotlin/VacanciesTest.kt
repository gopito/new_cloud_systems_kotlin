import data.AreaRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matchers.contains
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import data.VacancyRequest
import org.junit.Test

class VacanciesTest {
    val areaRequest = AreaRequest()

    @Test
    fun vacancyInSpbTest() {
        val spb = areaRequest.getArea("Санкт-Петербург")
        val vacancies = VacancyRequest("QA Automation Engineer (Server)", spb).execute()
        println("vacancies found = ${vacancies.items}")
        assertThat(vacancies.items, contains(hasProperty("name", `is`("QA Automation Engineer (Server)"))))
    }
}