package UNQ.TTIP.GOAT.dao.impl

import UNQ.TTIP.GOAT.dao.TeamGameStatsDAO
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.dto.GameDTO

class ImplGameDAO {

    fun gamesWithRivals(listOfGames: MutableList<TeamGameStats>, teamGameStatsDao: TeamGameStatsDAO): MutableList<GameDTO>{
        var gamesWithRivals = emptyList<GameDTO>().toMutableList()
        for (g in listOfGames){
            val rival = teamGameStatsDao.findByGameIdAndTeamIdNot(g.game.id, g.team.id)
            gamesWithRivals += GameDTO.fromModelGame(g, rival)
        }
        return gamesWithRivals
    }
}