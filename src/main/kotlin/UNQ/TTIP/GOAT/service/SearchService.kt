package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.dto.SearchResultDTO
import org.springframework.stereotype.Service
import javax.persistence.Entity

@Service
interface SearchService {

    fun findByName(name : String): Collection<Entity>
    fun findByNameStartingWith(s: String, tournamentFilter: Boolean, teamFilter: Boolean, playerFilter: Boolean): Pair<MutableList<SearchResultDTO>, MutableList<String>>
    fun findGameWith(simpleSearch: String, dualSearch: String): MutableList<GameDTO>

}
