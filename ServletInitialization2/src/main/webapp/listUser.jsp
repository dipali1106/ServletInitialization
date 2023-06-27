<%@include file="include/header.jsp"  %>
<%@ page import="java.util.List" %>
<%@ page import="org.study.entity.UserEntity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="listUser" class="about">
	<div class="container" data-aos="fade-up">
		<div class="row content">
			<div class="col-lg-6">
				<strong> Users Listing</strong>
				<hr />
				<table border="1" padding="20px">
				<thead>
				<th> User Id</th><th> Username</th><th> Email</th><th>operation</th>
				<%! //String deleteUrl; %>
				</thead>
				<c:forEach  items="${listUsers }" var="user">
				<c:url var="updateUser" value="operation">
				<c:param name="page" value="updateUser"></c:param>
				<c:param name="usersid" value="${user.users_id }"></c:param>
				<c:param name="username" value="${user.username }"></c:param>
				<c:param name="email" value="${user.email }"></c:param>
				</c:url>
				
				<c:url var="deleteUser" value="operation">
				<c:param name="page" value="deleteUser"></c:param>
				<c:param name="usersid" value="${user.users_id }"></c:param>
				</c:url>
				<c:url var="imageUpload" value="operation">
				<c:param name="page" value="imageUpload"></c:param>
				<c:param name="usersid" value="${user.users_id }"></c:param>
				</c:url>
				
				<tr>
				<td> ${user.users_id }</td>
				<td> ${user.username } </td>
				<td> ${user.email } </td>
				
				<td> <a href="${updateUser }" > Update </a>
				<a href="${deleteUser }"  onclick="if(!confirm('Are you sure to delete this user?')) return false"  >Delete </a>
				<a href=${imageUpload } > image </a>
				</tr>
				
				</c:forEach>
				
			
				
				<% /**
				String tempUrl;
				List<UserEntity> listUsers =(List)request.getAttribute("listUsers");
				for(int i=0;i<listUsers.size();i++){
					out.print("<tr>");
					out.print("<td>"+listUsers.get(i).getUsers_id()+"</td>");
					out.print("<td>"+listUsers.get(i).getUsername()+"</td>");
					out.print("<td>"+listUsers.get(i).getEmail()+"</td>");
					tempUrl = request.getContextPath()+"/operation?page=updateUser&usersid="+
														listUsers.get(i).getUsers_id()+
											"&username="+listUsers.get(i).getUsername()+
											"&email="+listUsers.get(i).getEmail();
					deleteUrl = request.getContextPath()+"/operation?page=deleteUser&usersid="+
											listUsers.get(i).getUsers_id();
					out.print("<td><a href="+tempUrl+"> Update </a> | "); **/
					%>
					<a href="<%// deleteUrl%>"  onclick="if(!confirm('Are you sure to delete this user?')) return false" >Delete </a></td>
					</tr>
				<% //}
				%>
				
				</table>
			</div>

		</div>

	</div>
</section>
<!-- End About Us Section -->

<%@include file="include/footer.jsp" %>
