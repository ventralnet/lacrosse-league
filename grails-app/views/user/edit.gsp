<html>
<meta name="layout" content="main"/>

<h1>Edit Profile</h1>

    <div>
        <g:form name="registerForm" action="edit" controller="user" id="${params.id}">
            <span>Email</span>
            <input type="text" class="inputtext" name="emailAddress" value="${contact?.emailAddress}" tabindex="1"/><br/>
            <span>First name</span>
            <input type="text" class="inputtext" name="firstName" value="${contact?.firstName}" tabindex="2"/><br/>
            <span>Last name</span>
            <input type="text" class="inputtext" name="lastName" value="${contact?.lastName}" tabindex="3"/><br/>
            <span>Phone number</span>
            <input type="text" class="inputtext" name="phoneNumber" value="${contact?.phoneNumber}" tabindex="4"/><br/>
            <g:if test="${contact.role.type == com.kirkley.lacrosse.Role.PLAYER}">
                <span>Age</span>
                <input type="text" class="inputtext" name="age" value="${player?.age}" tabindex="5"/><br/>
                <span>Position</span>
                <input type="text" class="inputtext" name="position" value="${player?.position}" tabindex="6"/><br/>
            </g:if>
            <span>Password</span>
            <input type="password" class="inputtext" name="password" id="contact?.password" value tabindex="7"/><br/>
            <span>Password verify</span>
            <input type="password" class="inputtext" name="password_verify" id="password" value tabindex="8"/><br/>
            <input type="submit" value="Update">
        </g:form>
    </div>

</html>
