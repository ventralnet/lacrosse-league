package com.kirkley.lacrosse

class Role {

    Integer id
    String type

    //static belongsTo = [contact:Contact]

    static mapping = {
        id column 'Role_ID'
    }   

    static constraints = {
    }
}
