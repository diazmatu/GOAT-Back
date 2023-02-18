package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.service.impl.ModelServiceImpl
import UNQ.TTIP.GOAT.service.dto.ModelDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000", "http://192.168.0.13:3000", "http://192.168.0.13:8080"])
@RestController
@RequestMapping("/model")
class ModelController (@Autowired private val teamDao:TeamDAO,
                       @Autowired private val playerDao:PlayerDAO,
                       @Autowired private val tournamentDao:TournamentDAO,
                       @Autowired private val gameDAO: GameDAO,
                       @Autowired private val teamGameStatsDao:TeamGameStatsDAO,
                       @Autowired private val playerGameStatsDAO: PlayerGameStatsDAO){

    @Autowired
    var modelService: ModelServiceImpl = ModelServiceImpl(teamDao, playerDao, tournamentDao, gameDAO, teamGameStatsDao, playerGameStatsDAO)

    @GetMapping("/{type}/{id}")
    fun getComponent(@PathVariable id: Long, @PathVariable type: String): ModelDTO = modelService.findData(id, type)

}
