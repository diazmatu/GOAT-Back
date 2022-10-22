package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Relationship.JoinKey.PlayerGameId
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.PlayerTeamId
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamGameId
import UNQ.TTIP.GOAT.model.Relationship.PlayerGameStats
import UNQ.TTIP.GOAT.model.Relationship.PlayerTeamStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerGameStatsDAO : JpaRepository<PlayerGameStats, Long?> {
    //fun findById(id: PlayerGameId): PlayerGameStats
    //fun findByPlayerNameStartingWith(name: String): MutableList<PlayerGameStats>
    //fun findByIdAndPlayerNameStartingWith(id: Long?, name: String): MutableList<PlayerGameStats>
    //fun findByGameIdAndPlayerIdNot(game_id: Long?, name: Long?): PlayerGameStats
    fun findByGameIdAndPlayerTeamsIdTeamIdIn(game_id: Long, player_teams_id_teamId: MutableCollection<Long?>): MutableList<PlayerGameStats>
}