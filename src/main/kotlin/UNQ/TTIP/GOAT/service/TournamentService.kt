package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.service.dto.TournamentDTO
import org.springframework.stereotype.Service

@Service
interface TournamentService {

    fun findById(id: Long): TournamentDTO
}