package UNQ.TTIP.GOAT.service.impl

import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.service.TeamService
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl (@Autowired private val teamDao: TeamDAO) : TeamService{

    override fun allTeams(): List<Team> {
        return teamDao.findAll() ?: emptyList();
        //return runTrx { teamDAO.findAll() } ?: emptyList<Team>()
    }

    override fun findById(id: Long): TeamDTO {
        return TeamDTO.fromModelTeam(teamDao.findById(id).orElse(null))
    }

    fun findByName(name: String): MutableList<Team> {
        return teamDao.findByName(name)
    }

    fun findByNameStartingWith(prefix: String): MutableList<Team> {
        return teamDao.findByNameStartingWith(prefix)
    }

}