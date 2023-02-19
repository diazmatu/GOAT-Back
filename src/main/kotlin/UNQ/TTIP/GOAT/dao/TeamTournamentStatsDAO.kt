package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamTournamentId
import UNQ.TTIP.GOAT.model.Relationship.TeamTournamentStats
import org.springframework.data.jpa.repository.JpaRepository

interface TeamTournamentStatsDAO : JpaRepository<TeamTournamentStats, TeamTournamentId?> {

}
