<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn,.signupbtn {float:left;width:50%}


</style>

<body style="background-image: url('resources/images/bg.png');">
 <form action="newSupplier" class="container" >
    <div class="">
      <center><h3><b>SUPPLIER ADD SECTION</b></h3></center>
      <label><b>Supplier Name</b></label><br>
      <input type="text" placeholder="Enter Supplier name" name="supplierName" style="width:100%;"><br>
      
      <label><b>Contact No.</b></label><br>
      <input type="text" placeholder="Enter Supplier mobile no." name="contact" style="width:100%;"><br>
      
      <label><b>Description</b></label><br>
      <input type="text" placeholder="Enter Supplier Description" name="description" style="width:100%;"><br>
      
      <label><b>Email</b></label><br>
      <input type="text" placeholder="Enter Supplier Email" name="mail" style="width:100%;"><br>
      
      <label><b>Address</b></label><br>
      <input type="text" placeholder="Enter Supplier Address" name="address" style="width:100%;"><br>
      
      <label><b>Citycode</b></label><br>
      <input type="text" placeholder="Enter Citycode" name="citycode" style="width:100%;"><br>
      
      <div class="clearfix">
        <button type="reset" class="cancelbtn">Reset</button>
        <button type="submit" class="signupbtn">Submit</button>
      </div>
    </div>
  </form>
  </body>