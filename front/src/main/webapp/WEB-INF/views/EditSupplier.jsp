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

 <form action="afterEditSupplier" class="container" >
    <div class="">
      <center><h3><b>SUPPLIER EDIT SECTION</b></h3></center>
       <label><b>Supplier Id</b></label><br>
      <input type="text" name="supplierId" style="width:100%;" readonly="true" value="${supplier.supplierId}"><br>
      
      <label><b>Supplier Name</b></label><br>
      <input type="text" placeholder="Enter Supplier name" name="supplierName" style="width:100%;" value="${supplier.supplierName}"><br>
      
      <label><b>Contact No.</b></label><br>
      <input type="text" placeholder="Enter Supplier mobile no." name="contact" style="width:100%;" value="${supplier.contact}"><br>
      
      <label><b>Description</b></label><br>
      <input type="text" placeholder="Enter Supplier Description" name="description" style="width:100%;" value="${supplier.description}"><br>
      
      <label><b>Email</b></label><br>
      <input type="text" placeholder="Enter Supplier Email" name="mail" style="width:100%;" value="${supplier.mail}"><br>
      
      <label><b>Address</b></label><br>
      <input type="text" placeholder="Enter Supplier Address" name="address" style="width:100%;" value="${supplier.address}"><br>
      
      <label><b>Citycode</b></label><br>
      <input type="text" placeholder="Enter Citycode" name="citycode" style="width:100%;" value="${supplier.citycode}"><br>
      
      <div class="clearfix">
        <button type="reset" class="cancelbtn">Reset</button>
        <button type="submit" class="signupbtn">Submit</button>
      </div>
    </div>
  </form>