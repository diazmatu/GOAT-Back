package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.model.Relationship.JoinKey.PlayerTeamId
import UNQ.TTIP.GOAT.model.Relationship.PlayerTeamStats
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerTeamStatsDAO : JpaRepository<PlayerTeamStats, Long?> {

}
