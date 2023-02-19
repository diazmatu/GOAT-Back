package UNQ.TTIP.GOAT.service.dto

import UNQ.TTIP.GOAT.model.Player
import UNQ.TTIP.GOAT.model.Relationship.PlayerGameStats
import UNQ.TTIP.GOAT.model.Relationship.TeamGameStats
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.model.Tournament

class ModelDTO(var tournaments:MutableList<TournamentDTO>, var teams:MutableList<TeamDTO>, var players:MutableList<PlayerDTO>, var games:MutableList<GameDTO>) {

    var homeTeam : StatsDTO? = null
    var awayTeam : StatsDTO? = null

    var homePlayers : List<StatsDTO> = emptyList()
    var awayPlayers : List<StatsDTO> = emptyList()

    companion object {
        fun fromModelTournament(teams: MutableList<Team>, games: MutableList<GameDTO>, tournament: String): ModelDTO {
            return ModelDTO(
                emptyList<TournamentDTO>().toMutableList(),
                teams.map { TeamDTO.fromModelTeam(it, tournament) } as MutableList<TeamDTO>,
                emptyList<PlayerDTO>().toMutableList(),
                games
            )
        }

        fun fromModelTeam(tournaments:MutableList<Tournament>, players:MutableList<Player>, games:MutableList<GameDTO>): ModelDTO {
            return ModelDTO(
                tournaments.map { TournamentDTO.fromModelTournament(it) } as MutableList<TournamentDTO>,
                emptyList<TeamDTO>().toMutableList(),
                players.map { PlayerDTO.fromModelPlayer(it) } as MutableList<PlayerDTO>,
                games
            )
        }

        fun fromModelPlayer(teams:MutableList<Team>, games:MutableList<GameDTO>): ModelDTO {
            return ModelDTO(
                emptyList<TournamentDTO>().toMutableList(),
                teams.map { TeamDTO.fromModelTeam(it, "tournament.name") } as MutableList<TeamDTO>,
                emptyList<PlayerDTO>().toMutableList(),
                games
            )
        }

        fun fromModelGame(teams:MutableList<TeamGameStats>, homePlayers:MutableList<PlayerGameStats>, awayPlayers:MutableList<PlayerGameStats> ): ModelDTO {

             var model = ModelDTO(
                emptyList<TournamentDTO>().toMutableList(),
                teams.map { TeamDTO.fromModelTeam(it.team, "tournament.name") } as MutableList<TeamDTO>,
                (homePlayers + awayPlayers).map { PlayerDTO.fromModelPlayer(it.player) } as MutableList<PlayerDTO>,
                emptyList<GameDTO>().toMutableList(),
            )

            model.homeTeam = StatsDTO.fromGameTeam(teams[0])
            model.awayTeam = StatsDTO.fromGameTeam(teams[1])

            model.homePlayers = homePlayers.map { StatsDTO.fromGamePlayer(it) } as MutableList<StatsDTO>
            model.awayPlayers = awayPlayers.map { StatsDTO.fromGamePlayer(it) } as MutableList<StatsDTO>

            return model
        }
    }
}
