package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamGameId
import UNQ.TTIP.GOAT.model.Relationship.PlayerTeamStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamGameStatsDAO : JpaRepository<TeamGameStats, Long?> {
    fun findById(id: TeamGameId): TeamGameStats
    fun findByTeamNameStartingWith(name: String): MutableList<TeamGameStats>
    fun findByIdAndTeamNameStartingWith(id: Long?, name: String): MutableList<TeamGameStats>
    fun findByGameIdAndTeamIdNot(game_id: Long?, name: Long?): TeamGameStats
    fun findByGameId(id: Long): MutableList<TeamGameStats>
    //fun findByGameIdAndTeam_Players(game_id: Long, team_players: MutableList<PlayerTeamStats>)
}