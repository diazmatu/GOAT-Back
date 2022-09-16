package UNQ.TTIP.GOAT.model.Relationship

import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.PlayerTeamId
import UNQ.TTIP.GOAT.model.StatsSheet
import UNQ.TTIP.GOAT.model.Team
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "player_teams")
class PlayerTeamStats (@ManyToOne( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                       @MapsId("playerDni")
                       var player : Player,

                       @ManyToOne( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                       @MapsId("teamId")
                       var team : Team,

                       @EmbeddedId
                       private val id: PlayerTeamId = PlayerTeamId(team.id, player.dni )
) : StatsSheet() {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that: PlayerTeamStats = o as PlayerTeamStats
        return Objects.equals(player, that.player) &&
                Objects.equals(team, that.team)
    }

    override fun hashCode(): Int {
        return Objects.hash(player, team)
    }
}