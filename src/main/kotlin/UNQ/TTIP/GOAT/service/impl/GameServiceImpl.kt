package UNQ.TTIP.GOAT.service.impl

import UNQ.TTIP.GOAT.dao.TeamGameStatsDAO
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.GameService
import UNQ.TTIP.GOAT.service.dto.GameDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameServiceImpl (@Autowired private val teamGameStatsDAO: TeamGameStatsDAO): GameService {

    override fun findByTeamNameStartingWith(name: String): MutableList<TeamGameStats> {
        return teamGameStatsDAO.findByTeamNameStartingWith(name)
    }

    override fun findByIdAndTeamNameStartingWith(id: Long?, name: String): MutableList<TeamGameStats> {
        return teamGameStatsDAO.findByIdAndTeamNameStartingWith(id, name)
    }

    override fun findByGameId(id: Long): GameDTO {
        return GameDTO.fromModelGame(teamGameStatsDAO.findByGameId(id)[0], teamGameStatsDAO.findByGameId(id)?.get(1))
    }
}
