package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.service.dto.SearchResultDTO
import org.springframework.stereotype.Service
import javax.persistence.Entity

@Service
interface SearchService {

    fun findByName(name : String): Collection<Entity>
    fun findByNameStartingWith(s: String): MutableList<SearchResultDTO>

}
