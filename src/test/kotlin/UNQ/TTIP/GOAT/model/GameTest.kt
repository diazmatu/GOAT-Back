package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.dao.GameDAO
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.dto.GameDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql

@SpringBootTest
@DisplayName("Test Search Service")
@Sql("/data.sql") //Set de datos usado para la prueba de test
class GameTest (@Autowired private val gameDao: GameDAO){

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun dtoFromModelTeam() {
        var entityTeam = Team("Equipo", 2022, 19, emptyList())
        var entityGame = Game(emptyList(), Tournament("Torneo", 2022, 19))
        entityGame.id = 1
        var entitySearch = TeamGameStats(entityTeam, entityGame)

        var dtoGame = GameDTO.fromModelGame(entitySearch)

        Assertions.assertEquals(entitySearch.game.id, dtoGame.id)
        Assertions.assertEquals(entityTeam.name, dtoGame.teamName)
    }
}