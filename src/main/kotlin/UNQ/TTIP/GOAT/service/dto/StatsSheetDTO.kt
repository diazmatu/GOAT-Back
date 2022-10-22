package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.PlayerGameStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Team
import javax.persistence.Entity

class StatsSheetDTO (    var minutes:Int,
                         var points:Int,
                         var twoPointsMade:Int,
                         var twoPointsAttempted:Int,
                         var twoPointsPercentage:Int,
                         var threePointsMade:Int,
                         var threePointsAttempted:Int,
                         var threePointsPercentage:Int,
                         var freeThrowsMade:Int,
                         var freeThrowsAttempted:Int,
                         var freeThrowsPercentage:Int,
                         var offensiveRebounds:Int,
                         var defensiveRebounds:Int,
                         var totalRebounds:Int,
                         var assists:Int,
                         var steals:Int,
                         var turnovers:Int,
                         var commitedBlocks:Int,
                         var recievedBlocks:Int,
                         var commitedFouls:Int,
                         var recievedFouls:Int) {

    companion object {
        fun fromModelTeamStats(entity: Team):StatsSheetDTO = StatsSheetDTO(
            entity.minutes,
            entity.points,
            entity.twoPointsMade,
            entity.twoPointsAttempted,
            entity.twoPointsPercentage,
            entity.threePointsMade,
            entity.threePointsAttempted,
            entity.threePointsPercentage,
            entity.freeThrowsMade,
            entity.freeThrowsAttempted,
            entity.freeThrowsPercentage,
            entity.offensiveRebounds,
            entity.defensiveRebounds,
            entity.totalRebounds,
            entity.assists,
            entity.steals,
            entity.turnovers,
            entity.commitedBlocks,
            entity.recievedBlocks,
            entity.commitedFouls,
            entity.recievedFouls
        )

        fun fromModelTeamGameStats(entity: TeamGameStats):StatsSheetDTO = StatsSheetDTO(
            entity.minutes,
            entity.points,
            entity.twoPointsMade,
            entity.twoPointsAttempted,
            entity.twoPointsPercentage,
            entity.threePointsMade,
            entity.threePointsAttempted,
            entity.threePointsPercentage,
            entity.freeThrowsMade,
            entity.freeThrowsAttempted,
            entity.freeThrowsPercentage,
            entity.offensiveRebounds,
            entity.defensiveRebounds,
            entity.totalRebounds,
            entity.assists,
            entity.steals,
            entity.turnovers,
            entity.commitedBlocks,
            entity.recievedBlocks,
            entity.commitedFouls,
            entity.recievedFouls
        )

        fun fromModelPlayerStats(entity: Player):StatsSheetDTO = StatsSheetDTO(
            entity.minutes,
            entity.points,
            entity.twoPointsMade,
            entity.twoPointsAttempted,
            entity.twoPointsPercentage,
            entity.threePointsMade,
            entity.threePointsAttempted,
            entity.threePointsPercentage,
            entity.freeThrowsMade,
            entity.freeThrowsAttempted,
            entity.freeThrowsPercentage,
            entity.offensiveRebounds,
            entity.defensiveRebounds,
            entity.totalRebounds,
            entity.assists,
            entity.steals,
            entity.turnovers,
            entity.commitedBlocks,
            entity.recievedBlocks,
            entity.commitedFouls,
            entity.recievedFouls
        )

        fun fromModelPlayerGameStats(entity: PlayerGameStats):StatsSheetDTO = StatsSheetDTO(
            entity.minutes,
            entity.points,
            entity.twoPointsMade,
            entity.twoPointsAttempted,
            entity.twoPointsPercentage,
            entity.threePointsMade,
            entity.threePointsAttempted,
            entity.threePointsPercentage,
            entity.freeThrowsMade,
            entity.freeThrowsAttempted,
            entity.freeThrowsPercentage,
            entity.offensiveRebounds,
            entity.defensiveRebounds,
            entity.totalRebounds,
            entity.assists,
            entity.steals,
            entity.turnovers,
            entity.commitedBlocks,
            entity.recievedBlocks,
            entity.commitedFouls,
            entity.recievedFouls
        )
    }

}
