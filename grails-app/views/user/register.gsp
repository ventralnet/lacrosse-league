<html>
<meta name="layout" content="main"/>

<h1>Register</h1>

    <div>
        <g:form name="registerForm" action="register" controller="user">
            <span>Email</span>
            <input type="text" class="inputtext" name="contact.emailAddress" value="${player?.contact?.emailAddress}" tabindex="1"/><br/>
            <span>First name</span>
            <input type="text" class="inputtext" name="contact.firstName" value="${player?.contact?.firstName}" tabindex="2"/><br/>
            <span>Last name</span>
            <input type="text" class="inputtext" name="contact.lastName" value tabindex="3"/><br/>
            <span>Phone number</span>
            <input type="text" class="inputtext" name="contact.phoneNumber" value tabindex="4"/><br/>
            <span>Age</span>
            <input type="text" class="inputtext" name="age" value tabindex="5"/><br/>
            <span>Position</span>
            <input type="text" class="inputtext" name="position" value tabindex="6"/><br/>
            <span>Password</span>
            <input type="password" class="inputtext" name="contact.password" id="contact.password" tabindex="6"/><br/>
            <span>Password verify</span>
            <input type="password" class="inputtext" name="password_verify" id="password" tabindex="6"/><br/>
            <input type="submit" value="Register">
        </g:form>
    </div>

</html>
