package lacrosse.league

import com.kirkley.lacrosse.League

class LeagueService {

    def getCurrentLeague() {
        def league = League.findBySeasonAndYear("Fall",2012)
        league
    }
}
