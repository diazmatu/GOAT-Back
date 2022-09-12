package UNQ.TTIP.GOAT.model

import javax.persistence.*

@Entity
@Table(name = "tournament")
public class Tournament (var name: String,
                       var season: Int,
                       var category: Int){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @ManyToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var teams:List<Team> = mutableListOf()
}