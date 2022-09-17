package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.service.impl.SearchServiceImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import javax.persistence.Entity

@SpringBootTest
@Sql("/data.sql") //Set de datos usado para la prueba de test
class SearchServiceTest  (@Autowired private val teamDao: TeamDAO,
                          @Autowired private val playerDao: PlayerDAO,
                          @Autowired private val tournamentDao: TournamentDAO,
                          @Autowired private val gameDao: GameDAO
){

    @Autowired
    lateinit var searchService: SearchServiceImpl

    @BeforeEach
    fun setUp() {
        searchService = SearchServiceImpl(teamDao, playerDao, tournamentDao, gameDao)
    }

    @Test
    fun findTeamByName() {

        val result: Collection<Entity> = searchService.findByName("Ezeiza")

        assertEquals(1, result.size)
    }

    @Test
    fun findByNameStartingWith(){

        val result: Collection<Entity> = searchService.findByNameStartingWith("M")

        assertEquals(5, result.size)
    }
}
