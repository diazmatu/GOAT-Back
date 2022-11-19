package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.controller.GamePrototype
import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.service.dto.GameDTO
import UNQ.TTIP.GOAT.service.dto.PlayerDTO
import org.springframework.stereotype.Service

@Service
interface GameService {
    fun findByTeamNameStartingWith(name: String): MutableList<TeamGameStats>
    fun findByIdAndTeamNameStartingWith(id: Long?, name: String): MutableList<TeamGameStats>
    fun findByGameId(id: Long): GameDTO
    fun createGame(requestGame: GamePrototype): Long?
}