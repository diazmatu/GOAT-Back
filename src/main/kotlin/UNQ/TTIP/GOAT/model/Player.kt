package UNQ.TTIP.GOAT.model

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "player")
public class Player (@Id
                     @Column(name = "dni", nullable = false)
                     var dni: Int,
                     var name: String,
                     var surname: String,
                     var birth: Date,
                     @ManyToMany( cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                     var teams:List<Team> = mutableListOf()) {

    // Add Additional Data
    //Add Stats Sheet
}