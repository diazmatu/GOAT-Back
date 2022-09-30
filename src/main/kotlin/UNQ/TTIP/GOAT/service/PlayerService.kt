package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.service.dto.PlayerDTO
import org.springframework.stereotype.Service

@Service
interface PlayerService {
    fun findByDni(id: Long): PlayerDTO
}