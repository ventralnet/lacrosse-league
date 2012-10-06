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

    def register() {
        if (request.method == 'POST') {
            def player = new Player()
            def contact = new Contact(params.contact)
            println params.contact
            if (!contact.save()) {
                player.contact = contact;
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
