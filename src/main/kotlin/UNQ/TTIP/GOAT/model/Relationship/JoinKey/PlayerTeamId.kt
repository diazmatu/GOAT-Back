package UNQ.TTIP.GOAT.model.Relationship.JoinKey

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class PlayerTeamId(@Column(name = "team_id")
                   private var teamId : Long?,

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
        val that = o as PlayerTeamId
        return Objects.equals(teamId, that.teamId) &&
                Objects.equals(playerDni, that.playerDni)
    }

    override fun hashCode(): Int {
        return Objects.hash(playerDni, teamId)
    }
}