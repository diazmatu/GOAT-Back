package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamGameId
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameDAO : JpaRepository<TeamGameStats, Long?> {
    fun findById(id: TeamGameId): TeamGameStats
    fun findByTeamNameStartingWith(name: String): MutableList<TeamGameStats>
    fun findByIdAndTeamNameStartingWith(id: Long?, name: String): MutableList<TeamGameStats>
    //fun findByIdGameIdTournamentId(id: Long): MutableList<Game>

}