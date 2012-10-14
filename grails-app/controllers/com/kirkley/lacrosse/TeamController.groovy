package com.kirkley.lacrosse

import org.springframework.dao.DataIntegrityViolationException
import com.kirkley.lacrosse.Player
import com.kirkley.lacrosse.Team
import com.kirkley.lacrosse.League

class TeamController {

    def leagueService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
    }

    def roster() {
        def league = leagueService.getCurrentLeague()
        def team = Team.findByNameAndLeague('Kirks',league)
        def players = Player.findAllByTeam(team)
        [players:players]
    }
}
