package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.service.dto.ModelDTO
import org.springframework.stereotype.Service

@Service
interface ModelService {

    fun findData(id: Long, type: String): ModelDTO

}
