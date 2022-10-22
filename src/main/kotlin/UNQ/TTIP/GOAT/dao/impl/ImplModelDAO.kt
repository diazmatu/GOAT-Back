package UNQ.TTIP.GOAT.dao.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.service.dto.*
import org.springframework.beans.factory.annotation.Autowired

class ImplModelDAO(@Autowired private val teamDao: TeamDAO,
                   @Autowired private val playerDao: PlayerDAO,
                   @Autowired private val tournamentDao: TournamentDAO,
                   @Autowired private val teamGameStatsDao: TeamGameStatsDAO,
                   @Autowired private val playerGameStatsDAO: PlayerGameStatsDAO
) : ModelDAO {

    override fun findData(id: Long, type: String): ModelDTO {
        return when (type) {
            "Tournament" -> ModelDTO.fromModelTournament(teamDao.findByTournamentsIdTournamentId(id), emptyList<Game>().toMutableList())
            "Team" -> ModelDTO.fromModelTeam(tournamentDao.findByTeamsIdTeamId(id), playerDao.findByTeamsIdTeamId(id) , emptyList<Game>().toMutableList())
            "Player" -> ModelDTO.fromModelPlayer(teamDao.findByPlayersIdPlayerDni(id), emptyList<Game>().toMutableList())
            "Game" -> {
                var teams = teamGameStatsDao.findByGameId(id)
                var teamA = mutableListOf(teams[0].team.id)
                var teamB = mutableListOf(teams[1].team.id)
                return ModelDTO.fromModelGame(
                    teams,
                    playerGameStatsDAO.findByGameIdAndPlayerTeamsIdTeamIdIn(id, teamA),
                    playerGameStatsDAO.findByGameIdAndPlayerTeamsIdTeamIdIn(id, teamB)
                )
            }
            else -> ModelDTO(emptyList<TournamentDTO>().toMutableList(), emptyList<TeamDTO>().toMutableList(), emptyList<PlayerDTO>().toMutableList(), emptyList<GameDTO>().toMutableList())
        }

    }

}
