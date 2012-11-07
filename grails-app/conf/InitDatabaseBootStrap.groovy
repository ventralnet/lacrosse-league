import grails.util.GrailsUtil

import grails.util.Environment

import com.kirkley.lacrosse.*

class InitDatabaseBootStrap {

    static {
        ArrayList.metaClass.random = { 
            return delegate[new Random().nextInt(delegate.size()-1)]
        }
    }

    def random = new Random()

    static final def COACH = Role.COACH
    static final def PLAYER = Role.PLAYER
    static final def ADMIN = Role.ADMINISTRATOR

    static final def TEAM_NAMES = ['Kirks','Tigers','Jags','Lions','Bros']

    static final def LAST_NAMES = ['Doe','Russo','Soprano','Hacket','Brown','Castle','Frink','Chen','Smith','Jones','Henry','McCloud','Myers','McKnight','Lewis','Black','Matthews','Mu','Smyth']
    static final def FIRST_NAMES = ['Jeremy','Buck','Grant','Joe','Jon','Matthew','Joshua','Matt','Jim','Michael','Justin','Valerie','Jacob','David','Chris','Richard']

    def coachRole
    def parentPlayerRole
    def administratorRole

    private def randomPhoneNumber() {
        def n = { numDigits ->
            def s = ""
            numDigits.times { s+="9" }
            int val = random.nextInt(s as Integer) 
            while (val.toString().length() < numDigits) {
                val = random.nextInt(s as Integer) 
            }
            val
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
        def contact = null
        while (!contact || !contact.save()) {
            def lastname = LAST_NAMES.random()
            def firstname = FIRST_NAMES.random()
            contact = new Contact(lastName:lastname,firstName:firstname, 
                                  emailAddress:randomEmail(firstname,lastname), phoneNumber:randomPhoneNumber(), password:"secret",role:role) 
        }
        contact
    }

    private def createTeamRoster(team) {
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Attack").save()
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Attack").save()
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Attack").save()
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Defense").save()
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Defense").save()
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Defense").save()
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Midfield").save()
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Midfield").save()
        new Player(contact:createContact(parentPlayerRole),team:team,age:17,position:"Midfield").save()
    }

    private def save(Object ... items) {
        items.each {
            it.save()
        }
    }

    def init = { servletContext -> 
        switch(GrailsUtil.environment) {
            case "development":
            case "production":
                def (coachRole,parentPlayerRole,administratorRole) = createRoles()

                def contactAdmin = createContact(administratorRole)
                def contactAdmin2 = createContact(administratorRole)
                def contactCoach = createContact(coachRole)
                def contactCoach2 = createContact(coachRole)
                def contactPlayer = createContact(parentPlayerRole)
                def contactPlayer2 = createContact(parentPlayerRole)
                def contactPlayer3 = createContact(parentPlayerRole)

                def me = new Contact(lastName:'Kirkley',firstName:'Matthew',
                                                  emailAddress:'matt.kirkley@gmail.com', phoneNumber:randomPhoneNumber(), password:"secret",role:coachRole)
                me.save()


                def league = new League(adminContact:contactAdmin,name:"Fall League",year:2012,season:"FALL")
                def league2 = new League(adminContact:contactAdmin2,name:"Summer League",year:2012,season:"SUMMER")
                def league3 = new League(adminContact:contactAdmin,name:"Spring League",year:2012,season:"SPRING")
                def league4 = new League(adminContact:contactAdmin2,name:"Winter League",year:2012,season:"WINTER")
                save(league,league2,league3,league4) 


                Collections.shuffle(TEAM_NAMES)
                def fallTeams = []
                TEAM_NAMES.each { teamName ->
                    def team = new Team(name:teamName,league:league,coach:createContact(coachRole)).save()
                    fallTeams << team
                    team.save()
                }
                TEAM_NAMES.each { teamName ->
                    def team = new Team(name:teamName,league:league2,coach:createContact(coachRole)).save()
                    team.save()
                }
                TEAM_NAMES.each { teamName ->
                    def team = new Team(name:teamName,league:league3,coach:createContact(coachRole)).save()
                    team.save()
                }
                TEAM_NAMES.each { teamName ->
                    def team = new Team(name:teamName,league:league4,coach:createContact(coachRole)).save()
                    team.save()
                }

                def location = new Location(contact:createContact(coachRole),fieldName:"Seminary",street:"Alley",city:"Timonium",zipCode:"22121")
                def location2 = new Location(contact:createContact(coachRole),fieldName:"Heights",street:"Lutherville",city:"CityPlace",zipCode:"22131")
                def location3 = new Location(contact:createContact(coachRole),fieldName:"Grass Field",street:"3rd",city:"Baltimore",zipCode:"22122")
                def location4 = new Location(contact:createContact(coachRole),fieldName:"Concrete Field",street:"8th",city:"Cockeysville",zipCode:"21030")
                save(location,location2,location3,location4)
    
                def kirksTeam = fallTeams.find { it.name = 'Kirks' }
                fallTeams.each { team ->
                    if (team != kirksTeam)  
                        createTeamRoster(team)
                }

                def now = System.currentTimeMillis()
                def day = 86400000 / 2
                def players = Player.findAllByTeam(kirksTeam)
                def cal = Calendar.instance
                cal.set(Calendar.YEAR,2012)
                def year2012 = cal.time
                cal.set(Calendar.MINUTE,30)
                cal.set(Calendar.HOUR, 6)
                cal.set(Calendar.AM_PM, Calendar.PM)
                def sixThirty = cal.time
                cal.set(Calendar.MINUTE, 0)
                def six = cal.time
                def game = new Game(homeScore:2,awayScore:4,homeTeam:kirksTeam,awayTeam:fallTeams[1],location:location,time:six,date:new Date(now-(day*6.33) as Long))
                new Game(homeScore:6,awayScore:4,homeTeam:fallTeams[2],awayTeam:kirksTeam,location:location2,time:sixThirty,date:new Date(now-day as Long)).save()
                new Game(homeScore:3,awayScore:8,homeTeam:fallTeams[3],awayTeam:kirksTeam,location:location2,time:sixThirty,date:new Date(now-(day*3) as Long)).save()
                new Game(homeTeam:kirksTeam,awayTeam:fallTeams[1],location:location,time:six,date:new Date(now as Long)).save()
                new Game(homeTeam:fallTeams[2],awayTeam:kirksTeam,location:location2,time:six,date:new Date(now+day as Long)).save()
                new Game(homeTeam:fallTeams[3],awayTeam:kirksTeam,location:location2,time:sixThirty,date:new Date(now+(day*3) as Long)).save()
                new Game(homeTeam:fallTeams[2],awayTeam:kirksTeam,location:location4,time:six,date:new Date(now+(day*4) as Long)).save()
                new Game(homeTeam:fallTeams[3],awayTeam:kirksTeam,location:location3,time:sixThirty,date:new Date(now+(day*5) as Long)).save()
                new Game(homeTeam:kirksTeam,awayTeam:fallTeams[4],location:location,time:six,date:new Date(now+(day*6) as Long)).save()
                    
            break
        } 
    }

    def destroy = {
    }

}
