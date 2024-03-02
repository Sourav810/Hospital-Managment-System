<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<%@include file="../component/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.card:hover {
border: 1px solid #e9cbee;
    background-color: #adf2d2;
    color: rgb(0, 0, 0);
    transition:0.1s;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<c:if test="${ empty adminObj }">
	<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>

	<div class="container p-5">
		<p class="text-center fs-3" style="font-weight: bold;">Admin Dashboard</p>
		
		<c:if test="${not empty succMsg }">
			<p class="text-center text-success fs-3">${succMsg}</p>
			<c:remove var="succMsg" scope="session" />
		</c:if>

		<c:if test="${not empty errorMsg }">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<!-- <div class="row"> 
		 	<div class="col-md-8 p-5">  -->

		<div class="row">

			<div class="col-md-4 mb-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4">
							Doctor<br>5
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fa-solid fa-users fa-3x"></i><br>
						<p class="fs-4">
							User<br>43
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fa-solid fa-calendar-check fa-3x"></i><br>
						<p class="fs-4">
							Total Appointment<br>453
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card" data-toggle="modal" data-target="#exampleModal">
					<div class="card-body text-center text-success">
						<i class="fa-solid fa-stethoscope fa-3x"></i><br>
						<p class="fs-4">
							Specialist<br>34
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>

	<div class="col-md-4">
		<img alt="" src="img/free.jpg">
	</div>

	</div>
	</div>

<!-- Using bootstrap-model to make the addSpecialist frontend popUp -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="../addSpecialist" method="post">
        	
        	<div class="form-group">
        		<label>Enter Specialist Name</label>
        		<input type="text" name="specName" class="form-control">
        	</div>
        	
        	<div class="text-center mt-3">
        		<button type="submit" class="btn btn-success"> Add</button>
        	</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

<!-- PopUp ends here -->

</body>
</html>