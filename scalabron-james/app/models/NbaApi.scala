package models

import play.api.libs.json.{Json, Reads, Writes}

case class NbaMeta(
    total_pages: Int,
    current_page: Int,
    next_page: Int,
    per_page: Int,
    total_count: Int
)

case class NbaTeam(
    id: Int,
    abbreviation: String,
    city: String,
    conference: String,
    division: String,
    full_name: String,
    name: String
)

case class NbaPlayer(
    id: Int,
    first_name: String,
    last_name: String,
    position: String,
    height_feet: Option[Int],
    height_inches: Option[Int],
    weight_pounds: Option[Int],
    team: NbaTeam
)

case class NbaPlayers(
    data: Seq[NbaPlayer],
    meta: NbaMeta
)

object NbaMeta {
   implicit val nbaMetaReads: Reads[NbaMeta] = Json.reads[NbaMeta]
}

object NbaTeam {
   implicit val nbaTeamReads: Reads[NbaTeam] = Json.reads[NbaTeam]
}

object NbaPlayer {
   implicit val nbaPlayerReads: Reads[NbaPlayer] = Json.reads[NbaPlayer]
}

object NbaPlayers {
   implicit val nbaPlayersReads: Reads[NbaPlayers] = Json.reads[NbaPlayers]
}