
<%@include file="include/header.jsp"  %>
<!-- ======= About Us Section ======= -->

<section id="imageupload" class="imageupload">
	<div class="container" data-aos="fade-up">
		<div class="section-title">
			<h2>Add User</h2>
		</div>		
		<div class="row content">
			<div class="col-lg-6">
				 <form action="${pageContext.request.contextPath}/operation?page=imageupload" enctype="multipart/form-data" method="POST" role="form"   >
              <div class="row">
                <div class="form-group col-md-10">
                  <label for="name">Select file</label>
                   <input type="hidden" name ="users_id" value="${param.usersid }" required="required"   />
                  <input type="file" name="files" class="form-control" id="file"  multiple required>
                </div>              
              </div>           
              <div class="my-3">
                <div class="error-message"></div>                
              </div>
              <input  value="Upload" type="submit"> 
            </form>
			</div>			
		</div>
	</div>
</section>
<!-- End About Us Section -->

<%@include file="include/footer.jsp"  %>

