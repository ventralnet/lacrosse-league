package lacrosse.league

import com.kirkley.lacrosse.League

class LeagueService {

    def getCurrentLeague() {
        def league = League.findBySeasonAndYear("FALL",2012)
        league
    }
}
