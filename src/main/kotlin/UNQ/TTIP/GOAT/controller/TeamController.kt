package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.controller.prototype.TeamPrototype
import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.dao.TeamTournamentStatsDAO
import UNQ.TTIP.GOAT.dao.TournamentDAO
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import UNQ.TTIP.GOAT.service.impl.TeamServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000", "http://192.168.0.13:3000", "http://192.168.0.13:8080"])
@RestController
@RequestMapping("/Team")
class TeamController (@Autowired private val teamDao: TeamDAO,
                      @Autowired private val teamTournamentDAO: TeamTournamentStatsDAO,
                      @Autowired private val tournamentDAO: TournamentDAO){

    @Autowired
    var teamService: TeamServiceImpl = TeamServiceImpl(teamDao, teamTournamentDAO, tournamentDAO)

    @GetMapping("/{id}")
    fun getComponent(@PathVariable id: Long): TeamDTO = teamService.findById(id)

    @PostMapping("")
    fun saveComponent(@RequestBody requestTeam: TeamPrototype) = teamService.createTeam(requestTeam)
}