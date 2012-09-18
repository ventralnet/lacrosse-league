package com.kirkley.lacrosse

import com.kirkley.lacrosse.Team    
import com.kirkley.lacrosse.Location

class Game {

    Integer id
    
    Team homeTeam
    Team awayTeam

    Location location

    //TODO confusing, why are date and time columns separated
    Date date
    String time

    Integer homeScore
    Integer awayScore

    static constraints = {
    }

    static mapping = {
        id column:'Game_ID'
        homeTeam column:'Home_team_ID'
        awayTeam column:'Away_team_ID'
        homeScore column:'Home_score'
        awayScore column:'Away_score'
        version false
    }
}
