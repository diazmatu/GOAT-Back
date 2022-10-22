package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.PlayerGameStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.model.Tournament

class StatsDTO(var gameId: Long?, var modelId: Long?, var name: String, var type: String, var statsSheet:StatsSheetDTO) {

    companion object {
        fun fromGameTeam(teamGameStats: TeamGameStats): StatsDTO {
            return StatsDTO(
                teamGameStats.game.id,
                teamGameStats.team.id,
                teamGameStats.team.name,
                "Team",
                StatsSheetDTO.fromModelTeamGameStats(teamGameStats)
            )
        }

        fun fromGamePlayer(playerGameStats: PlayerGameStats): StatsDTO {
            return StatsDTO(
                playerGameStats.game.id,
                playerGameStats.player.dni,
                playerGameStats.player.name,
                "Player",
                StatsSheetDTO.fromModelPlayerGameStats(playerGameStats)

            )

        }
    }
}
