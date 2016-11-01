package data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL
import java.util.*

const val COUNTRY_URL = "https://api.hh.ru/areas/countries"

class CountryRequest () {
    val countryList: List<Country> by lazy { execute()}

    fun getArea(countryName: String): Area {
        return toArea(getCountry(countryName))
    }

    fun getCountry(countryName: String): Country {
        for (country in countryList) {
            if(country.name.equals(countryName))
                return country
        }
        return Country(URL("notExist"),-1,"")
    }

    fun toArea(country: Country):Area {
        val (url, id, name) = country
        return Area(-1, emptyList<Area>(),id,name)
    }

    fun amountOfCountries():Int{
        return countryList.size
    }

    private fun execute(): List<Country> {
        val countryJsonStr = URL(COUNTRY_URL).readText()
        val countryType = object : TypeToken<List<Country>>() {}.type
        return Gson().fromJson<List<Country>>(countryJsonStr, countryType)
    }
}