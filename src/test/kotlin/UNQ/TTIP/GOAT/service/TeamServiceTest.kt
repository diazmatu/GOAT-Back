package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.service.impl.TeamServiceImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql

@SpringBootTest
@Sql("/data.sql") //Set de datos usado para la prueba de test
class TeamServiceTest (@Autowired val teamDAO: TeamDAO){

    @Autowired
    lateinit var teamService: TeamServiceImpl

    @BeforeEach
    fun setUp() {
        teamService = TeamServiceImpl(teamDAO)
    }

    @Test
    fun allTeams() {

        val teams: List<Team> = teamService.allTeams()

        assertEquals(3, teams.size)
    }
}