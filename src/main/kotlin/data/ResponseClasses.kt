package data
import java.net.URL
data class Country(val url: URL, val id: Int, val name: String)
data class Area(val parent_id: Int, val areas: List<Area>, val id: Int, val name: String)

data class Employers(val per_page: Int, val items: List<Employee>, val page: Int, val pages: Int, val found: Int)
data class Employee(val vacancies_url: URL, val open_vacancies: Int, val id: Int, val name: String, val url: URL,
                     val alternate_url: URL)

data class Vacancies(val items: List<Vacancy>)
data class Vacancy(val name: String)



