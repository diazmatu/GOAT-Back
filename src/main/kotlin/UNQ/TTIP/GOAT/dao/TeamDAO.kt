package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.Entity

@Repository
interface TeamDAO : JpaRepository<Team, Long?> {

    fun findByName(name: String): MutableList<Team>
    fun findByNameStartingWith(prefix: String): MutableList<Team>

    //fun findAll(): List<Team>
}