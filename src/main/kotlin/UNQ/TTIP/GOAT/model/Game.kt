package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.model.Relationship.PlayerGameStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import javax.persistence.*


@Entity
@Table(name = "game")
public class Game (@OneToMany (fetch= FetchType.LAZY)
                   @JoinColumn(name="team_id")
                   var teams : List<TeamGameStats> = mutableListOf(),

                   @ManyToOne (fetch= FetchType.LAZY)
                   @JoinColumn(name="tournament_id")
                   var tournament: Tournament){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null


    @OneToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY/*, mappedBy = "player"*/)
    @JoinColumn(name="player_dni")
    var players : List<PlayerGameStats> = mutableListOf()

    //Add Stats Sheet
}


