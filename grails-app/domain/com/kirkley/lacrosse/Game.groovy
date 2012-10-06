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
    Date time

    Integer homeScore = 0
    Integer awayScore = 0

    static constraints = {
    }

    static mapping = {
        id column:'Game_ID'
        homeTeam column:'Home_team'
        awayTeam column:'Away_team'
        homeScore column:'Home_score'
        awayScore column:'Away_score'
        date column:'Date',sqlType:'date'
        time column:'Time',sqlType:'time'
        version false
    }
}
