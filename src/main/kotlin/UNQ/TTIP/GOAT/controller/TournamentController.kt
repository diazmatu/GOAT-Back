package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.dao.TournamentDAO
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import UNQ.TTIP.GOAT.service.dto.TournamentDTO
import UNQ.TTIP.GOAT.service.impl.TournamentServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
@RestController
@RequestMapping("/Tournament")
class TournamentController (@Autowired private val tournamentDAO: TournamentDAO){

    @Autowired
    var tournamentService: TournamentServiceImpl = TournamentServiceImpl(tournamentDAO)

    @GetMapping("/{id}")
    fun getComponent(@PathVariable id: Long): TournamentDTO = tournamentService.findById(id)

}