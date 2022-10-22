package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.dao.TeamGameStatsDAO
import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.impl.GameServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
@RestController
@RequestMapping("/Game")
class GameController (@Autowired private val teamGameStatsDAO: TeamGameStatsDAO){

    @Autowired
    var gameService: GameServiceImpl = GameServiceImpl(teamGameStatsDAO)

    @GetMapping("/{id}")
    fun getComponent(@PathVariable id: Long): GameDTO = gameService.findByGameId(id)

}