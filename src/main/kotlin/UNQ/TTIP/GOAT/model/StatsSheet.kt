package UNQ.TTIP.GOAT.model

class StatsSheet {
    var minutes = 0
    var points = 0
    var twoPointsMade = 0
    var twoPointsAttempted = 0
    var twoPointsPercentage = (twoPointsMade * 100) / twoPointsAttempted
    var threePointsMade = 0
    var threePointsAttempted = 0
    var threePointsPercentage = (threePointsMade * 100) / threePointsAttempted
    var freeThrowsMade = 0
    var freeThrowsAttempted = 0
    var freeThrowsPercentage = (freeThrowsMade * 100) / freeThrowsAttempted
    var offensiveRebounds = 0
    var defensiveRebounds = 0
    var totalRebounds = offensiveRebounds + defensiveRebounds
    var assists = 0
    var steals = 0
    var turnovers = 0
    var commitedBlocks = 0
    var recievedBlocks = 0
    var commitedFouls = 0
    var recievedFouls = 0

    val plusOne = { x: Int -> x + 1 }
}