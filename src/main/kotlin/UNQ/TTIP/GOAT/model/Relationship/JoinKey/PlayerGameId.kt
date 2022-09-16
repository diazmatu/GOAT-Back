package UNQ.TTIP.GOAT.model.Relationship.JoinKey

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Player
import java.io.Serializable
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.ManyToOne

@Embeddable
class PlayerGameId(    @Column(name = "game_id")
                       private var gameId : Long?,

                       @Column(name = "player_dni")
                       private var playerDni: Int) : Serializable {
/*
        private constructor() {}
        constructor(
            teamId: Long?,
            tournamentId: Long?
        ) {
            this.teamId = teamId
            this.tournamentId = tournamentId
        }
*/

    //Getters omitted for brevity

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as PlayerGameId
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(playerDni, that.playerDni)
    }

    override fun hashCode(): Int {
        return Objects.hash(playerDni, gameId)
    }
}