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

    def register = { UserRegistrationCommand urc ->
        if (request.method == 'POST') {
            if (urc.hasErrors()) {
                return [ user : urc ]
            } else {
                def contact = new Contact(urc.properties)
                contact.role = Role.findByType(Role.PLAYER)
                def player = new Player()
                player.age = urc.age
                player.position = urc.position
                player.contact = contact
                player.team = teamService.getTeam()
                player.save()
                
                if (player.hasErrors()) {
                    player.errors.each { println it }
                    throw new RuntimeException("problem saving player")
                }
                session.user = player.contact
                redirect(controller:'team',action:'index')
            }   
        }
    }

    def logout() {
        session.user = null
        redirect(controller:'team', action:'index')
    }  

    
}

class UserRegistrationCommand {
    String emailAddress
    String password
    String passwordConfirm
    String firstName
    String lastName
    String phoneNumber
    
    Short age
    String position
    
    static constraints = {
        age(blank:false)
        position(blank:false)
        firstName(blank:false)
        lastName(blank:false)
        phoneNumber(blank:false)
        password(blank:false)
        passwordConfirm(
            validator: { passwordConfirm, userRegistrationCommand ->
                 if (passwordConfirm != userRegistrationCommand.password) {
                    return ["passwordmatch"]
                 }
            })
        
        emailAddress(email:true,
            validator: { enteredEmail, userRegistrationCommand ->
                def contact = Contact.findByEmailAddress(enteredEmail)
                if (contact) {
                    return ["emailunique"]
                }   
            })
    }
}
