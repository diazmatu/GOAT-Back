package UNQ.TTIP.GOAT.service.impl;

import UNQ.TTIP.GOAT.dao.TournamentDAO;
import UNQ.TTIP.GOAT.service.TournamentService
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import UNQ.TTIP.GOAT.service.dto.TournamentDTO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TournamentServiceImpl (@Autowired private val tournamentDao:TournamentDAO): TournamentService {

    override fun findById(id: Long): TournamentDTO {
        return TournamentDTO.fromModelTournament(tournamentDao.findById(id).orElse(null))
    }
}
