package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.ImageHandler
import UNQ.TTIP.GOAT.model.Player
import java.sql.Date

class PlayerDTO(var name:String, var surname:String, var birth:Date, var id:Long?, var type:String, var img: ByteArray, var statsSheet:StatsSheetDTO) {
    companion object {
        fun fromModelPlayer(entity: Player):PlayerDTO{
            return PlayerDTO(
                entity.name,
                entity.surname,
                entity.birth,
                entity.dni,
                "Player",
                ImageHandler().findInFileSystem("Players/" + entity.dni + ".jpg"),
                StatsSheetDTO.fromModelPlayerStats(entity)
            )
        }
    }

}
