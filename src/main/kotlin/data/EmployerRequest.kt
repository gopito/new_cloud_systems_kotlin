package data

import com.google.gson.Gson

import java.net.URL
import java.net.URLEncoder

const val EMPLOYERS_URL = "https://api.hh.ru/employers"
val EMPTY_EMPLOYERS =Employers(per_page = 20, items = emptyList<Employee>(),page=0, found = 0, pages =1)

class EmployersRequest(var text: String = "", var area: Area = EMPTY_AREA) : SearchRequest() {
    var employers: Employers = EMPTY_EMPLOYERS
    var areas:List<Area> = emptyList<Area>()

    init {
        if (area.id!=-1){
            areas = listOf(area)
        }
    }

    private fun buildUrlString(): String{
        return buildUrlString(EMPLOYERS_URL,text, areas)
    }

    fun amountOfEmployers():Int{
        return employers.items.size
    }

    fun execute(): Employers {
        val employersJsonStr = URL(buildUrlString()).readText()
        return Gson().fromJson(employersJsonStr, Employers::class.java)
    }
}
