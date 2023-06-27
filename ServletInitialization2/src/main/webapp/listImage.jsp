<%@include file="include/header.jsp"  %>
<%@ page import="java.util.List" %>
<%@ page import="org.study.entity.UserEntity" %>
<%@ page import="org.study.entity.Files" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="listUser" class="about">
	<div class="container" data-aos="fade-up">
		<div class="row content">
			<div class="col-lg-6">
				<strong> File Listing</strong>
				<hr />
				<table border="1" padding="20px">
				<thead>
				<th> File Id</th><th> File</th><th>operation</th>
				<%! //String deleteUrl; %>
				</thead>
				<% List <Files> files = (List)request.getAttribute("files");
					for(Files file:files){
						out.print("<tr>");
						out.print("<td>"+file.getId()+"</td>");
						
						out.print("<td> <img src='"+file.getFileName()+"' width='100' height='100' /> </td>");
						out.print("<td>"+file.getCaption()+"</td>");
						out.print("</tr>");
					}
				%>		
							
				</table>
			</div>

		</div>

	</div>
</section>
<!-- End About Us Section -->

<%@include file="include/footer.jsp" %>
