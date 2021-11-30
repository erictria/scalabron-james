package services 

import play.api.libs.json._

import service._

class NbaApiService(
    api: ApiService
) {

    val apiUrl = "https://www.balldontlie.io/api/v1/"

    def getPlayers(search: String) = {
        val playersApiUrl = apiUrl + "players"
        val payload = Json.obj(
            "search" => search
        )
        api.post[JsValue](playersApiUrl, payload).map {
            response => {
                response
            }
        }
    }
}

