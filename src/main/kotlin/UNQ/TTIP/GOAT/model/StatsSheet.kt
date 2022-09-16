package UNQ.TTIP.GOAT.model

import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class StatsSheet {
    @Column(columnDefinition = "integer default 0")
    var minutes = 0
    @Column(columnDefinition = "integer default 0")
    var points = 0
    @Column(columnDefinition = "integer default 0")
    var twoPointsMade = 0
    @Column(columnDefinition = "integer default 0")
    var twoPointsAttempted = 0
    @Column(columnDefinition = "integer default 0")
    var twoPointsPercentage = 0
    @Column(columnDefinition = "integer default 0")
    var threePointsMade = 0
    @Column(columnDefinition = "integer default 0")
    var threePointsAttempted = 0
    @Column(columnDefinition = "integer default 0")
    var threePointsPercentage = 0
    @Column(columnDefinition = "integer default 0")
    var freeThrowsMade = 0
    @Column(columnDefinition = "integer default 0")
    var freeThrowsAttempted = 0
    @Column(columnDefinition = "integer default 0")
    var freeThrowsPercentage = 0
    @Column(columnDefinition = "integer default 0")
    var offensiveRebounds = 0
    @Column(columnDefinition = "integer default 0")
    var defensiveRebounds = 0
    @Column(columnDefinition = "integer default 0")
    var totalRebounds = offensiveRebounds + defensiveRebounds
    @Column(columnDefinition = "integer default 0")
    var assists = 0
    @Column(columnDefinition = "integer default 0")
    var steals = 0
    @Column(columnDefinition = "integer default 0")
    var turnovers = 0
    @Column(columnDefinition = "integer default 0")
    var commitedBlocks = 0
    @Column(columnDefinition = "integer default 0")
    var recievedBlocks = 0
    @Column(columnDefinition = "integer default 0")
    var commitedFouls = 0
    @Column(columnDefinition = "integer default 0")
    var recievedFouls = 0

    //val plusOne = { x: Int -> x + 1 }
    //val percentage = {x: Int, y:Int -> (x * 100) / y}
}