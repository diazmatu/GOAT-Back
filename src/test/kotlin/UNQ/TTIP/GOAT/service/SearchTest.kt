package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.dao.*
import UNQ.TTIP.GOAT.dao.impl.*
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.model.Tournament
import UNQ.TTIP.GOAT.service.dto.*
import UNQ.TTIP.GOAT.service.impl.SearchServiceImpl
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.NestedTestConfiguration
import org.springframework.test.context.jdbc.Sql
import java.sql.Date


@SpringBootTest
@DisplayName("Test Search Service")
@NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
@Sql("/data.sql") //Set de datos usado para la prueba de test
class SearchTest  ( @Autowired private val teamDao: TeamDAO,
                    @Autowired private val playerDao: PlayerDAO,
                    @Autowired private val tournamentDao: TournamentDAO,
                    @Autowired private val gameDao: GameDAO
){

    @Autowired
    lateinit var searchService: SearchServiceImpl
    lateinit var implSearch: ImplSearchDAO
    lateinit var modelDao: ImplModelDAO

    @BeforeEach
    fun setUp() {
        searchService = SearchServiceImpl(teamDao, playerDao, tournamentDao, gameDao)
        implSearch = ImplSearchDAO(teamDao, playerDao, tournamentDao, gameDao)
        modelDao = ImplModelDAO(teamDao, playerDao, tournamentDao, gameDao)
    }

    @Test
    fun findTeamsOfTournament() {

        val result: ModelDTO = modelDao.findData(1, "Tournament")

        assertNotEquals(1, result.teams)
    }


    @Nested
    @DisplayName("to find by name starting with, ")
    internal inner class SearchByNameStartingWith(){

        @Nested
        @DisplayName("for search results DTO")
        internal inner class SearchResultDTOTest() {

            @Test
            fun dtoFromModelTeam() {
                var entityTeam = Team("Equipo", 2022, 19, emptyList())
                entityTeam.id = 1
                var dtoTeam = SearchResultDTO.fromModelTeam(entityTeam)

                assertEquals(entityTeam.id, dtoTeam.id)
                assertEquals(entityTeam.name, dtoTeam.name)
                assertEquals("Team", dtoTeam.type)
            }

            @Test
            fun dtoFromModelTournament() {
                var entityTournament = Tournament("Torneo", 2022, 19)
                entityTournament.id = 1
                var dtoTournament = SearchResultDTO.fromModelTournament(entityTournament)

                assertEquals(entityTournament.id, dtoTournament.id)
                assertEquals(entityTournament.name, dtoTournament.name)
                assertEquals("Tournament", dtoTournament.type)
            }

            @Test
            fun dtoFromModelPlayer() {
                var entityPlayer = Player(39281127, "Nombre", "Apellido", Date(1995, 9, 27), emptyList())
                var dtoPlayer = SearchResultDTO.fromModelPlayer(entityPlayer)

                assertEquals(entityPlayer.dni, dtoPlayer.id)
                assertEquals(entityPlayer.name, dtoPlayer.name)
                assertEquals(entityPlayer.surname, dtoPlayer.surname)
                assertEquals("Player", dtoPlayer.type)
            }

        }

        @Nested
        @DisplayName("for the implementation of search DAO")
        internal inner class ImplSearchDAOTests() {

            @Test
            fun findWithAllFiltersByNameStartingWith() {

                //Search with all filters activated, and find all components starting with 'B'

                val result: MutableList<SearchResultDTO> = implSearch.findByNameStartingWith(
                    "B",
                    true,
                    true,
                    true
                )

                //Find 3 results: 2 players, 1 team

                assertEquals(3, result.size)
            }

            @Test
            fun findOnlyTournamentsByNameStartingWith() {

                //Search with all filters activated, and find all components starting with 'M'

                val result: MutableList<SearchResultDTO> = implSearch.findByNameStartingWith(
                    "M",
                    true,
                    false,
                    false
                )

                //Find 1 result: 1 tournament

                assertEquals(1, result.size)
            }

            @Test
            fun findOnlyTeamsByNameStartingWith() {

                //Search with all filters activated, and find all components starting with 'E'

                val result: MutableList<SearchResultDTO> = implSearch.findByNameStartingWith(
                    "E",
                    false,
                    true,
                    false
                )

                //Find 1 results: 1 team

                assertEquals(1, result.size)
            }

            @Test
            fun findOnlyPlayersByNameStartingWith() {

                //Search with all filters activated, and find all components starting with 'M'

                val result: MutableList<SearchResultDTO> = implSearch.findByNameStartingWith(
                    "M",
                    false,
                    false,
                    true
                )

                //Find 4 results: 4 players

                assertEquals(4, result.size)
            }
        }

        @Nested
        @DisplayName("for the implementation of search service")
        internal inner class SearchServiceTests {

            /*
            @Test
            fun findByName() {

                val result: Collection<Entity> = searchService.findByName("Ezeiza")

                assertEquals(1, result.size)
            }
            */

            @Test
            fun findWithAllFiltersByNameStartingWith() {

                //Search with all filters activated, and find all components starting with 'B'

                val result: MutableList<SearchResultDTO> = searchService.findByNameStartingWith(
                    "B",
                    true,
                    true,
                    true
                )

                //Find 3 results: 2 players, 1 team

                assertEquals(3, result.size)
            }

            @Test
            fun findOnlyTournamentsByNameStartingWith() {

                //Search with all filters activated, and find all components starting with 'M'

                val result: MutableList<SearchResultDTO> = searchService.findByNameStartingWith(
                    "M",
                    true,
                    false,
                    false
                )

                //Find 1 result: 1 tournament

                assertEquals(1, result.size)
            }

            @Test
            fun findOnlyTeamsByNameStartingWith() {

                //Search with all filters activated, and find all components starting with 'E'

                val result: MutableList<SearchResultDTO> = searchService.findByNameStartingWith(
                    "E",
                    false,
                    true,
                    false
                )

                //Find 1 results: 1 team

                assertEquals(1, result.size)
            }

            @Test
            fun findOnlyPlayersByNameStartingWith() {

                //Search with all filters activated, and find all components starting with 'M'

                val result: MutableList<SearchResultDTO> = searchService.findByNameStartingWith(
                    "M",
                    false,
                    false,
                    true
                )

                //Find 4 results: 4 players

                assertEquals(4, result.size)
            }
        }
    }

    @Nested
    @DisplayName("to find game ")
    internal inner class SearchGameWith(){

        @Nested
        @DisplayName("for the implementation of search DAO")
        internal inner class ImplSearchDAOTests() {

            @Test
            fun findGameWithTwoTeams() {

                //Search with all filters activated, and find all components starting with 'B'

                val result: MutableList<GameDTO> = implSearch.findGameWith(
                    "T",
                    "E"
                )

                //Find 3 results: 2 players, 1 team

                assertEquals(1, result.size)
            }

            @Test
            fun findGameWithOneTeams() {

                //Search with all filters activated, and find all components starting with 'B'

                val result: MutableList<GameDTO> = implSearch.findGameWith(
                    "T",
                    "*"
                )

                //Find 3 results: 2 players, 1 team

                assertEquals(2, result.size)
            }
        }

        @Nested
        @DisplayName("for the implementation of search service")
        internal inner class SearchServiceTests {
            @Test
            fun findGameWithTwoTeams() {

                //Search with all filters activated, and find all components starting with 'B'

                val result: MutableList<GameDTO> = searchService.findGameWith(
                    "T",
                    "E"
                )

                //Find 3 results: 2 players, 1 team

                assertEquals(1, result.size)
            }

            @Test
            fun findGameWithOneTeams() {

                //Search with all filters activated, and find all components starting with 'B'

                val result: MutableList<GameDTO> = searchService.findGameWith(
                    "T",
                    "*"
                )

                //Find 3 results: 2 players, 1 team

                assertEquals(2, result.size)
            }
        }
    }
}