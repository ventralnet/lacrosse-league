<html>
<meta name="layout" content="main"/>

<h1>Register</h1>

    <div>
        <g:form name="registerForm" action="register" controller="user">
            <span>Email</span>
            <input type="text" class="inputtext" name="contact.emailAddress" value tabindex="1"/>
            <span>First name</span>
            <input type="text" class="inputtext" name="contact.firstName" value tabindex="2"/>
            <span>Last name</span>
            <input type="text" class="inputtext" name="contact.lastName" value tabindex="3"/>
            <span>Phone number</span>
            <input type="text" class="inputtext" name="contact.phoneNumber" value tabindex="4"/>
            <span>Age</span>
            <input type="text" class="inputtext" name="age" value tabindex="5"/>
            <span>Position</span>
            <input type="text" class="inputtext" name="position" value tabindex="6"/>
            <span>Password</span>
            <input type="password" class="inputtext" name="password" id="contact.password" tabindex="6"/>
            <span>Password verify</span>
            <input type="password" class="inputtext" name="password_verify" id="password" tabindex="6"/>
            <input type="submit" value="Register">
        </g:form>
    </div>

</html>
