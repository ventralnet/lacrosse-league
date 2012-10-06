package com.kirkley.lacrosse

import com.kirkley.lacrosse.League
import com.kirkley.lacrosse.Contact

class Team {

    Integer id
    
    String name
    League league
    Contact coach    

    static constraints = {
    }

    static mapping = {
        id column:'Team_ID'
        name column:'Name'
        league column:'League'
        coach column:'Coach'
        version false
    }
}
