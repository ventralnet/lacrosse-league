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

        <div id="main_container">
    
            <div id="header">
                <div style="float:left" id="team_name_header">
                    <g:img dir="images" file="unclesam_lacrosse_400x50.jpg"/>
                    <h1 style="display:inline">The Baltimore Kirks</h1>
                </div>
                <g:if test="${session.user}">
                    <div style="float:right">Welcome, ${session.user.firstName} <g:link action="logout" controller="user">Logout</g:link></div> 
                </g:if>
                <g:else>
                <div style="float:right" id="login_register">
                    <g:if test="!${flash.message}">
                        <table>
                            <tr>
                                <td>
                                    <a id="login_link" style:"display:inline" href="#">Login</a> 
                                </td>
                                <td>
                                   <g:link elementId="register_link" action="register" controller="user">Register</g:link> 
                                </td>
                            </tr>
                        </table>
                    </g:if>
                </div>
                <div class="rfloat">
                    <div class="login_form">
                        <g:form name="loginForm" action="login" url="[controller: 'user', action:'login']">
                            <table>
                                <tr>
                                    <td>
                                        <div style="float:right;color:red" id="flash_container">
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


        <div style="clear:both"/>

        <div id="nav_menu" class="float:left">
            <ul>
                <li><g:link controller="team">Team Schedule</g:link></li>
                <li><g:link controller="league" action="standings">League Standings</g:link></li>
                <li><g:link controller="location" action="show">Locations</g:link></li>
                <li><g:link controller="team" action="roster">Team Roster</g:link></li>
                <g:if test="${session.user}">
                    <li><g:link controller="user" action="edit" id="${session.user.id}">Edit Profile</g:link></li>
                </g:if>
            </ul>
        </div>


        <div style="clear:both"/>

        <g:layoutBody/>
        </div>
    </body>


</html>
