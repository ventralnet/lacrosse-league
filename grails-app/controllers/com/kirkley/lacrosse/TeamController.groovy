package com.kirkley.lacrosse

import org.springframework.dao.DataIntegrityViolationException
import com.kirkley.lacrosse.Player
import com.kirkley.lacrosse.Team
import com.kirkley.lacrosse.League

class TeamController {

    def teamService
    def gameService

    def index() {
        def games = gameService.getGameSchedule()    
        [games: games]
    }

    def roster() {
        def team = teamService.getTeam()
        def players = Player.findAllByTeam(team)
        [players:players]
    }
}
