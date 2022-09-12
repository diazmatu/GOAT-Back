package UNQ.TTIP.GOAT.model

import javax.persistence.*

@Entity
@Table(name = "team")
public class Team (var name: String,
                   var season: Int,
                   var category: Int,
                   @ManyToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                   var tournaments:List<Tournament> = mutableListOf()){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @ManyToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var players:List<Player> = mutableListOf()

    //Add Stats Sheet
}