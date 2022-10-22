package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameDAO : JpaRepository<Game, Int?> {

    fun findByTournamentId(tournament_id: Long): MutableList<Game>
    fun findByTeamsTeamIdContaining(teams_team_id: Long): MutableList<Game>

}
