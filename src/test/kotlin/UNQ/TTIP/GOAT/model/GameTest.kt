package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.dao.TeamGameStatsDAO
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.dto.GameDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@DisplayName("Game Tests")
//@Sql("/data.sql") //Set de datos usado para la prueba de test
class GameTest (@Autowired private val teamGameStatsDao: TeamGameStatsDAO){

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun dtoFromModelTeam() {
        var entityTeam = Team("Equipo", 2022, 19, "Image", emptyList())
        var entityGame = Game(emptyList(), Tournament("Torneo", 2022, 19, "Image"))
        entityGame.id = 1
        var entitySearch = TeamGameStats(entityTeam, entityGame)

        var dtoGame = GameDTO.fromModelGame(entitySearch, entitySearch)

        Assertions.assertEquals(entitySearch.game.id, dtoGame.id)
        Assertions.assertEquals(entityTeam.name, dtoGame.teamA.name)
    }
}