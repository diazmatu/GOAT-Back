package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.model.Relationship.PlayerGameStats
import UNQ.TTIP.GOAT.model.Relationship.PlayerTeamStats
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "player")
public class Player(@Id
                     @Column(name = "dni", nullable = false)
                    var dni: Long,
                    var name: String,
                    var surname: String,
                    var birth: Date,

                    @OneToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                     @JoinColumn(name="player_dni")
                    var teams: List<PlayerTeamStats> = mutableListOf())
    :StatsSheet() {

    @OneToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="player_dni")
    var games : List<PlayerGameStats> = mutableListOf()

    // Add Additional Data
}