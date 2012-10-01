<html>
    <head>
        <title>The Kirks Lacrosse Team</title>
        <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'all.css')}"/>
        <g:javascript library="jquery"/>
        <r:layoutResources/>
        <g:javascript>
            $(document).ready(function() {
                $('.login_container').hide();

                $('#login_link').click(function() {
                    $('#login_link').hide();
                    $('.login_container').show();
                });
            });    
        </g:javascript>
        <r:layoutResources/>
    </head>

    <body>
    <h1 style="display:inline">The Baltimore Kirks</h1>

    <g:if test="${session.user}">
           <div style="float:right">Welcome, ${session.user.firstName} <g:link action="logout" controller="user">Logout</g:link></div> 
    </g:if>
    <g:elseif test="${flash.message}"> 
        <div class="rfloat">
            <div class="login_container_error">
                <g:form name="loginForm" action="login" url="[controller: 'user', action:'login']">
                    <input type="text" class="inputtext" name="email" id="email" value tabindex="1"/>
                    <input type="password" class="inputtext" name="password" id="password" tabindex="2"/>
                    <input type="submit" value="Login">
                </g:form>
            </div>
        </div>
        <div style="color:red" class="rfloat">
            ${flash.message}
        </div>
    </g:elseif>
    <g:else>
        <div class="rfloat">
            <a id="login_link" style="float:right" href="#">Login</a>
        </div>
    </g:else>

    <div class="rfloat">
        <div class="login_container">
            <g:form name="loginForm" action="login" url="[controller: 'user', action:'login']">
                <input type="text" class="inputtext" name="email" id="email" value tabindex="1"/>
                <input type="password" class="inputtext" name="password" id="password" tabindex="2"/>
                <input type="submit" value="Login">
            </g:form>
        </div>
    </div>

    <g:layoutBody/>
    </body>

</html>
