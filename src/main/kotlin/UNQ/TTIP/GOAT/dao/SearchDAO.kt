package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.service.dto.SearchResultDTO
import javax.persistence.Entity

interface SearchDAO {

    fun findByName(name: String): Collection<Entity>
    fun findByNameStartingWith(prefix: String): MutableList<SearchResultDTO>

}
