package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamGameId
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamGameStatsDAO : JpaRepository<TeamGameStats, Long?>{
    fun findById(id: TeamGameId): TeamGameStats
    fun findByTeamNameStartingWith(name: String): MutableList<TeamGameStats>
    fun findByIdAndTeamNameStartingWith(id: Long?, name: String): MutableList<TeamGameStats>
    fun findByGameIdAndTeamIdNot(game_id: Long?, name: Long?): TeamGameStats
    fun findByGameId(id: Long?): MutableList<TeamGameStats>
    fun findByTeamId(team_id: Long): MutableList<TeamGameStats>
    //fun findByTeamId(id: Long): MutableList<Game>
    //fun findByGameIdAndTeam_Players(game_id: Long, team_players: MutableList<PlayerTeamStats>)
/*
    fun gamesWithRivals(listOfGames: MutableList<TeamGameStats>): MutableList<GameDTO>{
        val gamesWithRivals = emptyList<GameDTO>().toMutableList()
        for (g in listOfGames){
            val rival = findByGameIdAndTeamIdNot(g.game.id, g.team.id)
            gamesWithRivals += GameDTO.fromModelGame(g, rival)
        }
        return gamesWithRivals
    }*/
}