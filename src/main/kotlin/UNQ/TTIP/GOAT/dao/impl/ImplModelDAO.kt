package UNQ.TTIP.GOAT.dao.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.service.dto.ModelDTO
import org.springframework.beans.factory.annotation.Autowired

class ImplModelDAO(@Autowired private val teamDao: TeamDAO,
                   @Autowired private val playerDao: PlayerDAO,
                   @Autowired private val tournamentDao: TournamentDAO,
                   @Autowired private val gameDao: GameDAO
) : ModelDAO {

    override fun findData(id: Long, type: String): ModelDTO {
        return when (type) {
            "Tournament" -> ModelDTO.fromModelTournament(teamDao.findByTournamentsIdTournamentId(id), emptyList<Game>().toMutableList())
            "Team" -> ModelDTO.fromModelTeam(tournamentDao.findByTeamsIdTeamId(id), playerDao.findByTeamsIdTeamId(id) , emptyList<Game>().toMutableList())
            "Player" -> ModelDTO.fromModelPlayer(teamDao.findByPlayersIdPlayerDni(id), emptyList<Game>().toMutableList())
            else -> {ModelDTO.fromModelTournament(teamDao.findByTournamentsIdTournamentId(id), emptyList<Game>().toMutableList())}
        }

    }

}
