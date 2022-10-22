package UNQ.TTIP.GOAT.model

import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.dto.PlayerDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.sql.Date

internal class PlayerTest{
    @Test
    fun getMinutes() {
        assertEquals(1, 1)
    }

    @Test
    fun dtoFromModelPlayer() {
        var entityPlayer = Player(39281127,"Nombre", "Apellido", Date(1995,9,27), "Image", emptyList())

        var dtoPlayer = PlayerDTO.fromModelPlayer(entityPlayer)

        Assertions.assertEquals(entityPlayer.dni, dtoPlayer.id)
        Assertions.assertEquals(entityPlayer.name, dtoPlayer.name)
    }
}