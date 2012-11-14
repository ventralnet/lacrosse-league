package com.kirkley.lacrosse

import com.kirkley.lacrosse.Contact

class League {

    Integer id
    String name
    
    Contact adminContact

    Short year
    String season

    static constraints = {
    }

    static mapping = {
        table "League"
        id column:'League_ID'
        name column:'Name'
        year column:'Year',sqlType:'year'
        season column:'Season'
        adminContact column:'Admin'
        version false
    }
}
