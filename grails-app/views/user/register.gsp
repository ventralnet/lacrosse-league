<html>
<meta name="layout" content="main"/>

<script type="text/javascript">

$(document).ready(function() {
    $("#roleCombo").change(function() {
        $(".playerField").toggle();
    });

    <g:if test="${!user?.role || user.role.toLowerCase() == com.kirkley.lacrosse.Role.PLAYER.toLowerCase()}">
    $('select>option:eq(0)').attr('selected', true);
    $(".playerField").show();
    </g:if>
    <g:else>
    $('select>option:eq(1)').attr('selected', true);
    $(".playerField").hide();
    </g:else>
});
    
</script>

<h1>Register</h1>

    <div>
        <g:form name="registerForm" action="register" controller="user">
            <table>
                <tr>
                    <td>
                        <span>Role</span>
                    </td>
                    <td>
                        <g:select id="roleCombo" tabindex="0" name="role" from="${['Player','Coach']}" value="Player"
                            /></br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Email</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext ${hasErrors(bean:user,field:'emailAddress','error')}" name="emailAddress" value="${user?.emailAddress}" tabindex="1"/><br/>
                    </td>
                    <td>
                        <g:eachError var="err" field="emailAddress" bean="${user}">
                            <g:message error="${err}"/>
                        </g:eachError>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>First name</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext ${hasErrors(bean:user,field:'firstName','error')}" name="firstName" value="${user?.firstName}" tabindex="2"/><br/>
                    </td>
                    <td>
                        <g:eachError var="err" field="firstName" bean="${user}">
                            <g:message error="${err}"/>
                        </g:eachError>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Last name</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext ${hasErrors(bean:user,field:'lastName','error')}" name="lastName" value="${user?.lastName}" tabindex="3"/><br/>
                    </td>
                    <td>
                        <g:eachError var="err" field="lastName" bean="${user}">
                            <g:message error="${err}"/>
                        </g:eachError>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Phone number</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext ${hasErrors(bean:user,field:'phoneNumber','error')}" name="phoneNumber" value="${user?.phoneNumber}" tabindex="4"/><br/>
                    </td>
                    <td>
                        <g:eachError var="err" field="phoneNumber" bean="${user}">
                            <g:message error="${err}"/>
                        </g:eachError>
                    </td>
                </tr>
                <tr class="playerField">
                    <td>
                        <span>Age</span>
                    </td>
                    <td>
                        <input type="number" min="15" class="inputtext ${hasErrors(bean:user,field:'age','error')}" name="age" value="${user?.age}" tabindex="5"/><br/>
                    </td>
                    <td>
                        <g:eachError var="err" field="age" bean="${user}">
                            <g:message error="${err}"/>
                        </g:eachError>
                    </td>
                </tr>
                <tr class="playerField">
                    <td>
                        <span>Position</span>
                    </td>
                    <td>
                        <g:select tabindex="6" name="position" from="${['Attack','Defense','Midfield','Goalie']}" value="Attack"
                            /></br>
                    </td>
                    <td>
                        <g:eachError var="err" field="position" bean="${user}">
                            <g:message error="${err}"/>
                        </g:eachError>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Password</span>
                    </td>
                    <td>
                        <input type="password" class="inputtext ${hasErrors(bean:user,field:'password','error')}" name="password" id="password" value="${user?.password}" tabindex="7"/><br/>
                    </td>
                    <td>
                        <g:eachError var="err" field="password" bean="${user}">
                            <g:message error="${err}"/>
                        </g:eachError>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Password verify</span>
                    </td>
                    <td>
                        <input type="password" class="inputtext ${hasErrors(bean:user,field:'passwordConfirm','error')}" name="passwordConfirm" id="passwordConfirm" value tabindex="8"/><br/>
                    </td>
                    <td>
                        <g:eachError var="err" field="passwordConfirm" bean="${user}">
                            <g:message error="${err}"/>
                        </g:eachError>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input tabindex="9" type="submit" value="Register">
                    </td>
                </tr>
            </table>
        </g:form>
    </div>

</html>
