package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.dao.impl.ImplSearchDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.Entity

@Service
class SearchServiceImpl(@Autowired private val teamDao: TeamDAO,
                        @Autowired private val playerDao: PlayerDAO,
                        @Autowired private val tournamentDao: TournamentDAO,
                        @Autowired private val gameDao: GameDAO
) : SearchService{

    private val searchDao: ImplSearchDAO = ImplSearchDAO(teamDao, playerDao, tournamentDao, gameDao)

    override fun findByName(name : String): Collection<Entity> {
        return searchDao.findByName(name)
    }

    override fun findByNameStartingWith(prefix: String): List<Entity> {
        return searchDao.findByNameStartingWith(prefix)
    }

}
