package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.dao.TournamentDAO
import UNQ.TTIP.GOAT.service.dto.TournamentDTO
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql

@SpringBootTest
@DisplayName("Test Search Service")
@Sql("/data.sql") //Set de datos usado para la prueba de test
class TournamentTest (@Autowired private val tournamentDao: TournamentDAO) {

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun dtoFromModelTournament() {
        var entityTournament = Tournament("Torneo", 2022, 19)
        entityTournament.id = 1

        var dtoTournament = TournamentDTO.fromModelTournament(entityTournament)

        assertEquals(entityTournament.id, dtoTournament.id)
        assertEquals(entityTournament.name, dtoTournament.name)
    }
}