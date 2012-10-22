package com.kirkley.lacrosse

import com.kirkley.lacrosse.Player
import com.kirkley.lacrosse.Contact
import com.kirkley.lacrosse.Role

class UserController {

    def teamService

    def login() {
        def user = Contact.findByEmailAddressAndPassword(params.email,params.password)
        if (user) {
            session.user = user
        } else {
            flash.message = "Invalid login" 
        }   
        redirect(controller:'team', action:'index')
    }

    def edit() {
        def contact = session.user
        def player = null
        if (params.id) {
            if (request.method == 'POST') {
                player = Player.findById(id)
                contact = player.contact
                contact.properties = params
                player.properties = params.player
            } else {
                return renderEditProfile(params.id)
            }
        } else {
            //editing own profile
            contact.attach()
            if (contact.role.type == Role.PLAYER) {
                player = Player.findByContact(contact)
            }
            if (request.method == 'POST') {
                contact.properties = params
                contact.save()
                if (contact.role.type == Role.PLAYER) {
                    player.properties = params.player
                    player.save()
                }
                session.user = contact
            }
            [contact:contact,player:player]
        }
    }

    private def renderEditProfile(id) {
        def player = Player.findById(id)
        def contact = player.contact
        [player:player,contact:contact]
    }

    def register() {
        if (request.method == 'POST') {
            def player = new Player()
            def contact = new Contact(params.contact)
            def role = Role.findByType(Role.PLAYER)
            contact.role = role
            contact.save()
            player.properties = params
            player.contact = contact
            player.team = teamService.getTeam()
            player.save()
            session.user = player.contact
            redirect(controller:'team', action:'index')
        }
    }

    def logout() {
        session.user = null
        redirect(controller:'team', action:'index')
    }  

    def index() { }
}
