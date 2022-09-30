package UNQ.TTIP.GOAT.model.Relationship

import UNQ.TTIP.GOAT.model.*
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.PlayerGameId
import UNQ.TTIP.GOAT.model.Relationship.JoinKey.TeamTournamentId
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "team_tournaments")
class TeamTournamentStats (@ManyToOne( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                           @MapsId("tournamentId")
                           var tournament : Tournament,

                           @ManyToOne( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                           @MapsId("teamId")
                           var team : Team,

                           @EmbeddedId
                           private var id: TeamTournamentId = TeamTournamentId(team.id, tournament.id )) : StatsSheet() {

    fun TeamTournamentStats(tournament: Tournament, team: Team) {
        this.tournament = tournament
        this.team = team
        this.id = TeamTournamentId(team.id, tournament.id )
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that: TeamTournamentStats = o as TeamTournamentStats
        return Objects.equals(tournament, that.tournament) &&
                Objects.equals(team, that.team)
    }

    override fun hashCode(): Int {
        return Objects.hash(tournament, team)
    }
}
