package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.ImageHandler
import UNQ.TTIP.GOAT.model.Team

class TeamDTO(var name:String, var season:Int, var category:Int, var id:Long?, var type:String, var img: ByteArray, var tournamentName: List<String>, var statsSheet:StatsSheetDTO) {
    companion object {
        fun fromModelTeam(entity: Team, tournamentName: List<String>):TeamDTO{
            return TeamDTO(
                entity.name,
                entity.season,
                entity.category,
                entity.id,
                "Team",
                ImageHandler().findInFileSystem("Teams/" + entity.id + ".jpg"),
                tournamentName,
                StatsSheetDTO.fromModelTeamStats(entity)
            )
        }
    }
}
