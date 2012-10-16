package com.kirkley.lacrosse

import com.kirkley.lacrosse.Role

class Contact {

    Integer id
    String lastName
    String firstName
    String emailAddress
    String phoneNumber  
    String password
    
    Role role

    static constraints = {
        emailAddress unique:true
    }

    static mapping = {
        id column:'Contact_ID'
        lastName column:'Last_name'
        firstName column:'First_name' 
        emailAddress column:'Email'
        phoneNumber column:'Phone'
        role column:'Role',lazy:false
        version false
    }
}
