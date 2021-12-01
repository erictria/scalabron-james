package models

import cats.data.{EitherT, OptionT}

import scala.concurrent.Future

package object domain {
  type PageRes[A] = EitherT[Future, PageError, A]

  type PageOpt[A] = OptionT[Future, A]
}
