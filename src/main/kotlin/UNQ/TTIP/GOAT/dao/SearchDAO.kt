package UNQ.TTIP.GOAT.dao

import javax.persistence.Entity

interface SearchDAO {

    fun findByName(name: String): Collection<Entity>
    fun findByNameStartingWith(prefix: String): Collection<Entity>

}
