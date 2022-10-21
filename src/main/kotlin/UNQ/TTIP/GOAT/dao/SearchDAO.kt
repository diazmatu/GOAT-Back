package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.dto.SearchResultDTO
import javax.persistence.Entity

interface SearchDAO {

    fun findByName(name: String): Collection<Entity>
    fun findByNameStartingWith(prefix: String, tournamentFilter: Boolean, teamFilter: Boolean, playerFilter: Boolean): Pair<MutableList<SearchResultDTO>, MutableList<String>>
    fun findGameWith(simpleSearch: String, dualSearch: String): MutableList<GameDTO>

}
