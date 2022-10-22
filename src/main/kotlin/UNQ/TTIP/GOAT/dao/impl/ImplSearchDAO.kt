package UNQ.TTIP.GOAT.dao.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.dto.SearchResultDTO
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.Entity

class ImplSearchDAO(@Autowired private val teamDao: TeamDAO,
                    @Autowired private val playerDao: PlayerDAO,
                    @Autowired private val tournamentDao: TournamentDAO,
                    @Autowired private val teamGameStatsDao: TeamGameStatsDAO
)
    : SearchDAO{

    override fun findByName(name: String): MutableList<Entity> {

        val result : MutableList<Entity> = emptyList<Entity>().toMutableList()

        result += teamDao.findByName(name) as MutableList<Entity>
        result += playerDao.findByName(name) as MutableList<Entity>
        result += playerDao.findBySurname(name) as MutableList<Entity>
        result += tournamentDao.findByName(name) as MutableList<Entity>
        //result += gameDao.findByTeamsName(name)

        return result
    }

    override fun findByNameStartingWith(
        prefix: String,
        tournamentFilter: Boolean,
        teamFilter: Boolean,
        playerFilter: Boolean
    ): Pair<MutableList<SearchResultDTO>, MutableList<String>> {

        val result : MutableList<SearchResultDTO> = emptyList<SearchResultDTO>().toMutableList()
        val errors : MutableList<String> = emptyList<String>().toMutableList()

        if (teamFilter) {
            var foundTeams : List<SearchResultDTO> = teamDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelTeam(it) }
            foundTeams.ifEmpty { errors += "Teams" }
            result += foundTeams
        }


        if (playerFilter) {
            val foundPlayers : MutableList<SearchResultDTO> =
                playerDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelPlayer(it) }.toMutableList()
            foundPlayers += playerDao.findBySurnameStartingWith(prefix).map { SearchResultDTO.fromModelPlayer(it) }
            foundPlayers.ifEmpty { errors += "Players" }
            result += foundPlayers
        }

        if (tournamentFilter) {
            var foundTournaments = tournamentDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelTournament(it) }
            foundTournaments.ifEmpty { errors += "Tournaments" }
            result += foundTournaments
        }


        return Pair(result, errors)
    }

    override fun findGameWith(simpleSearch: String, dualSearch: String): MutableList<GameDTO> {
        var homeTeams = teamDao.findByNameStartingWith(simpleSearch)
        var awayTeams = teamDao.findByNameStartingWith(dualSearch)

        var homeGames = getGamesForTeams(homeTeams)
        var awayGames = getGamesForTeams(awayTeams)
        if (!(dualSearch == "*")) {
            return getGamesInCommon(homeGames, awayGames)
        } else {
            return getGamesWithRivals(homeGames)
        }
    }

    fun getGamesWithRivals(listOfGames: MutableList<TeamGameStats>): MutableList<GameDTO>{
        var gamesWithRivals = emptyList<GameDTO>().toMutableList()
        for (g in listOfGames){
            val rival = teamGameStatsDao.findByGameIdAndTeamIdNot(g.game.id, g.team.id)
            gamesWithRivals += GameDTO.fromModelGame(g, rival)
        }
        return gamesWithRivals
    }

    fun getGamesForTeams(listOfTeams : MutableList<Team>): MutableList<TeamGameStats> {

        var listOfGames: MutableList<TeamGameStats> = emptyList<TeamGameStats>().toMutableList()
        for (team in listOfTeams) {
            listOfGames += teamGameStatsDao.findByTeamNameStartingWith(team.name)
        }
        return listOfGames
    }

    fun getGamesInCommon(homeGames: MutableList<TeamGameStats>, awayGames: MutableList<TeamGameStats>): MutableList<GameDTO> {

        var gamesIdOfAway = awayGames.map {it.game.id}

        var result = getGamesWithRivals(homeGames.filter { gamesIdOfAway.contains(it.game.id) } as MutableList<TeamGameStats>)

        return result

    }

}