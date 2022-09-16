package UNQ.TTIP.GOAT.service

import org.springframework.stereotype.Service
import javax.persistence.Entity

@Service
interface SearchService {

    fun findByName(name : String): Collection<Entity>
    abstract fun findByNameStartingWith(s: String): Collection<Entity>

}
