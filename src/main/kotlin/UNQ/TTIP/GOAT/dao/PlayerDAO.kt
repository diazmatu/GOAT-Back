package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity

@Repository
interface PlayerDAO : JpaRepository<Player, Int?> {

    fun findByDni(dni: Long): Player
    fun findByName(name: String): MutableList<Player>
    fun findBySurname(name: String): MutableList<Player>
    fun findByNameStartingWith(prefix: String): MutableList<Player>
    fun findBySurnameStartingWith(prefix: String): MutableList<Player>
    fun findByTeamsIdTeamId(id: Long): MutableList<Player>

    //fun findAll(): List<Team>
}