package com.kirkley.lacrosse

import com.kirkley.lacrosse.Player
import com.kirkley.lacrosse.Contact

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
        def player = Player.findByContact(contact)

        player.properties = params
        contact.properties = params.contact
        player.save()

        [player:player]
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
