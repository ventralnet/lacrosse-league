<html>
    <meta name="layout" content="main"/>

    <h1>League Standings</h1>

    <table>
        <tr>
            <th>Team</th>
            <th>Wins</th>
            <th>Losses</th>
            <th>Total Games Played</th>
        </tr>
        <g:each in="${teamStats}">
            <tr>
               <td>${it.team.name}</td> 
               <td>${it.winningGames.size()}</td>
               <td>${it.losingGames.size()}</td>
               <td>${it.totalGames.size()}</td>
            </tr>
        </g:each>
    </table>

</html>
