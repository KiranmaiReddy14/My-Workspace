<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="style/index.css" />
    <!-- <link rel="stylesheet" href="stylepopupbro.css" /> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <title>Mail Order Pharmacy</title>
</head>

<body>



    <nav class="navbar navbar-inverse ">
        <a href="home" class="navbar-brand">Mail Order Pharmacy</a>

        <!-- <button class="navbar-toggler navbar-toggler collapsed" type="button" data-toggle="collapse"
            data-target="#navbarText" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="my-1 mx-2 close">CLOSE</span>
            <span class="navbar-toggler-icon">OPEN</span>
        </button> -->

        <div class="" id="navbarText">
            <ul class="navbar-nav mr-auto text-center">
                
                <!-- <li class="nav-item"> -->
                    <div id="main">
                        <button class="openbtn" onclick="openNav()">Services</button>
                    
                <!-- </li> -->
            </ul>
        </div>
    </nav>
    <div id="mySidebar" class="sidebar">
        <br>
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="supportedDrugs">Available Drugs</a>
        <a href="search">Search Drugs</a>
        <a href="prescriptionform">Subscribe</a>
        <a href="subscriptions">Subscriptions</a>
        <a href="subscriptions">Adhoc Refill</a>
        <a href="refillstatus">Refill Status</a>
        <a href="refillDateEntry">Refill Due Date</a>
        <a href="logout">Logout</a>
      </div>
      
    
     
    <br><br><br>
    <div class="container">
			
			 <br> <br>
			<h1>Your Subscriptions</h1>
			<h3 class="center">${message}</h3>
			  <div class="container bcontent"> 
				<hr />
				<div class="container">
					<table class="table table-fluid" id="myTable">
						<thead>
							<tr>
								<th>drugName</th>
								<th>quantity</th>
								<th>Refill Cycle</th>
								<th>Status</th>
								<th>Location</th>
								<th>Subscribed on</th>
								<th>unsubscribe</th>
								<th>Request refill</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty subscriptionList}">
									<c:forEach items="${subscriptionList}" var="subscription">

										<tr>
											<td>${subscription.drugName }</td>
											<td>${subscription.quantity }</td>
											<td>${subscription.refillCycle }</td>
											<td>${subscription.subscriptionStatus }</td>
											<td>${subscription.memberLocation }</td>
											<td>${subscription.subscriptionDate }</td>
												<form method=post
													action="unsubscribe/${subscription.subscriptionId }">
													<td><input class="btn btn-success" type=submit
														value="Unsubscribe"> </td>
													<td><a class="btn btn-secondary"
														href="adhocRefill/${subscription.subscriptionId}">
														Request refill</a></td>

												</form>
										</tr>


									</c:forEach>
								</c:when>
								<c:otherwise>
									<h3>${msg}</h3>
									<br>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					<script>
						$(document).ready(function() {
							$('#myTable').DataTable();
						});
					</script>
				</div>

			</div>
	 </div>  


    <script>
        function openNav() {
document.getElementById("mySidebar").style.width = "300px";
//   document.getElementById("main").style.marginRight = "250px";
//   document.getElementsById("closer").style.marginRight = "250px";

}

/* Set the width of the sidebar to 0 and the left margin of the page content to 0 */
function closeNav() {
document.getElementById("mySidebar").style.width = "0";
//   document.getElementById("main").style.marginRight = "0";
//   document.getElementsById("closer").style.marginRight = "0";
}
    </script>
</body>

</html>