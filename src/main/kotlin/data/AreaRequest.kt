package data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL
import java.util.*

const val AREA_URL = "https://api.hh.ru/areas"
val EMPTY_AREA: Area = Area(-1,emptyList<Area>(),-1,"")

class AreaRequest(){
    val areaList: List<Area> by lazy { execute()}

    fun getArea(areaName: String):Area {
        currentArea=null
        searchArea(areaList, areaName)
        return currentArea!!
    }


    fun getAreas(vararg areaNames: String):List<Area> {
        val result = ArrayList<Area>()
        for (areaName in areaNames) {
            searchArea(areaList, areaName)
            if (currentArea != null) {
                result.add(currentArea as Area)
                currentArea=null
            }
        }

        return result
    }


    private var currentArea: Area? = null
    private fun searchArea(areaList: List<Area>, areaName: String) {
        for (area in areaList)  {
            if (area.name.equals(areaName)) {
                currentArea = area
                break
            } else if(!area.areas.isEmpty()) {
                searchArea(area.areas, areaName) }
        }
    }


    fun execute(): List<Area> {
        val areaJsonStr = URL(AREA_URL).readText()
        val areaType = object : TypeToken<List<Area>>() {}.type
        return Gson().fromJson<List<Area>>(areaJsonStr, areaType)
    }
}



