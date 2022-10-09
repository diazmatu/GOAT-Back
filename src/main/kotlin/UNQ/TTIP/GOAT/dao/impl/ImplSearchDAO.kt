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
                    @Autowired private val gameDao: GameDAO
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
    ): MutableList<SearchResultDTO> {

        val result : MutableList<SearchResultDTO> = emptyList<SearchResultDTO>().toMutableList()

        if (teamFilter)
            result += teamDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelTeam(it) }

        if (playerFilter) {
            result += playerDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelPlayer(it) }
            result += playerDao.findBySurnameStartingWith(prefix).map { SearchResultDTO.fromModelPlayer(it) }
        }

        if (tournamentFilter)
            result += tournamentDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelTournament(it) }
        //result += gameDao.findByTeamsNameStartingWith(prefix)

        return result
    }

    override fun findGameWith(simpleSearch: String, dualSearch: String): MutableList<GameDTO> {
        var homeTeams = teamDao.findByNameStartingWith(simpleSearch)
        var awayTeams = teamDao.findByNameStartingWith(dualSearch)

        var homeGames = getGamesForTeams(homeTeams)
        var awayGames = getGamesForTeams(awayTeams)
        if (!(dualSearch == "*")) {
            return gamesInCommon(homeGames, awayGames)
        } else {
            return homeGames.map { GameDTO.fromModelGame(it)} as MutableList<GameDTO>
        }
    }

    fun getGamesForTeams(listOfTeams : MutableList<Team>): MutableList<TeamGameStats> {

        var listOfGames: MutableList<TeamGameStats> = emptyList<TeamGameStats>().toMutableList()
        for (team in listOfTeams) {
            listOfGames += gameDao.findByTeamNameStartingWith(team.name)
        }
        return listOfGames
    }

    fun gamesInCommon(homeGames: MutableList<TeamGameStats>, awayGames: MutableList<TeamGameStats>): MutableList<GameDTO> {

        var gamesIdOfAway = awayGames.map {it.game.id}

        var result = homeGames.filter { gamesIdOfAway.contains(it.game.id) }.map { GameDTO.fromModelGame(it)} as MutableList<GameDTO>

        return result

    }

}