package UNQ.TTIP.GOAT.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class StatsSheetTest {
    private val stats:StatsSheet = StatsSheet()

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun statsStartInZero(){
        assertEquals(stats.turnovers, 0)
        assertEquals(stats.steals, 0)
    }

    @Test
    fun plusOneForDifferentValues(){

        stats.plusOne(stats.turnovers)
        stats.plusOne(stats.turnovers)

        assertEquals(stats.turnovers, 1)
        assertEquals(stats.steals, 1)
    }
}