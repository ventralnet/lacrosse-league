<html>
    <meta name="layout" content="main"/>

    <h1>Game schedule</h1>

    <p>The Kirks Roster</p>

    <table>
        <g:each in="${players}">
            <tr>
               <td>${it.contact.lastName}, ${it.contact.firstName}</td> 
               <td>${it.position}</td>
            </tr>
        </g:each>
    </table>

</html>
