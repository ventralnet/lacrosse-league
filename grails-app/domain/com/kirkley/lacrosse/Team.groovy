package com.kirkley.lacrosse

import com.kirkley.lacrosse.League
import com.kirkley.lacrosse.Contact

class Team {

    Integer id
    
    League league
    Contact contact    

    static constraints = {
    }

    static mapping = {
        id column:'Team_ID'
        version false
    }
}
