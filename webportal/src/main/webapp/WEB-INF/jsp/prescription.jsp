<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

    <title>Mail Order Pharmacy</title>
    <style type="text/css">
    .w-50{
    	min-width:60%;
    }
    	.half-entry{
    width: 50%;
    float: left;
  }
  .btn{
    padding: 14px 30px;
    margin: 33px 500px;
    float: right;
    background: none;
    border: solid 2px #474544;
    color: #474544;
    cursor: pointer;
    display: inline-block;
    font-family: 'Helvetica', Arial, sans-serif;
    font-size: 0.875em;
    width: fit-content;
    font-weight: bold;
    outline: none;
    /* margin-left: 36%; */

  }
    </style>
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
    <br><br><br>
    <h1 class="center">Prescription Details</h1>
	<h3 class="center">${msg}</h3>
    <div class="container mt-5">

        <form name="prescriptionform" model="prescriptionDetails" method="post" onsubmit="return validate()"
            action="subscribe">
            <div class="half-entry">
                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="insuranceProvider">Insurance Provider</label>
                    </div>
                    <div class="col d-flex justify-content-left">
                        <input type="text" id="insurancePolicyNumber" name="insuranceProvider" class="w-50" required tabIndex="1">
                        <span class="text-danger" id="insuranceProviderSpan"></span><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="policyNumber">Policy Number</label>

                    </div>
                    <div class="col d-flex justify-content-left">

                        <input type="text" id="insuranceProvider" name="policyNumber" class="w-50" required tabIndex="2">
                        <span class="text-danger" id="policyNumberSpan"></span><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="doctorName">Doctor Name</label><br>
                    </div>
                    <div class="col d-flex justify-content-left">
                        <input type="text" id="drugName" name="doctorName" class="w-50" required tabIndex="3">
                        <span class="text-danger" id="doctorNameSpan"></span><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="prescriptionDate">Prescription Date</label><br>
                    </div>
                    <div class="col d-flex justify-content-left">
                        <input type="date" id="prescriptionDate" name="prescriptionDate" class="w-50" required tabIndex="4">
                        <span class="text-danger" id="prescriptionDateSpan"></span><br>
                    </div>
                </div>
           
                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="Location">Your Location</label>
                    </div>
                    <div class="col d-flex justify-content-left">
                        <input type="text" id="quantity" name="memberLocation" class="w-50" required tabIndex="5">
                        <span class="text-danger" id="memberLocationSpan"></span><br>
                    </div>
                </div>
            </div>
            <div class="half-entry">
                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="drugName">Medicine Name</label>
                    </div>
                    <div class="col d-flex justify-content-left">
                        <input type="text" id="Dosage" name="drugName" class="w-50" required tabIndex="6">
                        <span class="text-danger" id="drugNameSpan"></span><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="dosageDefinition">Dosage Definitions</label>
                    </div>
                    <div class="col d-flex justify-content-left">
                        <input type="text" id="Dosage" name="dosageDefinition" class="w-50" required tabIndex="7">
                        <span class="text-danger" id="dosageDefinitionSpan"></span> <br>
                    </div>
                </div>
                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="quantity">Quantity</label>
                    </div>
                    <div class="col d-flex justify-content-left">
                        <input type="number" id="doctorName" name="quantity" min="1" class="w-50" required tabIndex="8">
                        <span class="text-danger" id="quantitySpan"></span><br>
                    </div>
                </div>

                <div class="row">
                    <div class="col d-flex justify-content-left">
                        <label for="courseDuration">Course Duration</label>
                    </div>
                    <div class="col d-flex justify-content-left">
                        <input type="number" id="memberLocation" name="courseDuration" min="1" class="w-50" required tabIndex="9">
                        <span class="text-danger" id="courseDurationSpan"></span><br>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-success">Submit</button>

        </form>

    </div>

    <br><br><br><br>

	<script src="js/Prescription.js"></script>
	<script type="text/javascript">
        $(document).on('keypress', 'input,select', function (e) {
            if (e.which == 13) {
                e.preventDefault();
                var $next = $('[tabIndex=' + (+this.tabIndex + 1) + ']');
                console.log($next.length);
                if (!$next.length) {
                    $next = $('[tabIndex=1]');
                }
                $next.focus().click();
            }
        });
    </script>

</body>

</html>