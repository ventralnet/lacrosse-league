package com.kirkley.lacrosse

import com.kirkley.lacrosse.Contact
import com.kirkley.lacrosse.Team

class Player {

    Integer id
    
    Contact contact
    
    Team team

    Integer age

    //TODO Is this the correct datatype?
    String position

    static constraints = {
    }

    static mapping = {
        id column:'Player_ID'
        contact cascade: 'all'
        version false
    }
}
