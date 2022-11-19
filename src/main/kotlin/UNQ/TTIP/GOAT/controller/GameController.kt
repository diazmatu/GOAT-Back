package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Tournament
import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.impl.GameServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000", "http://192.168.0.13:3000", "http://192.168.0.13:8080"])
@RestController
@RequestMapping("/Game")
class GameController (@Autowired private val tournamentDao: TournamentDAO,
                      @Autowired private val teamDao: TeamDAO,
                      @Autowired private val playerDao: PlayerDAO,
                      @Autowired private val gameDAO: GameDAO,
                      @Autowired private val teamGameStatsDAO: TeamGameStatsDAO,
                      @Autowired private val playerGameStatsDAO: PlayerGameStatsDAO){

    @Autowired
    var gameService: GameServiceImpl = GameServiceImpl(tournamentDao, teamDao, playerDao, gameDAO, teamGameStatsDAO, playerGameStatsDAO)

    @GetMapping("/{id}")
    fun getComponent(@PathVariable id: Long): GameDTO = gameService.findByGameId(id)

    @PostMapping("")
    fun saveComponent(@RequestBody requestGame: GamePrototype): Long? {
        return gameService.createGame(requestGame)
    }
}