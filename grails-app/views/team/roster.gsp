<html>
    <meta name="layout" content="main"/>

    <h1>Kirks Team Roster</h1>

    <table>
        <g:each in="${players}">
            <tr>
               <td>${it.contact.lastName}, ${it.contact.firstName}</td> 
               <td>${it.position}</td>
            </tr>
        </g:each>
    </table>

</html>
