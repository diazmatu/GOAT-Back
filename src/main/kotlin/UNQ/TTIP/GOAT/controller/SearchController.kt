package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.dao.TeamGameStatsDAO
import UNQ.TTIP.GOAT.dao.PlayerDAO
import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.dao.TournamentDAO
import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.dto.SearchResultDTO
import UNQ.TTIP.GOAT.service.impl.SearchServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
@RestController
@RequestMapping("/search")
class SearchController (@Autowired private val teamDao: TeamDAO,
                        @Autowired private val playerDao: PlayerDAO,
                        @Autowired private val tournamentDao: TournamentDAO,
                        @Autowired private val teamGameStatsDao: TeamGameStatsDAO) {

    @Autowired
    var searchService: SearchServiceImpl = SearchServiceImpl(teamDao, playerDao, tournamentDao, teamGameStatsDao)

    @GetMapping("/simpleSearch/{search}")
    fun getSimpleResults(@PathVariable search: String, @RequestParam tournamentFilter: Boolean, @RequestParam teamFilter: Boolean, @RequestParam playerFilter: Boolean):Pair<MutableList<SearchResultDTO>, MutableList<String>> {

        return searchService.findByNameStartingWith(search, tournamentFilter, teamFilter, playerFilter)
    }

    @GetMapping("/dualSearch/{simpleSearch}/{dualSearch}")
    fun getDualResults(@PathVariable simpleSearch: String, @PathVariable dualSearch: String):MutableList<GameDTO> {
        return searchService.findGameWith(simpleSearch, dualSearch)
    }
}