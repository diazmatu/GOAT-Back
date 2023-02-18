package UNQ.TTIP.GOAT.service.impl;

import UNQ.TTIP.GOAT.controller.prototype.PlayerPrototype
import UNQ.TTIP.GOAT.dao.PlayerDAO
import UNQ.TTIP.GOAT.dao.PlayerTeamStatsDAO
import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.PlayerTeamStats
import UNQ.TTIP.GOAT.service.PlayerService
import UNQ.TTIP.GOAT.service.dto.PlayerDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PlayerServiceImpl(@Autowired private val playerDao: PlayerDAO,
                        @Autowired private val playerTeamStatsDao: PlayerTeamStatsDAO,
                        @Autowired private val teamDAO: TeamDAO) : PlayerService {

    override fun findByDni(id: Long): PlayerDTO {
        return PlayerDTO.fromModelPlayer(playerDao.findByDni(id))
    }

    fun createPlayer(requestPlayer: PlayerPrototype): Long {

        var player = Player(requestPlayer.dni, requestPlayer.name,  requestPlayer.surname, requestPlayer.birth, requestPlayer.profileImage)
        player = playerDao.saveAndFlush(player)

        val stats = createPlayerTeam(requestPlayer.teams, player)

        player.teams = stats

        player = playerDao.saveAndFlush(player)

        return player.dni
    }

    fun createPlayerTeam(teams: List<Long>, player: Player): List<PlayerTeamStats> {
        var listOfStats: List<PlayerTeamStats> = emptyList()
        for (t in teams) {
            val team = teamDAO.findByIdOrNull(t)
            val stats = PlayerTeamStats.createStats(player, team!!)
            playerTeamStatsDao.saveAndFlush(stats)
            listOfStats = listOfStats.plus(stats)
        }

        return listOfStats
    }
}
