<html>
<meta name="layout" content="main"/>

<h1>Game schedule</h1>

<p>Click a game for location information</p>

<table>
<g:each in="${games}">
    <g:set var="gameComplete" value="${it.homeScore != 0 || it.awayScore != 0}" />
    <tr class="game_summary_row ${gameComplete ? 'completed' : ''}">
        <td>${it.homeTeam.name} vs. ${it.awayTeam.name} @ ${it.location.fieldName}</td>            
        <td><g:formatDate format="E, MM/dd/yyyy" date="${it.date}"/></td>
        <td><g:formatDate format="h:mm a" date="${it.time}"/></td>
        <td>${it.homeScore} - ${it.awayScore}</td>
    </tr> 
    
</g:each>
</table>


</html>
