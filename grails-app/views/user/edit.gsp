<html>
<meta name="layout" content="main"/>

<h1>Edit Profile</h1>

    <div>
        <g:form name="registerForm" action="edit" controller="user" id="${params.id}">
		<table>
			<tr>
				<td><span>Email</span></td>
				<td><input type="text" class="inputtext" name="emailAddress"
					value="${contact?.emailAddress}" tabindex="1" /><br /></td>
			</tr>
			<tr>
				<td><span>First name</span></td>
				<td><input type="text" class="inputtext" name="firstName"
					value="${contact?.firstName}" tabindex="2" /><br /></td>
			</tr>
			<tr>
				<td><span>Last name</span></td>
				<td><input type="text" class="inputtext" name="lastName"
					value="${contact?.lastName}" tabindex="3" /><br /></td>
			</tr>
			<tr>
				<td><span>Phone number</span></td>
				<td><input type="text" class="inputtext" name="phoneNumber"
					value="${contact?.phoneNumber}" tabindex="4" /><br /></td>
			</tr>
			<g:if test="${contact.role.type == com.kirkley.lacrosse.Role.PLAYER}">
				<tr>
					<td><span>Age</span></td>
					<td><input type="text" class="inputtext" name="age"
						value="${player?.age}" tabindex="5" /><br /></td>
				</tr>
				<tr>
					<td><span>Position</span></td>
					<td>
                        <g:select tabindex="6" name="position" from="${['Attack','Defense','Midfield','Goalie']}" value="${player?.position}"
                            /></br>
						</td>
				</tr>
			</g:if>
			<tr>
				<td><span>Password</span></td>
				<td><input type="password" class="inputtext" name="password"
					id="password" value="${contact?.password}" tabindex="7" /><br /></td>
			</tr>
			<tr>
				<td><span>Password verify</span></td>
				<td><input type="password" class="inputtext"
					name="password_verify" id="password_verify" value="${contact?.password}" tabindex="8" /><br /></td>
			</tr>
		</table>
		<input tabindex="8" type="submit" value="Update">
	</g:form>
    </div>

</html>
