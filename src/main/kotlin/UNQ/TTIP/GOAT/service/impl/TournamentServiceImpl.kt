package UNQ.TTIP.GOAT.service.impl;

import UNQ.TTIP.GOAT.dao.TournamentDAO;
import UNQ.TTIP.GOAT.model.Tournament
import UNQ.TTIP.GOAT.service.TournamentService
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import UNQ.TTIP.GOAT.service.dto.TournamentDTO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TournamentServiceImpl (@Autowired private val tournamentDao:TournamentDAO): TournamentService {

    fun findAll(): MutableList<TournamentDTO> {
        return tournamentDao.findAll().map { TournamentDTO.fromModelTournament(it) } as MutableList<TournamentDTO>
    }

    override fun findById(id: Long): TournamentDTO {
        return TournamentDTO.fromModelTournament(tournamentDao.findById(id).orElse(null))
    }

    fun createTournament(requestTournament: Tournament): Long? {
        val tournament = tournamentDao.saveAndFlush(requestTournament)
        return tournament.id
    }
}
