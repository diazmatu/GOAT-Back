package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.dao.PlayerDAO
import UNQ.TTIP.GOAT.service.dto.PlayerDTO
import UNQ.TTIP.GOAT.service.impl.PlayerServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
@RestController
@RequestMapping("/Player")
class PlayerController (@Autowired private val playerDao: PlayerDAO){

    @Autowired
    var playerService: PlayerServiceImpl = PlayerServiceImpl(playerDao)

    @GetMapping("/{id}")
    fun getComponent(@PathVariable id: Long): PlayerDTO = playerService.findByDni(id)

}