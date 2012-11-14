package com.kirkley.lacrosse

import com.kirkley.lacrosse.Team    
import com.kirkley.lacrosse.Location

class Game {

    Integer id
    
    Team homeTeam
    Team awayTeam

    Location location

    Date date
    Date time

    Integer homeScore = 0
    Integer awayScore = 0

    static constraints = {
    }

    static mapping = {
        table "Game"
        sort "date,time"
        id column:'Game_ID'
        homeTeam column:'Home_team', lazy:false
        awayTeam column:'Away_team', lazy:false
        location column:'Location', lazy:false
        homeScore column:'Home_score'
        awayScore column:'Away_score'
        date column:'Date',sqlType:'date'
        time column:'Time',sqlType:'time'
        version false
    }
}
