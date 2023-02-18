package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.controller.prototype.PlayerPrototype
import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.service.dto.PlayerDTO
import UNQ.TTIP.GOAT.service.impl.PlayerServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000", "http://192.168.0.13:3000", "http://192.168.0.13:8080"])
@RestController
@RequestMapping("/Player")
class PlayerController (@Autowired private val playerDao: PlayerDAO,
                        @Autowired private val playerTeamDao: PlayerTeamStatsDAO,
                        @Autowired private val teamDAO: TeamDAO){

    @Autowired
    var playerService: PlayerServiceImpl = PlayerServiceImpl(playerDao, playerTeamDao, teamDAO)

    @GetMapping("/{id}")
    fun getComponent(@PathVariable id: Long): PlayerDTO = playerService.findByDni(id)

    @PostMapping("")
    fun saveComponent(@RequestBody requestPlayer: PlayerPrototype): Long? = playerService.createPlayer(requestPlayer)
}