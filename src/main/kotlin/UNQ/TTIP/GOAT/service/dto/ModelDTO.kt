package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Game
import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.PlayerGameStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.model.Tournament

class ModelDTO(var tournaments:MutableList<TournamentDTO>, var teams:MutableList<TeamDTO>, var players:MutableList<PlayerDTO>, var games:MutableList<GameDTO>) {

    var teamA : StatsDTO? = null
    var teamB : StatsDTO? = null

    var playersA : List<StatsDTO> = emptyList()
    var playersB : List<StatsDTO> = emptyList()

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

        fun fromModelGame(teams:MutableList<TeamGameStats>, playersA:MutableList<PlayerGameStats>, playersB:MutableList<PlayerGameStats> ): ModelDTO {

             var model =ModelDTO(
                emptyList<TournamentDTO>().toMutableList(),
                teams.map { TeamDTO.fromModelTeam(it.team) } as MutableList<TeamDTO>,
                (playersA + playersB).map { PlayerDTO.fromModelPlayer(it.player) } as MutableList<PlayerDTO>,
                emptyList<GameDTO>().toMutableList(),
            )

            model.teamA = StatsDTO.fromGameTeam(teams[0])
            model.teamB = StatsDTO.fromGameTeam(teams[1])

            model.playersA = playersA.map { StatsDTO.fromGamePlayer(it) } as MutableList<StatsDTO>
            model.playersB = playersB.map { StatsDTO.fromGamePlayer(it) } as MutableList<StatsDTO>

            return model
        }
    }
}
