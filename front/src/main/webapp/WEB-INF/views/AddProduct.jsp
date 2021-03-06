<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/ProductValidation.js"></script>
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
 <form action="newProduct" class="container" enctype="multipart/form-data" method="post" onsubmit="return productValidation()">
    <div class="">
      <center><h3><b>PRODUCT ADD SECTION</b></h3></center>
      <label><b>Product Name</b></label><br>
      <input type="text" placeholder="Enter Your Product name" name="productName" id="productName" style="width:100%;"><br>
      
      <label><b>Brand</b></label><br>
      <input type="text" placeholder="Enter Your Brand name" name="brand" id="brand" style="width:100%;"><br>
      
      <select name="category">
  			<option value="">Select Category</option>
  			<c:forEach items="${categoryList}" var="category"><br><br>
  				<option value="${category.categoryName}">${category.categoryName}</option>
  			</c:forEach>
	   </select>
 <br><br>
	  <select name="supplier">
  			<option value="">Select Supplier</option>
  			<c:forEach items="${supplierList}" var="supplier"><br><br>
  				<option value="${supplier.supplierName}">${supplier.supplierName}</option>
  			</c:forEach>
	  </select>
<br>
      <label><b>Description</b></label><br>
      <input type="text" placeholder="Enter Product Description" name="description" id="description" style="width:100%;"><br>
      
      <label><b>Colour</b></label><br>
      <input type="text" placeholder="Enter Product Colour" name="colour" id="colour" style="width:100%;"><br>
      
      <label><b>Stock</b></label><br>
      <input type="text" placeholder="Enter Product Quantity" name="stock" id="stock" style="width:100%;"><br>
      
      <label><b>Price</b></label><br>
      <input type="text" placeholder="Enter Product Price" name="price" id="price" style="width:100%;"><br>
      
      <label><b>Image</b></label><br>
      <input type="file" placeholder="Insert Your Product Image" name="image" style="width:100%;"><br>
      
      <div class="clearfix">
       <button type="reset" class="cancelbtn">Reset</button>
        <button type="submit" class="signupbtn">Submit</button>
      </div>
    </div>
  </form>
</body>
