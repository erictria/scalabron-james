package services 

import play.api.libs.json._

import service._
import models._

class NbaApiService(
    api: ApiService
) {

    def searchPlayers(search: String): PageRes[NbaPlayers] = {
        val service = "players"
        val payload = Json.obj(
            "search" => search
        )
        api.post[NbaPlayers](playersApiUrl, payload).map {
            response => {
                response
            }
        }
    }

    def getPlayerById(id: Int): PageRes[NbaPlayers] = {
        val service = "players/" + id
        val payload = Json.obj()
        api.post[NbaPlayers](playersApiUrl, payload).map {
            response => {
                response
            }
        }
    }
}

