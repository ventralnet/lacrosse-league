package com.kirkley.lacrosse

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

    def logout() {
        session.user = null
        redirect(controller:'team', action:'index')
    }  

    def index() { }
}
