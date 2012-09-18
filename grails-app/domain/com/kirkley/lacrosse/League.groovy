package com.kirkley.lacrosse

import com.kirkley.lacrosse.Contact

class League {

    Integer id
    String name
    
    Contact contact

    //TODO Is this a integer or datetime
    Integer year

    //TODO Is season a string?
    String season

    static constraints = {
    }

    static mapping = {
        id column:'League_ID'
        version false
    }
}
