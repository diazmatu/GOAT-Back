package UNQ.TTIP.GOAT.service.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.dao.impl.ImplModelDAO
import UNQ.TTIP.GOAT.service.ModelService
import UNQ.TTIP.GOAT.service.dto.ModelDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ModelServiceImpl(@Autowired private val teamDao: TeamDAO,
                       @Autowired private val playerDao: PlayerDAO,
                       @Autowired private val tournamentDao: TournamentDAO,
                       @Autowired private val gameDAO: GameDAO,
                       @Autowired private val teamGameStatsDao: TeamGameStatsDAO,
                       @Autowired private val playerGameStatsDAO: PlayerGameStatsDAO,
                       @Autowired private val playerTeamStatsDAO: PlayerTeamStatsDAO,
                       @Autowired private val teamGameStatsDAO: TeamGameStatsDAO,
                       @Autowired private val teamTournamentStatsDAO: TeamTournamentStatsDAO
): ModelService {

    private val modelDao: ImplModelDAO = ImplModelDAO(teamDao, playerDao, tournamentDao, gameDAO, teamGameStatsDao, playerGameStatsDAO, playerTeamStatsDAO, teamGameStatsDAO, teamTournamentStatsDAO)

    override fun findData(id: Long, type: String): ModelDTO {
        return modelDao.findData(id, type)
    }

    override fun postImage(profileImage: MultipartFile, id: Long, type: String){
        modelDao.postImage(profileImage, id, type)
    }

    override fun saveStat(stat: String, playerDni: Long, teamId: Long, tournamentId: Long, gameId: Long) {
        modelDao.saveStat(stat, playerDni, teamId, tournamentId, gameId)
    }

}
