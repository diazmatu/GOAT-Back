package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Team

class GameDTO(var id: Long?, var teamName: String){
    companion object {
        fun fromModelGame(entity: TeamGameStats): GameDTO {
            return GameDTO(
                entity.game.id,
                entity.team.name)
        }
        fun fromGame(entity: Game): GameDTO {
            return GameDTO(
                entity.id,
                "Partido")
        }
    }
}