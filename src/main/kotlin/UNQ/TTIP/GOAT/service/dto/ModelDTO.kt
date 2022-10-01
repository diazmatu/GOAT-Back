package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.model.Tournament

class ModelDTO(var tournaments:MutableList<TournamentDTO>, var teams:MutableList<TeamDTO>, var players:MutableList<PlayerDTO>, var games:MutableList<GameDTO>) {

    companion object {
        fun fromModelTournament(teams:MutableList<Team>, games:MutableList<Game>): ModelDTO {
            return ModelDTO(
                emptyList<TournamentDTO>().toMutableList(),
                teams.map { TeamDTO.fromModelTeam(it) } as MutableList<TeamDTO>,
                emptyList<PlayerDTO>().toMutableList(),
                games.map { GameDTO.fromGame(it)} as MutableList<GameDTO>
            )
        }

        fun fromModelTeam(tournaments:MutableList<Tournament>, players:MutableList<Player>, games:MutableList<Game>): ModelDTO {
            return ModelDTO(
                tournaments.map { TournamentDTO.fromModelTournament(it) } as MutableList<TournamentDTO>,
                emptyList<TeamDTO>().toMutableList(),
                players.map { PlayerDTO.fromModelPlayer(it) } as MutableList<PlayerDTO>,
                games.map { GameDTO.fromGame(it)} as MutableList<GameDTO>
            )
        }

        fun fromModelPlayer(teams:MutableList<Team>, games:MutableList<Game>): ModelDTO {
            return ModelDTO(
                emptyList<TournamentDTO>().toMutableList(),
                teams.map { TeamDTO.fromModelTeam(it) } as MutableList<TeamDTO>,
                emptyList<PlayerDTO>().toMutableList(),
                games.map { GameDTO.fromGame(it)} as MutableList<GameDTO>
            )
        }
    }
}
