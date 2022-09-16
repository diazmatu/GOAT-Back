package UNQ.TTIP.GOAT.dao.impl

import UNQ.TTIP.GOAT.dao.*
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.Entity

class ImplSearchDAO(@Autowired private val teamDao: TeamDAO,
                    @Autowired private val playerDao: PlayerDAO,
                    @Autowired private val tournamentDao: TournamentDAO,
                    @Autowired private val gameDao: GameDAO
)
    : SearchDAO{

    override fun findByName(name: String): Collection<Entity> {

        var result : List<Entity> = emptyList()

        result += teamDao.findByName(name) as List<Entity>
        result += playerDao.findByName(name) as List<Entity>
        result += playerDao.findBySurname(name) as List<Entity>
        result += tournamentDao.findByName(name) as List<Entity>
        //result += gameDao.findByTeamsName(name)

        return result
    }

    override fun findByNameStartingWith(prefix: String): List<Entity> {

        var result : List<Entity> = emptyList()

        result += teamDao.findByNameStartingWith(prefix) as List<Entity>
        result += playerDao.findByNameStartingWith(prefix) as List<Entity>
        result += playerDao.findBySurnameStartingWith(prefix) as List<Entity>
        result += tournamentDao.findByNameStartingWith(prefix) as List<Entity>
        //result += gameDao.findByTeamsNameStartingWith(prefix)

        return result
    }

}