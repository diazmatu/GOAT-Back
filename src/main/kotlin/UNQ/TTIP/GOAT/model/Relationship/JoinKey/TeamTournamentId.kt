package UNQ.TTIP.GOAT.model.Relationship.JoinKey

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class TeamTournamentId(@Column(name = "team_id")
                       private var teamId : Long?,

                       @Column(name = "tournament_id")
                       private var tournamentId: Long?) : Serializable {

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
        val that = o as TeamTournamentId
        return Objects.equals(teamId, that.teamId) &&
                Objects.equals(tournamentId, that.tournamentId)
    }

    override fun hashCode(): Int {
        return Objects.hash(tournamentId, teamId)
    }
}