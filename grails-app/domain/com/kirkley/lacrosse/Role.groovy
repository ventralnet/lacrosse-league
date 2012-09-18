package com.kirkley.lacrosse

class Role {

    Integer id
    String type

    static mapping = {
        id column:'Role_ID'
        version false
    }   

    static constraints = {
    }
}
