<html>
    <head>
        <title>The Kirks Lacrosse Team</title>
        <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'all.css')}"/>
        <g:javascript library="jquery"/>
        <r:layoutResources/>
        <g:javascript>
            $(document).ready(function() {
                $('.login_form').hide();

                var flashMessage = "${flash.message}" + "";
                if (flashMessage != "" ){
                    showLoginForm();
                }

                $('#login_link').click(showLoginForm);

                function showLoginForm() {
                    $('#login_register').hide();
                    $('.login_form').show();
                }
            });    
        </g:javascript>
        <r:layoutResources/>
    </head>

    <body>

        <div id="body">
    
            <div id="header">
                <div id="team_name_header">
                    <h1>The Baltimore Kirks</h1>
                </div>
                <g:if test="${session.user}">
                    <div>Welcome, ${session.user.firstName} <g:link action="logout" controller="user">Logout</g:link></div> 
                </g:if>
                <g:else>
                <div id="login_container">
	                <div id="login_register">
	                    <g:if test="!${flash.message}">
	                        <table>
	                            <tr>
	                                <td>
	                                    <a id="login_link" href="#">Login</a> 
	                                </td>
	                                <td>
	                                   <g:link elementId="register_link" action="register" controller="user">Register</g:link> 
	                                </td>
	                            </tr>
	                        </table>
	                    </g:if>
	                </div>
	                <div>
	                    <div class="login_form">
	                        <g:form name="loginForm" action="login" url="[controller: 'user', action:'login']">
	                            <table>
	                                <tr>
	                                    <td>
	                                        <div id="flash_container">
	                                            <g:if test="${flash.message}">
	                                            ${flash.message}
	                                            </g:if>
	                                        </div>
	                                    </td>
	                                    <td>
	                                        <input type="text" class="inputtext" name="email" id="email" value tabindex="1"/>
	                                    </td>
	                                    <td>
	                                        <input type="password" class="inputtext" name="password" id="password" tabindex="2"/>
	                                    </td>
	                                    <td>
	                                        <input type="submit" value="Login">
	                                    </td>
	                                    <td>
	                                       <g:if test="!${flash.message}">
	                                           <g:link elementId="register_link" action="register" controller="user">Register</g:link> 
	                                       </g:if>
	                                    </td>
	                                </tr>
	                            </table>
	                        </g:form>
	                    </div>
	                </div>
	                </g:else>
                </div>
            </div>

        </div>

        <div style="clear:both"/>

        <div>
            <ul>
                <li><g:link controller="team">Team Schedule</g:link></li>
                <li><g:link controller="league" action="standings">League Standings</g:link></li>
                <li><g:link controller="team" action="roster">Team Roster</g:link></li>
                <g:if test="${session.user}">
                    <li><g:link controller="user" action="edit">Edit Profile</g:link></li>
                </g:if>
            </ul>
        </div>


        <div style="clear:both"/>

        <g:layoutBody/>
    </body>


</html>
