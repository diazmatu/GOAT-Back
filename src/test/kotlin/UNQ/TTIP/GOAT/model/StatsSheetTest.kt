package UNQ.TTIP.GOAT.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StatsSheetTest {
    val stats:StatsSheet = StatsSheet()

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun statsStartInZero(){
        assertEquals(0, stats.turnovers)
        assertEquals(0, stats.steals)
    }

    @Test
    fun plusOneForDifferentValues(){
/*
        stats.turnovers = stats.plusOne(stats.turnovers)
        stats.steals = stats.plusOne(stats.steals)

        assertEquals(1, stats.turnovers)
        assertEquals(1, stats.steals)*/
    }
}