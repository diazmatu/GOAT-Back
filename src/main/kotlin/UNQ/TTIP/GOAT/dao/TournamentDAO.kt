package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Tournament
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TournamentDAO : JpaRepository<Tournament, Long?> {
    fun findByName(name: String): Collection<Tournament>
    fun findByNameStartingWith(prefix: String): Collection<Tournament>

    //fun findAll(): List<Team>
}
