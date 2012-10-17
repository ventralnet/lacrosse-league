package lacrosse.league

import com.kirkley.lacrosse.Game

class GameService {

    def teamService

    def getGameSchedule() {
        def team = teamService.getTeam()    
        def query = Game.where {
            (homeTeam == team || awayTeam == team )
        }
    }

}
