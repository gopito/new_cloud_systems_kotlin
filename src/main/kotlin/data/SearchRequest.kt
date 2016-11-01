package data

import java.net.URLEncoder

abstract class SearchRequest(){

    fun buildUrlString(url:String, text:String ="", areas:List<Area> = emptyList<Area>()): String {
        val emptyString = ""
        val searchText = "text=${URLEncoder.encode(text, "utf-8").replace("+", "%20")}&"
        var areasString: String = ""
        if (areas.isNotEmpty()) {
            for (id in areas.map { it.id }) {
                areasString += "area=$id&"
            }
        }

        return "$url/?${if (text.isNotEmpty()) searchText else emptyString}" +
                if (areas.isNotEmpty()) areasString else emptyString
    }

}

