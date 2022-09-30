package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Team

class TeamDTO(var name:String, var season:Int, var category:Int, var id:Long?, var statsSheet:StatsSheetDTO) {
    companion object {
        fun fromModelTeam(entity: Team):TeamDTO{
            return TeamDTO(
                entity.name,
                entity.season,
                entity.category,
                entity.id,
                StatsSheetDTO.fromModelTeamStats(entity)
            )
        }
    }
}
