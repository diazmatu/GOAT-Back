package UNQ.TTIP.GOAT.controller

import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import UNQ.TTIP.GOAT.service.impl.TeamServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
@RestController
@RequestMapping("/Team")
class TeamController (@Autowired private val teamDao: TeamDAO){

    @Autowired
    var teamService: TeamServiceImpl = TeamServiceImpl(teamDao)

    @GetMapping("/{id}")
    fun getComponent(@PathVariable id: Long): TeamDTO = teamService.findById(id)

    @PostMapping("")
    fun saveComponent(@RequestBody requestTeam: Team): Long? = teamService.createTeam(requestTeam)
}