package service

import javax.inject._

import cats.data.EitherT
import models._
import models.domain._
import play.api.Configuration
import play.api.libs.json._
import play.api.libs.ws.{WSResponse, _}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class ApiService @Inject()(ws: WSClient, configuration: Configuration) {

  private def post(service: String, payload: JsValue): Future[WSResponse] = {
    val data = payload
    val apiUrl = configuration.get[String]("application.url") + service
    ws.url(apiUrl)
      .post(data)
  }

  def call[A](service: String, payload: JsValue)(implicit r: Reads[A]): PageRes[A] = EitherT {
    post(url, payload).map {
      response: WSResponse => {
        (Json.parse(response.body) \ "payload").validate[A] match {
          case s: JsSuccess[A] => Right(s.value)
          case e: JsError => Left(JsParseError("Error"))
        }
      }
    }
  }
}