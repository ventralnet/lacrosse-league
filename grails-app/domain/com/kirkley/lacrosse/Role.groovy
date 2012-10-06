package com.kirkley.lacrosse

class Role {

    Integer id
    String type

    public static final String ADMINISTRATOR = "Administrator"
    public static final String PLAYER = "Player"
    public static final String COACH = "Coach"

    static mapping = {
        id column:'Role_ID'
        version false
    }   

    static constraints = {
    }
}
