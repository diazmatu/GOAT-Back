package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.model.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl (@Autowired private val teamDao: TeamDAO) : TeamService{

    override fun allTeams(): List<Team> {
        return teamDao.findAll() ?: emptyList();
        //return runTrx { teamDAO.findAll() } ?: emptyList<Team>()
    }

    fun findByName(name: String): Collection<Team> {
        return teamDao.findByName(name)
    }

    fun findByNameStartingWith(prefix: String): Collection<Team> {
        return teamDao.findByNameStartingWith(prefix)
    }

}