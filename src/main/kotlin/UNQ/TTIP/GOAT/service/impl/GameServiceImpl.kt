package UNQ.TTIP.GOAT.service.impl

import UNQ.TTIP.GOAT.dao.GameDAO
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.GameService
import org.springframework.beans.factory.annotation.Autowired

class GameServiceImpl (@Autowired private val gameDAO: GameDAO): GameService {

    override fun findByTeamNameStartingWith(name: String): MutableList<TeamGameStats> {
        return gameDAO.findByTeamNameStartingWith(name)
    }

    override fun findByIdAndTeamNameStartingWith(id: Long?, name: String): MutableList<TeamGameStats> {
        return gameDAO.findByIdAndTeamNameStartingWith(id, name)
    }
}
