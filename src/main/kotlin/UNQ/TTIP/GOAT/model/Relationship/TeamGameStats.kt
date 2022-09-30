package UNQ.TTIP.GOAT.model.Relationship

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamGameId
import UNQ.TTIP.GOAT.model.StatsSheet
import UNQ.TTIP.GOAT.model.Team
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "team_games")
class TeamGameStats (@ManyToOne( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                     @MapsId("teamId")
                     var team : Team,

                     @ManyToOne( cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
                     @MapsId("gameId")
                     var game : Game,

                     @EmbeddedId
                     private var id: TeamGameId = TeamGameId(game.id, team.id),
)
    : StatsSheet() {

    private fun TeamGameStats() {}

    fun TeamGameStats(team: Team, game: Game) {
        this.team = team
        this.game = game
        this.id = TeamGameId(game.id, team.id )
    }



    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that: TeamGameStats = o as TeamGameStats
        return Objects.equals(team, that.team) &&
                Objects.equals(game, that.game)
    }

    override fun hashCode(): Int {
        return Objects.hash(team, game)
    }
}
