package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Tournament
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity

@Repository
interface TournamentDAO : JpaRepository<Tournament, Long?> {
    fun findById(id: Long?): MutableList<Tournament>
    fun findByName(name: String): MutableList<Tournament>
    fun findByNameStartingWith(prefix: String): MutableList<Tournament>
    fun findByTeamsIdTeamId(id: Long): MutableList<Tournament>
}
