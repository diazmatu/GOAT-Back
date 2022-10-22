package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.ImageHandler
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.model.Tournament
import org.springframework.core.io.FileSystemResource

class SearchResultDTO(var name:String, var id:Long?, var type: String, var img: ByteArray) {

    var surname : String? = null


    companion object {
        private fun getImage(id: Long?, type: String): ByteArray {
            return ImageHandler().findInFileSystem(type + "s/" + id + ".jpg")
        }

        fun fromModelTeam(entity: Team):SearchResultDTO{
            return SearchResultDTO(
                entity.name,
                entity.id,
                "Team",
                getImage(entity.id, "Team")
            )
        }
        fun fromModelTournament(entity: Tournament):SearchResultDTO{
            return SearchResultDTO(
                entity.name,
                entity.id,
                "Tournament",
                getImage(entity.id,"Tournament")
            )
        }
        fun fromModelPlayer(entity: Player):SearchResultDTO{
             var player =SearchResultDTO(
                entity.name,
                entity.dni,
                "Player",
                 getImage(entity.dni, "Player")
            )
            player.surname = entity.surname
            return player
        }
    }
}
