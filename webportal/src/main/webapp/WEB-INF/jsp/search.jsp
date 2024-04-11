<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <title>Mail Order Pharmacy</title>
    <style type="text/css">
    .flip-card {
  background-color: transparent;
  width: 300px;
  height: 300px;
  perspective: 1000px;
  margin-right: 5px;
}

.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.6s;
  transform-style: preserve-3d;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
}

.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}

.flip-card-front {
  background-color: #bbb;
  color: black;
}

.flip-card-back {
  background-color: #2980b9;
  color: white;
  transform: rotateY(180deg);
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
      
    
     
    <br><br><br>
   
	<form name="searchDrugs" model="searchModel" action="/webportal/searchDrugById" method="post">
        <div class="row">
            <div class="col-4">
                <h1>Search Drug by Id :</h1>
            </div>
            <div class="col-4">
                <input class="w-75 mt-4 d-flex justify-content-right" type="text" name="id">
            </div>
            <div class="col-4">
                <button type="submit" class="btn btn-outline-success btn-lg mt-2"
                    style="margin-right:55%;">Submit</button>
            </div>
        </div>
    </form>
    <br>
    <form name="searchDrugs" model="searchModel" action="/webportal/searchDrugByName" method="post">
        <div class="row">
            <div class="col-4">
                <h1 class="text-nowrap">Search Drug by Name :</h1>
            </div>
            <div class="col-4">
                <input class="w-75 mt-4 d-flex justify-content-right" type="text" name="name">
            </div>
            <div class="col-4">
                <button type="submit" class="btn btn-outline-success btn-lg mt-2"
                    style="margin-right:55%;">Submit</button>
            </div>
        </div>
    </form>
    <p class="center">${drugdetails.msg}</p>

    <section id="services">
        <div class="container">
            <div class="d-flex flex-row">
                <div class="flip-card">
                    <div class="flip-card-inner">
                        <div class="flip-card-front ">
                            <h1>${drugdetails.drugName}</h1>
                            <h6>ID: ${drugdetails.drugId}</h6><br>
                            <h6>Manufacturer:${drugdetails.manufacturer}</h6><br>
                            <h6>Mfg Date:${drugdetails.manufactureDate}</h6><br>
                            <h6>Exp Date:${drugdetails.expiryDate}</h6><br>
                        </div>
                        <div class="flip-card-back">
                            <h1>Availability</h1><br>
                            <c:forEach items="${drugdetails.druglocationQuantities}" var="itr1">
                                <p>${itr1.location} : ${itr1.quantity}</p><br>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <br>
            </div>


        </div>
    </section>
  	

    <br><br><br><br>


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