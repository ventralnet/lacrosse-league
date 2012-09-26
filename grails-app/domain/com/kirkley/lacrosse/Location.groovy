package com.kirkley.lacrosse

import com.kirkley.lacrosse.Contact

class Location {

    Integer id
    
    Contact contact

    String name

    String street
    String city
    String zipCode

    static constraints = {
    }

    static mapping = {
        id column:'Location_ID'
        name column:'Location_Name'
        zipCode column:'Zip_code'
        version false
    }
}
