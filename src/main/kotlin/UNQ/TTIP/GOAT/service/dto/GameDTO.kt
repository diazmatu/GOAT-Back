package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Team

class GameDTO(var id: Long?, var teamA: TeamDTO, var teamB: TeamDTO, var type: String){
    companion object {
        fun fromModelGame(entityA: TeamGameStats, entityB: TeamGameStats): GameDTO {
            return GameDTO(
                entityA.game.id,
                TeamDTO.fromModelTeam(entityA.team),
                TeamDTO.fromModelTeam(entityB.team),
                "Game"
            )
        }
        fun fromGame(entity: Game): GameDTO {
            return GameDTO(
                entity.id,
                TeamDTO.fromModelTeam(entity.teams[0].team),
                TeamDTO.fromModelTeam(entity.teams[1].team),
                "Game"
            )
        }
    }
}