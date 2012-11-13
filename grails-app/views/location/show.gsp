<html>
<meta name="layout" content="main"/>

<h1>Locations</h1>

<table>
<g:each in="${locations}">
    <tr class="game_summary_row ${gameComplete ? 'completed' : ''}">
        <td>${it.fieldName}</td>            
        <td>${it.street}</td>            
        <td>${it.city}</td>            
        <td>${it.zipCode}</td>            
    </tr> 
    
</g:each>
</table>


</html>
