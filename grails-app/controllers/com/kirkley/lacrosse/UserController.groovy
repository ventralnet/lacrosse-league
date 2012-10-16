package com.kirkley.lacrosse

import com.kirkley.lacrosse.Player
import com.kirkley.lacrosse.Contact
import com.kirkley.lacrosse.Role

class UserController {

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
            if (!contact.save()) {
                player.contact = contact
                return [player:player]
            }
            player.properties = params
            player.contact = contact
            player.team = Team.findById(1)
            if (!player.save()) {
                return [player:player] 
            } else {
                session.user = player.contact //look into just having the player login if that is the case
                redirect(controller:'team', action:'index')
            }
        }
    }

    def logout() {
        session.user = null
        redirect(controller:'team', action:'index')
    }  

    def index() { }
}
