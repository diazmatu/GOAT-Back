package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.model.Relationship.TeamTournamentStats
import javax.persistence.*

@Entity
@Table(name = "tournament")
public class Tournament (var name: String,
                         var season: Int,
                         var category: Int,
                         var profileImage: String){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @OneToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="tournament_id")
    var teams : List<TeamTournamentStats> = mutableListOf()

    @OneToMany( cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name="tournament_id")
    var games : List<Game> = mutableListOf()

}