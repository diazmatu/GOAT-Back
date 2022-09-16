package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerDAO : JpaRepository<Player, Int?> {

    fun findByName(name: String): Collection<Player>
    fun findBySurname(name: String): Collection<Player>
    fun findByNameStartingWith(prefix: String): Collection<Player>
    fun findBySurnameStartingWith(prefix: String): Collection<Player>

    //fun findAll(): List<Team>
}