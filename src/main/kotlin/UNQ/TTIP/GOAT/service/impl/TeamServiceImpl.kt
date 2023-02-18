package UNQ.TTIP.GOAT.service.impl

import UNQ.TTIP.GOAT.controller.prototype.TeamPrototype
import UNQ.TTIP.GOAT.dao.TeamDAO
import UNQ.TTIP.GOAT.dao.TeamTournamentStatsDAO
import UNQ.TTIP.GOAT.dao.TournamentDAO
import UNQ.TTIP.GOAT.model.Relationship.TeamTournamentStats
import UNQ.TTIP.GOAT.model.Team
import UNQ.TTIP.GOAT.service.TeamService
import UNQ.TTIP.GOAT.service.dto.TeamDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl (@Autowired private val teamDao: TeamDAO,
                       @Autowired private val teamTournamentStatsDAO: TeamTournamentStatsDAO,
                       @Autowired private val tournamentDAO: TournamentDAO) : TeamService{

    override fun allTeams(): List<Team> {
        return teamDao.findAll() ?: emptyList();
        //return runTrx { teamDAO.findAll() } ?: emptyList<Team>()
    }

    override fun findById(id: Long): TeamDTO {
        return TeamDTO.fromModelTeam(teamDao.findById(id).orElse(null), "tournament.name")
    }

    fun findByName(name: String): MutableList<Team> {
        return teamDao.findByName(name)
    }

    fun findByNameStartingWith(prefix: String): MutableList<Team> {
        return teamDao.findByNameStartingWith(prefix)
    }

    fun createTeam(requestTeam: TeamPrototype):Long? {

        var team = Team(requestTeam.name, requestTeam.season, requestTeam.category, requestTeam.profileImage)
        team = teamDao.saveAndFlush(team)

        val stats = createTeamTournament(requestTeam.tournaments, team)

        team.tournaments = team.tournaments.plus(stats)

        teamDao.saveAndFlush(team)

        return team.id
    }

    fun createTeamTournament(tournaments: List<Long>, team: Team): List<TeamTournamentStats> {
        var listOfStats = emptyList<TeamTournamentStats>()
        for (t in tournaments) {
            val tournament = tournamentDAO.findByIdOrNull(t)
            val stats = TeamTournamentStats.createStats(tournament!!, team)
            stats.steals = stats.steals+0
            teamTournamentStatsDAO.saveAndFlush(stats)
            listOfStats = listOfStats.plus(stats)
        }

        return listOfStats
    }
}