package UNQ.TTIP.GOAT.service

import UNQ.TTIP.GOAT.service.dto.ModelDTO
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
interface ModelService {

    fun findData(id: Long, type: String): ModelDTO
    fun postImage(profileImage: MultipartFile, id: Long, type: String): Any
    fun saveStat(stat: String, playerDni: Long, teamId: Long, tournamentId: Long, gameId: Long)

}
