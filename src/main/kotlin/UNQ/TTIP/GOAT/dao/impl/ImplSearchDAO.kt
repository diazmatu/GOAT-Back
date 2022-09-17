package UNQ.TTIP.GOAT.dao.impl

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.service.dto.SearchResultDTO
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.Entity

class ImplSearchDAO(@Autowired private val teamDao: TeamDAO,
                    @Autowired private val playerDao: PlayerDAO,
                    @Autowired private val tournamentDao: TournamentDAO,
                    @Autowired private val gameDao: GameDAO
)
    : SearchDAO{

    override fun findByName(name: String): MutableList<Entity> {

        val result : MutableList<Entity> = emptyList<Entity>().toMutableList()

        result += teamDao.findByName(name) as MutableList<Entity>
        result += playerDao.findByName(name) as MutableList<Entity>
        result += playerDao.findBySurname(name) as MutableList<Entity>
        result += tournamentDao.findByName(name) as MutableList<Entity>
        //result += gameDao.findByTeamsName(name)

        return result
    }

    override fun findByNameStartingWith(prefix: String): MutableList<SearchResultDTO> {

        val result : MutableList<SearchResultDTO> = emptyList<SearchResultDTO>().toMutableList()

        result += teamDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelTeam(it) }
        result += playerDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelPlayer(it) }
        result += playerDao.findBySurnameStartingWith(prefix).map { SearchResultDTO.fromModelPlayer(it) }
        result += tournamentDao.findByNameStartingWith(prefix).map { SearchResultDTO.fromModelTournament(it) }
        //result += gameDao.findByTeamsNameStartingWith(prefix)

        return result
    }

}