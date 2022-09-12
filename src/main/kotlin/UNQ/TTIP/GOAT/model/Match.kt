package UNQ.TTIP.GOAT.model

import javax.persistence.*

@Entity
@Table(name = "match")
class Match (@OneToOne ( fetch= FetchType.EAGER)
             var homeTeam : Team,
             @OneToOne ( fetch= FetchType.EAGER)
             var awayTeam: Team,
             @OneToOne ( fetch= FetchType.LAZY)
             var tournament: Tournament){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    //Add Stats Sheet
}