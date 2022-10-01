package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.service.dto.ModelDTO

interface ModelDAO {

    fun findData(id: Long, type: String): ModelDTO
}