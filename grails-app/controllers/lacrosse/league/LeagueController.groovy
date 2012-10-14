package lacrosse.league

import com.kirkley.lacrosse.Team
import com.kirkley.lacrosse.Game

class LeagueController {
    
    def leagueService
    def teamService

    def index() { }
        
    def standings() {
       def league = leagueService.getCurrentLeague() 
       def teams = Team.findAllByLeague(league)

       def teamStats = [] 
       teams.each { team ->
           def query = Game.where {
               (homeTeam == team && homeScore > awayScore) || (awayTeam == team && awayScore > homeScore)
           }
           def winningGames = query.list()
           def teamStat = [team:team,winningGames:winningGames]
           query = Game.where {
               (homeTeam == team && homeScore < awayScore) || (awayTeam == team && awayScore < homeScore)
           }
           def losingGames = query.list()
           def totalGames = losingGames + winningGames
           teamStat.losingGames = losingGames
           teamStat.totalGames = totalGames
           teamStats << teamStat
       }   
       [teamStats:teamStats.sort { a,b ->
           if (b.totalGames.size() == 0) {
              return -1
           }
           if (a.totalGames.size() == 0) {
              return 1 
           }
           def bWinRatio = b.winningGames.size() / b.totalGames.size()
           def aWinRatio = a.winningGames.size() / a.totalGames.size()
           bWinRatio.compareTo(aWinRatio)
       }]
    }
}
