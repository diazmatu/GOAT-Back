package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.ImageHandler
import UNQ.TTIP.GOAT.model.Tournament

class TournamentDTO(var name:String, var season:Int, var category:Int, var id:Long?, var type:String, var img: ByteArray) {
    companion object {
        fun fromModelTournament(entity: Tournament):TournamentDTO{
            return TournamentDTO(
                entity.name,
                entity.season,
                entity.category,
                entity.id,
                "Tournament",
                ImageHandler().findInFileSystem("Tournaments/" + entity.id + ".jpg")
            )
        }
    }

}