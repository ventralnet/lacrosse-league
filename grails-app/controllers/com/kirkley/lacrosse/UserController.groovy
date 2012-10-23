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
        if (!session.user) {
            throw new RuntimeException("NOT LOGGED IN")
        }
        def contact = null
        def player = null
        if (params.id) {
            if (request.method == 'POST') {
                if (session.user.id != params.id && session.user.role.type != Role.COACH) {
                    throw new RuntimeException("UNAUTHORIZED")
                }
                contact = Contact.findById(params.id)
                if (contact.role.type == Role.PLAYER) {
                    player = Player.findByContact(contact)
                    player.properties = params.player
                    player.save()
                }
                contact.properties = params
                contact.save()
                if (session.user.id == params.id) {
                    session.user = contact
                }
            } else {
                contact = Contact.findById(params.id)
                player = Player.findByContact(contact)
            }   
        } else {
            throw new RuntimeException("No id specified")
        }
        [contact:contact,player:player]
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
