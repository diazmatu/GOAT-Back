package UNQ.TTIP.GOAT.service.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.dao.impl.ImplSearchDAO
import UNQ.TTIP.GOAT.service.SearchService
import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.dto.SearchResultDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.Entity

@Service
class SearchServiceImpl(@Autowired private val teamDao: TeamDAO,
                        @Autowired private val playerDao: PlayerDAO,
                        @Autowired private val tournamentDao: TournamentDAO,
                        @Autowired private val teamGameStatsDao: TeamGameStatsDAO
) : SearchService {

    //@Autowired
    //lateinit var implSearchDAO: ImplSearchDAO

    //@Autowired
    //lateinit var teamDao: TeamDAO

    private val searchDao: ImplSearchDAO = ImplSearchDAO( teamDao, playerDao, tournamentDao, teamGameStatsDao)

    override fun findByName(name : String): MutableList<Entity> {
        return searchDao.findByName(name)
    }

    override fun findByNameStartingWith(
        prefix: String,
        tournamentFilter: Boolean,
        teamFilter: Boolean,
        playerFilter: Boolean
    ): Pair<MutableList<SearchResultDTO>, MutableList<String>> {
        return searchDao.findByNameStartingWith(prefix, tournamentFilter, teamFilter, playerFilter)
    }

    override fun findGameWith(simpleSearch: String, dualSearch: String): MutableList<GameDTO> {
        return searchDao.findGameWith(simpleSearch, dualSearch)
    }

}
