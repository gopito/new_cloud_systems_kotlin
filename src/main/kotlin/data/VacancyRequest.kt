package data

import com.google.gson.Gson

import java.net.URL
import java.net.URLEncoder

const val VACANCY_URL = "https://api.hh.ru/vacancies"

class VacancyRequest(var text: String = "", var area: Area = EMPTY_AREA) : SearchRequest() {
    var vacancies: Vacancies = Vacancies(items = emptyList<Vacancy>())
    var areas: List<Area> = emptyList<Area>()

    init {
        if (area.id!=-1){
            areas = listOf(area)
        }
    }

    private fun buildUrlString(): String {
        return buildUrlString(VACANCY_URL,text,areas)
    }

    fun amountOfEmployers(): Int {
        return vacancies.items.size
    }

    fun execute(): Vacancies {
        val vacancyJsonStr = URL(buildUrlString()).readText()
        return Gson().fromJson(vacancyJsonStr, Vacancies::class.java)
    }
}
