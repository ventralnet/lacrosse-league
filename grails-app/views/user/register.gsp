<html>
<meta name="layout" content="main"/>

<h1>Register</h1>

    <div>
        <g:form name="registerForm" action="register" controller="user">
            <table>
                <tr>
                    <td>
                        <span>Email</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext" name="contact.emailAddress" value="${player?.contact?.emailAddress}" tabindex="1"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>First name</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext" name="contact.firstName" value="${player?.contact?.firstName}" tabindex="2"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Last name</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext" name="contact.lastName" value="${player?.contact?.lastName}" tabindex="3"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Phone number</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext" name="contact.phoneNumber" value="${player?.contact?.phoneNumber}" tabindex="4"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Age</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext" name="age" value="${player?.age}" tabindex="5"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Position</span>
                    </td>
                    <td>
                        <input type="text" class="inputtext" name="position" value="${player?.position}" tabindex="6"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Password</span>
                    </td>
                    <td>
                        <input type="password" class="inputtext" name="contact.password" id="contact.password" value tabindex="7"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Password verify</span>
                    </td>
                    <td>
                        <input type="password" class="inputtext" name="password_verify" id="password" value tabindex="8"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Register">
                    </td>
                </tr>
            </table>
        </g:form>
    </div>

</html>
