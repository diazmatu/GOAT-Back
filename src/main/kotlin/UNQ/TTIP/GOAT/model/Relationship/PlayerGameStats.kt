package UNQ.TTIP.GOAT.model.Relationship

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.PlayerGameId
import UNQ.TTIP.GOAT.model.StatsSheet
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "player_games")
class PlayerGameStats (@ManyToOne( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                       @MapsId("player_dni")
                       var player : Player,

                       @ManyToOne( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                       @MapsId("game_id")
                       var game : Game,

                       @EmbeddedId
                       private var id: PlayerGameId = PlayerGameId(game.id, player.dni)) : StatsSheet() {

    @Column(columnDefinition = "boolean default false")
    var homeTeam = false

    companion object {

        fun createStats(player: Player, game: Game): PlayerGameStats {
            return(PlayerGameStats(
                player,
                game,
                PlayerGameId(game.id, player.dni)
            ))
        }
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that: PlayerGameStats = o as PlayerGameStats
        return Objects.equals(player, that.player) &&
                Objects.equals(game, that.game)
    }

    override fun hashCode(): Int {
        return Objects.hash(player, game)
    }
}