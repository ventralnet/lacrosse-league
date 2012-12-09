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
            <tr id="standings_row">
               <td>${it.team.name}</td> 
               <td style="text-align:center">${it.winningGames.size()}</td>
               <td style="text-align:center">${it.losingGames.size()}</td>
               <td style="text-align:center">${it.totalGames.size()}</td>
            </tr>
        </g:each>
    </table>

</html>
