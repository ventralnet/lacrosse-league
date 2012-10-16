<html>
    <meta name="layout" content="main"/>
    <%@ page import="com.kirkley.lacrosse.Role" %>

    <h1>Kirks Team Roster</h1>

    <table>
        <g:each in="${players}">
            <tr>
               <td>${it.contact.lastName}, ${it.contact.firstName}</td> 
               <td>${it.position}</td>
               <g:if test="${session.user && session.user.role.type == Role.COACH}">
                    <td><g:link controller="user" action="edit" id="${it.id}">Edit Contact</g:link></td>
               </g:if>
            </tr>
        </g:each>
    </table>

</html>
