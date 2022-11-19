package UNQ.TTIP.GOAT.service.impl

import UNQ.TTIP.GOAT.controller.GameController
import UNQ.TTIP.GOAT.controller.GamePrototype
import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Relationship.PlayerGameStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.GameService
import UNQ.TTIP.GOAT.service.dto.GameDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameServiceImpl (@Autowired private val tournamentDao: TournamentDAO,
                       @Autowired private val teamDao: TeamDAO,
                       @Autowired private val playerDao: PlayerDAO,
                       @Autowired private val gameDAO: GameDAO,
                       @Autowired private val teamGameStatsDAO: TeamGameStatsDAO,
                       @Autowired private val playerGameStatsDAO: PlayerGameStatsDAO): GameService {

    override fun findByTeamNameStartingWith(name: String): MutableList<TeamGameStats> {
        return teamGameStatsDAO.findByTeamNameStartingWith(name)
    }

    override fun findByIdAndTeamNameStartingWith(id: Long?, name: String): MutableList<TeamGameStats> {
        return teamGameStatsDAO.findByIdAndTeamNameStartingWith(id, name)
    }

    override fun findByGameId(id: Long): GameDTO {
        return GameDTO.fromModelGame(teamGameStatsDAO.findByGameId(id)[0], teamGameStatsDAO.findByGameId(id)?.get(1))
    }

    override fun createGame(requestGame: GamePrototype): Long? {

        val tournament = tournamentDao.findByIdOrNull(requestGame.tournament)
        val game = gameDAO.saveAndFlush(Game(emptyList<TeamGameStats>().toMutableList(), tournament!!))

        val homeTeamStats = createTeamGameStats(requestGame.homeTeam, game, true)
        val awayTeamStats = createTeamGameStats(requestGame.awayTeam, game, false)

        game.teams = game.teams.plus(awayTeamStats).plus(homeTeamStats)

        val homePlayers = createPlayerGameStats(requestGame.homePlayers, game, true)
        val awayPlayers = createPlayerGameStats(requestGame.awayPlayers, game, false)

        game.players = game.players.plus(homePlayers).plus(awayPlayers)

        gameDAO.saveAndFlush(game)

        return game.id
    }

    fun createTeamGameStats(teamId: Long, game: Game, isHome: Boolean): TeamGameStats{
        val team = teamDao.findByIdOrNull(teamId)
        val stats = TeamGameStats.createStats(team!!, game)
        stats.homeTeam = isHome
        return teamGameStatsDAO.saveAndFlush(stats)
    }

    fun createPlayerGameStats(playersIds: List<Long>, game: Game, isHome: Boolean): List<PlayerGameStats>{
        var playersStats = emptyList<PlayerGameStats>()
        for (p in playersIds) {
            val player = playerDao.findByIdOrNull(p)
            val stats = PlayerGameStats.createStats(player!!, game)
            stats.homeTeam = isHome
            playerGameStatsDAO.saveAndFlush(stats)
            playersStats = playersStats.plus(stats)
        }
        return playersStats
    }
}
