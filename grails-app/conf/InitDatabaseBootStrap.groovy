import grails.util.GrailsUtil

import grails.util.Environment

import com.kirkley.lacrosse.*

class InitDatabaseBootStrap {

    static {
        ArrayList.metaClass.random = { 
            return delegate[0]
        }
    }

    def random = new Random()

    static final def COACH = Role.COACH
    static final def PLAYER = Role.PLAYER
    static final def ADMIN = Role.ADMINISTRATOR

    static final def TEAM_NAMES = ['Kirks','Tigers','Jags','Lions']

    static final def LAST_NAMES = ['Smith','Jones','Kirkley','Henry','McCloud','Myers','McKnight','Lewis','Black','Matthews','Mu','Smyth']
    static final def FIRST_NAMES = ['Matt','Jim','Michael','Justin','Valerie','Jacob','David','Chris','Richard']

    def coachRole
    def parentPlayerRole
    def administratorRole

    private def randomPhoneNumber() {
        def n = { numDigits ->
            random.nextInt(numDigits) 
        }
        "(${n(3)})-${n(3)}-${n(4)}"
    }

    private def randomEmail(firstname,lastname) {
        "${firstname.toLowerCase()}.${lastname.toLowerCase()}@gmail.com"
    }

    private def createRoles() {
        coachRole = new Role(type:COACH)
        parentPlayerRole = new Role(type:PLAYER)
        administratorRole = new Role(type:ADMIN)
        
        coachRole.save()
        parentPlayerRole.save()
        administratorRole.save()
        return [coachRole,parentPlayerRole,administratorRole]
    }

    private def createContact(role) {
        def lastname = LAST_NAMES.random()
        def firstname = FIRST_NAMES.random()
        def contactAdmin = new Contact(lastName:lastname,firstName:firstname, 
                              emailAddress:randomEmail(firstname,lastname), phoneNumber:randomPhoneNumber(), password:"secret",role:administratorRole) 
        contactAdmin.save()
        contactAdmin
    }

    private def createLeagues(contact) {
        def league = new League(adminContact:contact,name:"Summer League",year:2012,season:"SUMMER")
        def league2 = new League(adminContact:contact,name:"Winter League",year:2012,season:"WINTER")
        def league3 = new League(adminContact:contact,name:"Fall League",year:2012,season:"FALL")
        def league4 = new League(adminContact:contact,name:"Spring League",year:2012,season:"SPRING")

        league.save()
        league2.save()
        league3.save()
        league4.save()
    }

    def init = { servletContext -> 
        switch(GrailsUtil.environment) {
            case "development":
                def (coachRole,parentPlayerRole,administratorRole) = createRoles()

                def contactAdmin = createContact(administratorRole)
                def contactCoach = createContact(coachRole)
                def contactCoach2 = createContact(coachRole)
                def contactPlayer = createContact(parentPlayerRole)
                def contactPlayer2 = createContact(parentPlayerRole)
                def contactPlayer3 = createContact(parentPlayerRole)



//                def league = new League(adminContact:contactAdmin,name:"LeagueA",year:2012,season:"FALL")
//                def league2 = new League(adminContact:contactAdmin,name:"LeagueB",year:2012,season:"SUMMER")
//                
//                league.save()
//                league2.save()
//
//                def team = new Team(name:'Kirks',league:league,coach:contactCoach)
//                def team2 = new Team(name:'TEAM-1',league:league,coach:contactCoach2)
//                def team3 = new Team(name:'TEAM-2',league:league,coach:contactCoach2)
//                def team4 = new Team(name:'TEAM-3',league:league,coach:contactCoach2)
//                def team5 = new Team(name:'TEAM-4',league:league2,coach:contactCoach) 
//                
//                team.save()
//                team2.save()
//                team3.save()
//                team4.save()
//                team5.save()
//
//                def player1 = new Player(contact:contactPlayer,team:team,age:21,position:"Attack")
//                def player2 = new Player(contact:contactPlayer2,team:team,age:18,position:"Midfield")
//                def player3 = new Player(contact:contactPlayer3,team:team,age:18,position:"Defense")
//
//                player1.save()
//                player2.save()
//
//                def location = new Location(contact:contactCoach,name:"loc_name",street:"cleghorn",city:"huntvalley",zipCode:"21030")
//
//                location.save()
//
//                def game = new Game(homeTeam:team,awayTeam:team2,location:location,date:2012,time:new Date())
//
//                game.save()
                    
            break
        } 
    }

    def destroy = {
    }

}
