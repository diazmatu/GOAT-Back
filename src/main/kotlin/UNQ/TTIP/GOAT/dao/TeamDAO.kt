package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamDAO : JpaRepository<Team, Long?> {
    fun findByName(name: String): Collection<Team>
    fun findByNameStartingWith(prefix: String): Collection<Team>

    //fun findAll(): List<Team>
}