package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.dao.GameDAO
import UNQ.TTIP.GOAT.dao.PlayerDAO
import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.dao.TournamentDAO
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
                        @Autowired private val gameDao: GameDAO) {

    @Autowired
    var searchService: SearchServiceImpl = SearchServiceImpl(teamDao, playerDao, tournamentDao, gameDao)

    @GetMapping("/{name}")
    fun getResults(@PathVariable name: String):MutableList<SearchResultDTO> = searchService.findByNameStartingWith(name)

}