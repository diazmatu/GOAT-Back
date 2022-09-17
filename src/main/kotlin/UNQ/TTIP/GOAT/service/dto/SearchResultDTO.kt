package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.model.Tournament
import java.util.*
import javax.persistence.Entity
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class SearchResultDTO(var name:String, var id:Long?, var type: String) {

    var surname : String? = null

    companion object {
        fun fromModelTeam(entity: Team):SearchResultDTO{
            return SearchResultDTO(
                entity.name,
                entity.id,
                "Team"
            )
        }
        fun fromModelTournament(entity: Tournament):SearchResultDTO{
            return SearchResultDTO(
                entity.name,
                entity.id,
                "Tournament"
            )
        }
        fun fromModelPlayer(entity: Player):SearchResultDTO{
             var player =SearchResultDTO(
                entity.name,
                entity.dni,
                "Player"
            )
            player.surname = entity.surname
            return player
        }
    }
}
