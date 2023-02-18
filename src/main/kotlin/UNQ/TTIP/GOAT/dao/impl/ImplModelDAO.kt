package UNQ.TTIP.GOAT.dao.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.dto.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.multipart.MultipartFile
import java.lang.reflect.Field

class ImplModelDAO(@Autowired private val teamDao: TeamDAO,
                   @Autowired private val playerDao: PlayerDAO,
                   @Autowired private val tournamentDao: TournamentDAO,
                   @Autowired private val gameDAO: GameDAO,
                   @Autowired private val teamGameStatsDao: TeamGameStatsDAO,
                   @Autowired private val playerGameStatsDAO: PlayerGameStatsDAO
) : ModelDAO {

    override fun findData(id: Long, type: String): ModelDTO {
        when (type) {
            "Player" -> {
                return ModelDTO.fromModelPlayer(
                    teamDao.findByPlayersIdPlayerDni(id),
                    getGamesFor(id, type)/*gameDAO.findByPlayerDni(id)*/
                )
            }
            "Tournament" -> {
                val tournament = tournamentDao.findByIdOrNull(id)
                val name = tournament!!.name
                return ModelDTO.fromModelTournament(teamDao.findByTournamentsIdTournamentId(id), getGamesFor(id, type), name)
            }
            "Team" -> {
                return ModelDTO.fromModelTeam(
                    tournamentDao.findByTeamsIdTeamId(id),
                    playerDao.findByTeamsIdTeamId(id),
                    getGamesFor(id, type)
            /*gameDAO.findByTeamsTeamIdContaining(id)*/)
            }

            "Game" -> {
                var teams = teamGameStatsDao.findByGameId(id)
                var homeTeam = mutableListOf(teams[0].team.id)
                var awayTeam = mutableListOf(teams[1].team.id)
                return ModelDTO.fromModelGame(
                    teams,
                    playerGameStatsDAO.findByGameIdAndPlayerTeamsIdTeamIdIn(id, homeTeam),
                    playerGameStatsDAO.findByGameIdAndPlayerTeamsIdTeamIdIn(id, awayTeam)
                )
            }
            else -> return ModelDTO(emptyList<TournamentDTO>().toMutableList(), emptyList<TeamDTO>().toMutableList(), emptyList<PlayerDTO>().toMutableList(), emptyList<GameDTO>().toMutableList())
        }
    }

    fun getGamesFor(id: Long, type: String): MutableList<GameDTO> {
        var games : MutableList<GameDTO> = emptyList<GameDTO>().toMutableList()
        when (type) {
            "Tournament" -> {
                val listOfGames = gameDAO.findByTournamentId(id)
                games = listOfGames.map { GameDTO.fromGame(it)} as MutableList<GameDTO>
            }
            "Team" -> {
                val listOfGames = teamGameStatsDao.findByTeamId(id)
                games = ImplGameDAO().gamesWithRivals(listOfGames, teamGameStatsDao)
            }
            "Player" -> {
                val listOfGames = playerGameStatsDAO.findByPlayerDni(id)
                var playerGames: MutableList<TeamGameStats> = emptyList<TeamGameStats>().toMutableList()
                for (g in listOfGames){
                    playerGames += teamGameStatsDao.findByGameId(g.game.id)
                }
                games = ImplGameDAO().gamesWithRivals(playerGames, teamGameStatsDao)
            }
        }
        return games
    }

}
