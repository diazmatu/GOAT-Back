package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.dao.GameDAO
import UNQ.TTIP.GOAT.dao.PlayerDAO
import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.dao.TournamentDAO
import UNQ.TTIP.GOAT.dao.impl.ImplModelDAO
import UNQ.TTIP.GOAT.dao.impl.ModelServiceImpl
import UNQ.TTIP.GOAT.service.dto.ModelDTO
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.NestedTestConfiguration
import org.springframework.test.context.jdbc.Sql
import org.junit.jupiter.api.Assertions.*
import java.sql.Date

@SpringBootTest
@DisplayName("Test Model Service")
@NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
@Sql("/data.sql") //Set de datos usado para la prueba de test
class ModelTest (   @Autowired private val teamDao: TeamDAO,
                    @Autowired private val playerDao: PlayerDAO,
                    @Autowired private val tournamentDao: TournamentDAO,
                    @Autowired private val gameDao: GameDAO
){

    @Autowired
    lateinit var modelService: ModelServiceImpl
    lateinit var implModel: ImplModelDAO

    @BeforeEach
    fun setUp() {
        modelService = ModelServiceImpl(teamDao, playerDao, tournamentDao, gameDao)
        implModel = ImplModelDAO(teamDao, playerDao, tournamentDao, gameDao)
    }

    @Test
    fun findTeamsOfTournament() {

        val result: ModelDTO = implModel.findData(1, "Tournament")

        assertNotEquals(1, result.teams)
    }



    @Nested
    @DisplayName("for the implementation of model service")
    internal inner class ModelDTOTests {

        /*
        @Test
        fun findByName() {

            val result: Collection<Entity> = searchService.findByName("Ezeiza")

            assertEquals(1, result.size)
        }
        */

        @Test
        fun fromModelTournament() {
            var team = Team("Equipo", 2022, 19, emptyList())
            var listOfTeam : MutableList<Team> = mutableListOf<Team>(team)
            val result: ModelDTO = ModelDTO.fromModelTournament(listOfTeam, emptyList<Game>().toMutableList())

            assertEquals("Equipo", result.teams[0].name)
        }

        @Test
        fun fromModelTeam() {
            var tournament = Tournament("Tournament", 2022, 19)
            var listOfTournament : MutableList<Tournament> = mutableListOf<Tournament>(tournament)

            var player = Player(39281127, "Nombre", "Apellido", Date(1995,9,27))
            var listOfPlayer : MutableList<Player> = mutableListOf<Player>(player)

            val result: ModelDTO = ModelDTO.fromModelTeam(listOfTournament, listOfPlayer, emptyList<Game>().toMutableList())

            //Find a team with 1 tournament and 2 players

            assertEquals("Tournament", result.tournaments[0].name)
            assertEquals("Nombre", result.players[0].name)
        }

        @Test
        fun fromModelPlayer() {
            var team = Team("Equipo", 2022, 19, emptyList())
            var listOfTeam : MutableList<Team> = mutableListOf<Team>(team)
            val result: ModelDTO = ModelDTO.fromModelPlayer(listOfTeam, emptyList<Game>().toMutableList())

            //Find a tournament with 1 team

            assertEquals("Equipo", result.teams[0].name)
        }

        @Test
        fun findDataOfAGame() {

        }
    }

    @Nested
    @DisplayName("for the implementation of model service")
    internal inner class ModelDAOTests {

        /*
        @Test
        fun findByName() {

            val result: Collection<Entity> = searchService.findByName("Ezeiza")

            assertEquals(1, result.size)
        }
        */

        @Test
        fun findDataOfATournament() {

            val result: ModelDTO = implModel.findData(
                1,
                "Tournament"
            )

            //Find a tournament with 2 teams

            Assertions.assertEquals(2, result.teams.size)
        }

        @Test
        fun findDataOfATeam() {

            val result: ModelDTO = implModel.findData(
                1,
                "Team"
            )

            //Find a team with 1 tournament and 2 players

            Assertions.assertEquals(1, result.tournaments.size)
            Assertions.assertEquals(2, result.players.size)
        }

        @Test
        fun findDataOfAPlayer() {

            val result: ModelDTO = implModel.findData(
                45678946,
                "Player"
            )

            //Find a tournament with 1 team

            Assertions.assertEquals(1, result.teams.size)
        }

        @Test
        fun findDataOfAGame() {

        }
    }

    @Nested
    @DisplayName("for the implementation of model DAO")
    internal inner class ModelServiceTests {

        /*
        @Test
        fun findByName() {

            val result: Collection<Entity> = searchService.findByName("Ezeiza")

            assertEquals(1, result.size)
        }
        */

        @Test
        fun findDataOfATournament() {

            val result: ModelDTO = modelService.findData(
                1,
                "Tournament"
            )

            //Find a tournament with 2 teams

            Assertions.assertEquals(2, result.teams.size)
        }

        @Test
        fun findDataOfATeam() {

            val result: ModelDTO = modelService.findData(
                1,
                "Team"
            )

            //Find a team with 1 tournament and 2 players

            Assertions.assertEquals(1, result.tournaments.size)
            Assertions.assertEquals(2, result.players.size)
        }

        @Test
        fun findDataOfAPlayer() {

            val result: ModelDTO = modelService.findData(
                45678946,
                "Player"
            )

            //Find a tournament with 1 team

            Assertions.assertEquals(1, result.teams.size)
        }

        @Test
        fun findDataOfAGame() {

        }
    }
}