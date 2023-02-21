package UNQ.TTIP.GOAT.service.impl;

import UNQ.TTIP.GOAT.controller.prototype.TournamentPrototype
import UNQ.TTIP.GOAT.dao.TournamentDAO;
import UNQ.TTIP.GOAT.model.ImageHandler
import UNQ.TTIP.GOAT.model.Tournament
import UNQ.TTIP.GOAT.service.TournamentService
import UNQ.TTIP.GOAT.service.dto.TournamentDTO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile

@Service
class TournamentServiceImpl (@Autowired private val tournamentDao:TournamentDAO): TournamentService {

    fun findAll(): MutableList<TournamentDTO> {
        return tournamentDao.findAll().map { TournamentDTO.fromModelTournament(it) } as MutableList<TournamentDTO>
    }

    override fun findById(id: Long): TournamentDTO {
        return TournamentDTO.fromModelTournament(tournamentDao.findById(id).orElse(null))
    }

    fun createTournament(requestTournament: TournamentPrototype): Long? {
        var tournamentPrototype = Tournament(requestTournament.name, requestTournament.season, requestTournament.category, "")
        var tournament = tournamentDao.saveAndFlush(tournamentPrototype)
/*
        var byteArray = profileImage.bytes
        var imageName = "Tournaments/" +"${tournament.id}" + ".jpg"
        var imagePath = ImageHandler().save(byteArray, imageName)
        //var path = imageHandler.save(byteArray, imageName)
        //var profileImage =

        tournament.profileImage = imagePath
        tournament = tournamentDao.saveAndFlush(tournament)*/
        return tournament.id
    }
}
