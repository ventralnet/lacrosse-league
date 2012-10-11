package com.kirkley.lacrosse

import org.springframework.dao.DataIntegrityViolationException
import com.kirkley.lacrosse.Player
import com.kirkley.lacrosse.Team
import com.kirkley.lacrosse.League

class TeamController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
    }

    def roster() {
        if (session.user) {
            def league = League.findByYearAndSeason(2012,'FALL')
            def team = Team.findByNameAndLeague('Kirks',league)
            def players = Player.findAllByTeam(team)
            render "${players.getClass()}          ${team.id}   ${players.size()}"
            //def players = Player.findByTeam(team)
            //def players = Player.findByTeam(team)
        }

    }
}
