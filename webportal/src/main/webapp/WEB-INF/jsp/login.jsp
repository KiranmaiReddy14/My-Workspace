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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/index.css" />
<!-- <link rel="stylesheet" href="stylepopupbro.css" /> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Mail Order Pharmacy</title>

<style>

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}
  
</style>


</head>

<body>

	<nav class="navbar navbar-inverse ">
		<a href="index.html" class="navbar-brand">Mail Order Pharmacy</a>

		<!-- <button class="navbar-toggler navbar-toggler collapsed" type="button" data-toggle="collapse"
            data-target="#navbarText" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="my-1 mx-2 close">CLOSE</span>
            <span class="navbar-toggler-icon">OPEN</span>
        </button> -->

		<div class="" id="navbarText">
			<ul class="navbar-nav mr-auto text-center">
				<!-- <li class="nav-item"> -->
				<a class="nav-link"
					onclick="document.getElementById('loginModal').style.display='block'"
					id="loginBtn">Login</a>
				<!-- </li> -->
			</ul>
		</div>
	</nav>

	<br>
	<br>
	<br>

	<div id="loginModal" class="modal">

		<form class="modal-content animate" name="loginform" model="UserData"
			method="post" action="login">
			<h1 class="center">Login</h1>
			
			<div class="imgcontainer">
      			<img src="images/avatar.png" alt="Avatar" class="avatar">
    		</div>
    
			
			<span
				onclick="document.getElementById('loginModal').style.display='none'"
				class="closeModal" title="Close Modal">&times;</span> <br>
			<br>
			<div class="container">
				<!-- <label for="username"><b>Username</b></label> -->
				<fieldset>
					<input type="text" placeholder="" name="userid" id="username"
						required> <span class="floating-label"> Username</span>
				</fieldset>
				<!-- <label for="password"><b>Password</b></label> -->
				<fieldset>
					<input type="password" name="upassword" placeholder=""
						id="password" required> <span class="floating-label"> Password</span>
					<!-- <span class="floating-label">Name</span>
            <input id="name" name="name" type="text" class="inputText" required />
             -->
				</fieldset>
				<button type="submit" id="loginSubmit">Login</button>


				<h6 class="right">
					New user? Signup <a href="#">here</a>
				</h6>
			</div>
			<p>${errormsg}</p>
		</form>
	</div>




	<div class="row">
	<div class="col1" style="float:left;width:50%;padding:10px:height:300px;"></div>
	<div class="col1" style="float:left;width:48%;padding:10px:height:300px;text-align:justify">
	
	<br><br>
	<br><br>
	<h4>Mail-order pharmacies operate through your health insurance plan and
	can be cheaper and more convenient than getting your medications from a local pharmacy.</h4>
	<br>
	<br>
	<br>
	
	<h4>Mail-order pharmacies provide accurate and efficient pharmacy services. 
	Quality is our most important priority second only to customer service. 
	It offers pharmacy benefits and a good fit for you, using a mail-order 
	pharmacy can save you time and money without concession of quality.</h4>
	
	</div>
	</div>


	<img class="footImg" src="images/pill-tablet-pharmacy-medicine.png">


	<script>
		var modal = document.getElementById('loginModal');

		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>