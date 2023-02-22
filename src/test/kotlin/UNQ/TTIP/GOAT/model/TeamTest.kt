package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql

@SpringBootTest
@DisplayName("Team Tests")
//@Sql("/data.sql") //Set de datos usado para la prueba de test
class TeamTest  (@Autowired private val teamDao: TeamDAO){

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun dtoFromModelTeam() {
        var entityTeam = Team("Equipo", 2022, 19, "Image")
        entityTeam.id = 1

        var entityTournament = Tournament("Torneo", 2022, 19, "Image")

        var dtoTeam = TeamDTO.fromModelTeam(entityTeam)

        assertEquals(entityTeam.id, dtoTeam.id)
        assertEquals(entityTeam.name, dtoTeam.name)
    }
}