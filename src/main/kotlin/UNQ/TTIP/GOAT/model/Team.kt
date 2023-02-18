package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.model.Relationship.PlayerTeamStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Relationship.TeamTournamentStats
import javax.persistence.*

@Entity
@Table(name = "team")
public class Team (var name: String,

                   var season: Int,

                   var category: Int,

                   var profileImage: String,

                   @OneToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY/*, mappedBy = "team", orphanRemoval = true*/)
                   @JoinColumn(name = "team_id")
                   var tournaments : List<TeamTournamentStats> = mutableListOf()
)
    :StatsSheet(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @OneToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var players : List<PlayerTeamStats> = mutableListOf()

    @OneToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var games : List<TeamGameStats> = mutableListOf()

    //Add Stats Sheet
}