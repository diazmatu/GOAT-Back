package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Player
import java.sql.Date

class PlayerDTO(var name:String, var surname:String, var birth:Date, var dni:Long?, var statsSheet:StatsSheetDTO) {
    companion object {
        fun fromModelPlayer(entity: Player):PlayerDTO{
            return PlayerDTO(
                entity.name,
                entity.surname,
                entity.birth,
                entity.dni,
                StatsSheetDTO.fromModelPlayerStats(entity)
            )
        }
    }

}
