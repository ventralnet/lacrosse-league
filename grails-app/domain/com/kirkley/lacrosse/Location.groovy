package com.kirkley.lacrosse

import com.kirkley.lacrosse.Contact

class Location {

    Integer id
    
    Contact contact

    String fieldName

    String street
    String city
    String zipCode

    static constraints = {
    }

    static mapping = {
        table "Location"
        id column:'Location_ID'
        fieldName column:'Field_name'
        street column:'Street'
        city column:'City'
        zipCode column:'Zip_code'
        contact column:'Contact'
        version false
    }
}
