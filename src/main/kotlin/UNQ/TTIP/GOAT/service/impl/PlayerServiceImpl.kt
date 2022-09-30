package UNQ.TTIP.GOAT.service.impl;

import UNQ.TTIP.GOAT.dao.PlayerDAO
import UNQ.TTIP.GOAT.service.PlayerService
import UNQ.TTIP.GOAT.service.dto.PlayerDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerServiceImpl(@Autowired private val playerDao: PlayerDAO) : PlayerService {

    override fun findByDni(id: Long): PlayerDTO {
        return PlayerDTO.fromModelPlayer(playerDao.findByDni(id))
    }

}
