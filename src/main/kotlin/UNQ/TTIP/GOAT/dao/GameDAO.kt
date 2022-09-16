package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity

@Repository
interface GameDAO : JpaRepository<TeamGameStats, Long?> {
    fun findByTeamId(name: String): Collection<Game>
    //fun findByNameStartingWith(prefix: String): Collection<Game>

    //fun findAll(): List<Team>
}