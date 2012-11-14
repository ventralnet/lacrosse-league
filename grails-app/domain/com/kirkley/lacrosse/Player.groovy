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
        table "Player"
        id column:'Player_ID'
        contact column:'Contact', cascade: 'all'
        team column:'Team'
        version false
    }
}
