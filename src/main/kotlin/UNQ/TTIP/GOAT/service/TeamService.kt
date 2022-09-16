package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.model.Team
import org.springframework.stereotype.Service

@Service
interface TeamService{

    fun allTeams(): Collection<Team>

}
