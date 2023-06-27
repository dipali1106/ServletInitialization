
<%@include file="include/header.jsp"  %>
<!-- ======= About Us Section ======= -->

<section id="adduser" class="adduser">
	<div class="container" data-aos="fade-up">
		<div class="section-title">
			<h2>Add User</h2>
		</div>
		
		<div class="row content">
			<div class="col-lg-6">
				 <form action="${pageContext.request.contextPath}/operation?page=adduser" method="post" role="form" >
              <div class="row">
                <div class="form-group col-md-10">
                  <label for="name">Your Name</label>
                  <input type="hidden" name ="form" value="adduseroperation" required="required" />
                  <input type="text" name="username" class="form-control" id="username" required>
                </div>
                <div class="form-group col-md-10">
                  <label for="name">Your Email</label>
                  <input type="email" class="form-control" name="email" id="email" required>
                </div>
              </div>
            
              <div class="my-3">
                <div class="error-message"></div>
                
              </div>
              <input  value="Save" type="submit"> 
            </form>

			</div>
			
		</div>

	</div>
</section>
<!-- End About Us Section -->

<%@include file="include/footer.jsp"  %>

