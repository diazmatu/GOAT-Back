package UNQ.TTIP.GOAT.service.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.dao.impl.ImplModelDAO
import UNQ.TTIP.GOAT.service.ModelService
import UNQ.TTIP.GOAT.service.dto.ModelDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ModelServiceImpl(@Autowired private val teamDao: TeamDAO,
                       @Autowired private val playerDao: PlayerDAO,
                       @Autowired private val tournamentDao: TournamentDAO,
                       @Autowired private val gameDAO: GameDAO,
                       @Autowired private val teamGameStatsDao: TeamGameStatsDAO,
                       @Autowired private val playerGameStatsDAO: PlayerGameStatsDAO
): ModelService {

    private val modelDao: ImplModelDAO = ImplModelDAO(teamDao, playerDao, tournamentDao, gameDAO, teamGameStatsDao, playerGameStatsDAO)

    override fun findData(id: Long, type: String): ModelDTO {
        return modelDao.findData(id, type)
    }

}
