package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import org.springframework.stereotype.Service

@Service
interface TeamService{

    fun allTeams(): Collection<Team>
    fun findById(id: Long): TeamDTO

}
