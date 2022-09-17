package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity

@Repository
interface TeamDAO : JpaRepository<Team, Long?> {
    fun findByName(name: String): MutableList<Team>
    fun findByNameStartingWith(prefix: String): MutableList<Team>

    //fun findAll(): List<Team>
}