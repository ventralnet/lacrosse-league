package lacrosse.league

import com.kirkley.lacrosse.Team

class TeamService {

    def leagueService

    def getTeam() {
        def league = leagueService.getCurrentLeague()
        def team = Team.findByNameAndLeague('Team 7',league)
        return team;
    }

}
