package UNQ.TTIP.GOAT.dao

import UNQ.TTIP.GOAT.service.dto.ModelDTO
import org.springframework.web.multipart.MultipartFile

interface ModelDAO {

    fun findData(id: Long, type: String): ModelDTO
    fun postImage(profileImage: MultipartFile, id: Long, type: String): Any
    fun saveStat(stat: String, playerDni: Long, teamId: Long, tournamentId: Long, gameId: Long)
}