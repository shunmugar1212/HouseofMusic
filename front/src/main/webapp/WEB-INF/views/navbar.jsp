<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>
<style>
/*
Code snippet by maridlcrmn for Bootsnipp.com
Follow me on Twitter @maridlcrmn
*/

.navbar-brand { position: relative; z-index: 2;}

.navbar-nav.navbar-right .btn { position: relative; z-index: 2; padding: 4px 20px; margin: 10px 5px; transition: transform 0.1s; }

.navbar .navbar-collapse { position: relative; overflow: hidden !important; }
.navbar .navbar-collapse .navbar-right > li:last-child { padding-left: 22px; }

.navbar .nav-collapse { position: absolute; z-index: 1; top: 0; left: 0; right: 0; bottom: 0; margin: 0; padding-right: 120px; padding-left: 80px; width: 100%; }
.navbar.navbar-default .nav-collapse { background-color: #f8f8f8; }
.navbar.navbar-inverse .nav-collapse { background-color: #222; }
.navbar .nav-collapse .navbar-form { border-width: 0; box-shadow: none; }
.nav-collapse>li { float: right; }

.btn.btn-circle { border-radius: 50px; }
.btn.btn-outline { background-color: transparent; }

.navbar-nav.navbar-right .btn:not(.collapsed) {
    background-color: rgb(111, 84, 153);
    border-color: rgb(111, 84, 153);
    color: rgb(255, 255, 255);
}

.navbar.navbar-default .nav-collapse,
.navbar.navbar-inverse .nav-collapse {
    height: auto !important;
    transition: transform 0.3s;
    transform: translate(0px,-50px);
}
.navbar.navbar-default .nav-collapse.in,
.navbar.navbar-inverse .nav-collapse.in {
    transform: translate(0px,0px);
}


@media screen and (max-width: 767px) {
    .navbar .navbar-collapse .navbar-right > li:last-child { padding-left: 15px; padding-right: 15px; } 
    
    .navbar .nav-collapse { margin: 7.5px auto; padding: 0; }
    .navbar .nav-collapse .navbar-form { margin: 0; }
    .nav-collapse>li { float: none; }
    
    .navbar.navbar-default .nav-collapse,
    .navbar.navbar-inverse .nav-collapse {
        transform: translate(-100%,0px);
    }
    .navbar.navbar-default .nav-collapse.in,
    .navbar.navbar-inverse .nav-collapse.in {
        transform: translate(0px,0px);
    }
    
    .navbar.navbar-default .nav-collapse.slide-down,
    .navbar.navbar-inverse .nav-collapse.slide-down {
        transform: translate(0px,-100%);
    }
    .navbar.navbar-default .nav-collapse.in.slide-down,
    .navbar.navbar-inverse .nav-collapse.in.slide-down {
        transform: translate(0px,0px);
    }
}
a.tit {
    font-family: 'Sofia';
    font-size: xx-large;
    font-color:#d80846;
}
a.nor {
    font-family: 'Sofia';
    font-size: medium;
    font-color:#d80846 ! important;
}
</style>

<style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    position: relative;
    background-color: #000000;
    margin: auto;
    padding: 0;
    border: 1px solid #888;
    width: 50%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
    from {top:-300px; opacity:0} 
    to {top:0; opacity:1}
}

@keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 16px;
    background-color: #ffffff;
    color: #000000;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
    padding: 2px 16px;
    background-color: #ffffff;
    color: white;
}
</style>
<div class="container-fluid">
    
    
    <!-- Second navbar for sign in -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand tit" href="#" style="z-index: 0;"><b>House of music</b></a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right btn-outline btn-circle">
            <li><a class="nor" href="#">Home</a></li>
            <li><a class="nor" href="aboutPage">About</a></li>
            <li><a class="nor" href="#">Contact</a></li>
          	<li><a class="btn btn-default btn-outline btn-circle collapsed nor"  data-toggle="collapse" href="#nav-collapse3" aria-expanded="false" aria-controls="nav-collapse3">Search</a></li>
          	<c:if test="${isAdmin != 'true' }">
            <li><a class="btn btn-default btn-outline btn-circle collapsed nor"  data-toggle="collapse" href="#nav-collapse1" aria-expanded="false" aria-controls="nav-collapse2"> Categories</a></li>
            </c:if>
            <c:if test="${isAdmin == 'true' }">
            <li><a class="btn btn-default btn-outline btn-circle collapsed nor"  data-toggle="collapse" href="#nav-collapse5" aria-expanded="false" aria-controls="nav-collapse2"> Category</a></li>
            <li><a class="btn btn-default btn-outline btn-circle collapsed nor"  data-toggle="collapse" href="#nav-collapse6" aria-expanded="false" aria-controls="nav-collapse2"> Product</a></li>
            <li><a class="btn btn-default btn-outline btn-circle collapsed nor"  data-toggle="collapse" href="#nav-collapse7" aria-expanded="false" aria-controls="nav-collapse2"> Supplier</a></li>
            </c:if>
            <c:if test="${isAdmin != 'true' }"><c:if test="${isUser != 'true' }">
            <li><a class="btn btn-default btn-outline btn-circle collapsed nor"  data-toggle="collapse" href="#nav-collapse2" aria-expanded="false" aria-controls="nav-collapse2">Sign in</a></li>
            <li><a class="btn btn-default btn-outline btn-circle collapsed nor"  id="myBtn">Sign up</a></li>
          	</c:if></c:if>
          	<c:if test="${isUser == 'true' }">
          	<li><a class="btn btn-default btn-outline btn-circle collapsed nor" href="CartPage">Cart</a></li>
          	</c:if>
          	<c:if test="${isUser == 'true'||isAdmin == 'true' }">
          	<li><a class="btn btn-default btn-outline btn-circle collapsed nor" href="logout">Log out</a></li>
          	</c:if>
          	<li></li>
          </ul>
           <div class="collapse nav navbar-nav nav-collapse slide-down" id="nav-collapse3">
            <form class="navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Search" />
              </div>
              <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
            </form>
          </div>
           <ul class="collapse nav navbar-nav nav-collapse" id="nav-collapse1">
            <li><a class="nor" href="#">Headphone with mic</a></li>
            <li><a class="nor" href="#">Boom Headphone</a></li>
            <li><a class="nor" href="#">Bluetooth Headphone</a></li>
          </ul>
          <ul class="collapse nav navbar-nav nav-collapse" id="nav-collapse5">
            <li><a class="nor" href="CategoryPage">Add Category</a></li>
            <li><a class="nor" href="ViewCategoryPage">View Category</a></li>
          </ul>
          <ul class="collapse nav navbar-nav nav-collapse" id="nav-collapse6">
            <li><a class="nor" href="ProductPage">Add Product</a></li>
            <li><a class="nor" href="ViewProductPage">View Product</a></li>
          </ul>
          <ul class="collapse nav navbar-nav nav-collapse" id="nav-collapse7">
            <li><a class="nor" href="SupplierPage">Add Supplier</a></li>
            <li><a class="nor" href="ViewSupplierPage">View Supplier</a></li>
          </ul>
          <!-- The Modal -->
		  <div id="myModal" class="modal">
		  <form action="newUser" method="post" onsubmit="return validation()">
  		  <!-- Modal content -->
  		  <div class="modal-content">
          <div class="modal-header">
          <span class="close">&times;</span>
          <a class="nor" style="font-size: 33px;">Sign Up</a>
          </div>
          <div class="modal-body">
          <div class="form-group">
				<input type="text" name="name" id="name" class="form-control input-lg nor" placeholder="Name">
		  </div>
		  <div class="form-group">
				<input type="number" name="contact" id="contact" class="form-control input-lg" placeholder="Contact No.">
		  </div>
          <div class="form-group">
				<input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address">
		  </div>
		  <div class="form-group">
				<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
		  </div>
		  <div class="form-group">
				<input type="text" name="address" id="address" class="form-control input-lg" placeholder="Address">
		  </div>
		  <div class="form-group">
				<input type="number" name="citycode" id="citycode" class="form-control input-lg" placeholder="City code">
		  </div>
          </div>
          <div class="modal-footer">
           <a class="nor" href="logout"><button class="btn btn-default btn-outline btn-circle collapsed nor">Register</button></a>
          </div>
          </div>
		  </form>
		  </div>
          <div class="collapse nav navbar-nav nav-collapse slide-down" id="nav-collapse2">
            <form class="navbar-form navbar-left form-inline" role="form" action="signIn" method="Post">
              <div class="form-group">
                <label class="sr-only" for="Email">Email</label>
                <input type="email" class="form-control" id="email" placeholder="Email" name="email" autofocus required />
              </div>
              <div class="form-group">
                <label class="sr-only" for="Password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="password" required />
              </div>
              <button type="submit" class="btn btn-success">Sign in</button>
            </form>
          </div>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
</div>

<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

<script src="resources/js/NavbarValidation.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">