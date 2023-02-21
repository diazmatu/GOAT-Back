package UNQ.TTIP.GOAT.dao.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.model.ImageHandler
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.PlayerGameId
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.PlayerTeamId
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamGameId
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamTournamentId
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.StatsSheet
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
                   @Autowired private val playerGameStatsDAO: PlayerGameStatsDAO,
                   @Autowired private val playerTeamStatsDAO: PlayerTeamStatsDAO,
                   @Autowired private val teamGameStatsDAO: TeamGameStatsDAO,
                   @Autowired private val teamTournamentStatsDAO: TeamTournamentStatsDAO
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

    override fun postImage(profileImage: MultipartFile, id: Long, type: String){
        var imageHandler = ImageHandler()
        var byteArray = profileImage.bytes
        var imageName = "$type"+"s/" +"$id" + ".jpg"
        var path = imageHandler.save(byteArray, imageName)
        when (type) {
            "Player" -> {
                var player = playerDao.findByDni(id)
                player.profileImage = path
                playerDao.saveAndFlush(player)
            }
            "Team" -> {
                var team = teamDao.findByIdOrNull(id)
                team!!.profileImage = path
                teamDao.saveAndFlush(team!!)
            }
            "Tournament" -> {
                var tournament = tournamentDao.findByIdOrNull(id)
                tournament!!.profileImage = path
                tournamentDao.saveAndFlush(tournament!!)
            }
        }
    }

    override fun saveStat(stat: String, playerDni: Long, teamId: Long, tournamentId: Long, gameId: Long) {

        val statField: Field = StatsSheet::class.java.getDeclaredField(stat)
        statField.isAccessible = true

        saveInPlayer(statField, playerDni, gameId, teamId)
        saveInTeam(statField, teamId, tournamentId, gameId)
    }

    private fun saveInTeam(statField: Field, teamId: Long, tournamentId: Long, gameId: Long) {
        var team = teamDao.findByIdOrNull(teamId)

        changeStatValue(statField, team!!)

        teamDao.saveAndFlush(team)

        var teamGameId = TeamGameId(gameId, teamId)
        var teamGame = teamGameStatsDAO.findByIdOrNull(teamGameId)

        changeStatValue(statField, teamGame!!)

        teamGameStatsDAO.saveAndFlush(teamGame)

        var teamTournamentId = TeamTournamentId(teamId, tournamentId)
        var teamTournament = teamTournamentStatsDAO.findByIdOrNull(teamTournamentId)

        changeStatValue(statField, teamTournament!!)

        teamTournamentStatsDAO.saveAndFlush(teamTournament)
    }

    private fun saveInPlayer(statField: Field, playerDni: Long, gameId: Long, teamId: Long) {
        var player = playerDao.findByDni(playerDni)

        changeStatValue(statField, player)

        playerDao.saveAndFlush(player)

        var playerGameId = PlayerGameId(gameId, playerDni)
        var playerGame = playerGameStatsDAO.findByIdOrNull(playerGameId)

        changeStatValue(statField, playerGame!!)

        playerGameStatsDAO.saveAndFlush(playerGame)

        var playerTeamId = PlayerTeamId(teamId, playerDni)
        var playerTeam = playerTeamStatsDAO.findByIdOrNull(playerTeamId)

        changeStatValue(statField, playerTeam!!)

        playerTeamStatsDAO.saveAndFlush(playerTeam)
    }

    private fun changeStatValue(statField: Field, entity: StatsSheet){
        var value: Int = statField.get(entity) as Int
        statField.set(entity, value + 1)

        var stat= statField.name
        if(stat.endsWith("Made")){
            convertedPoint(stat, entity, statField.get(entity) as Int)
        }
    }

    private fun convertedPoint(stat: String, entity: StatsSheet, convertedShot: Int){

        var attemptedStatName = stat.replace("Made", "Attempted")
        val attemptedField: Field = StatsSheet::class.java.getDeclaredField(attemptedStatName)
        attemptedField.isAccessible = true

        changeStatValue(attemptedField, entity)

        var percentageStatName = stat.replace("Made", "Percentage")
        val percentageField: Field = StatsSheet::class.java.getDeclaredField(percentageStatName)
        percentageField.isAccessible = true

        percentageField.set(entity, convertedShot / attemptedField.get(entity) as Int * 100)

        var points = 0
        when (stat.take(2)){
            "fr" -> points = 1
            "tw" -> points = 2
            "th" -> points = 3
        }

        val pointsField: Field = StatsSheet::class.java.getDeclaredField("points")
        pointsField.isAccessible = true
        var value: Int = pointsField.get(entity) as Int
        pointsField.set(entity, value + points)
    }

}
