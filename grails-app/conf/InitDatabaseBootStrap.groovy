import grails.util.GrailsUtil

import grails.util.Environment

import com.kirkley.lacrosse.*

class InitDatabaseBootStrap {

    static final def COACH = "COACH"
    static final def PLAYER = "PLAYER"
    static final def ADMIN = "ADMINISTRATOR"

    def init = { servletContext -> 
        switch(GrailsUtil.environment) {
            case "development":
                def coachRole = new Role(type:COACH)
                def parentPlayerRole = new Role(type:PLAYER)
                def administratorRole = new Role(type:ADMIN)

                coachRole.save()
                parentPlayerRole.save()
                administratorRole.save()

                def contactAdmin = new Contact(lastName:"Adminie",firstName:"Joe", emailAddress:"joe_admin@gmail.com", phoneNumber:"410-123-4567", password:"secret",role:administratorRole) 
                def contactCoach = new Contact(lastName:"Coachie",firstName:"Jon", emailAddress:"jon_coach@gmail.com", phoneNumber:"410-222-4567", password:"secret",role:coachRole) 
                def contactCoach2 = new Contact(lastName:"Coachie2",firstName:"Jont", emailAddress:"jont_coach@gmail.com", phoneNumber:"410-223-4567", password:"secret",role:coachRole) 
                def contactPlayer = new Contact(lastName:"Kirkley",firstName:"Matt", emailAddress:"m.k@gmail.com", phoneNumber:"410-258-4567", password:"secret",role:parentPlayerRole) 
                def contactPlayer2 = new Contact(lastName:"Kirk",firstName:"Jim", emailAddress:"m.kkk@gmail.com", phoneNumber:"410-258-4557", password:"secret",role:parentPlayerRole) 

                contactAdmin.save()
                contactCoach.save()
                contactCoach2.save()
                contactPlayer.save()
                contactPlayer2.save()

                def league = new League(contact:contactAdmin,name:"LeagueA",year:2012,season:"FALL")
                
                league.save()
                def team = new Team(league:league,contact:contactCoach)
                def team2 = new Team(league:league,contact:contactCoach2)

                team.save()
                team2.save()

                def player1 = new Player(contact:contactPlayer,team:team,age:18,position:"Attack")
                def player2 = new Player(contact:contactPlayer2,team:team,age:18,position:"Midfield")

                player1.save()
                player2.save()

                def location = new Location(contact:contactCoach,name:"loc_name",street:"cleghorn",city:"huntvalley",zipCode:"21030")

                location.save()

                def game = new Game(homeTeam:team,awayTeam:team2,location:location,date:2012,time:new Date())

                game.save()

                game.errors.allErrors.each{println it}
                    
            break
        } 
    }

    def destroy = {
    }

}
