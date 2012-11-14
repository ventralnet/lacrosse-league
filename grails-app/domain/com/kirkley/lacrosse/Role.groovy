package com.kirkley.lacrosse

class Role {

    Integer id
    String type

    public static final String ADMINISTRATOR = "administrator"
    public static final String PLAYER = "player"
    public static final String COACH = "coach"

    static mapping = {
        table "Role"
        id column:'Role_ID'
        version false
    }   

    static constraints = {
    }
}
