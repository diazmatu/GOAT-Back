package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Tournament

class GameDTO(var id: Long?, var homeTeam: TeamDTO, var awayTeam: TeamDTO, var tournamentId: Long?, var type: String){
    companion object {
        fun fromModelGame(entityA: TeamGameStats, entityB: TeamGameStats): GameDTO {
            return GameDTO(
                entityA.game.id,
                TeamDTO.fromModelTeam(entityA.team, entityA.game.tournament.name),
                TeamDTO.fromModelTeam(entityB.team, entityA.game.tournament.name),
                entityA.game.tournament.id,
                "Game"
            )
        }
        fun fromGame(entity: Game): GameDTO {
            return GameDTO(
                entity.id,
                TeamDTO.fromModelTeam(entity.teams[0].team, entity.tournament.name),
                TeamDTO.fromModelTeam(entity.teams[1].team, entity.tournament.name),
                entity.tournament.id,
                "Game"
            )
        }
    }
}