<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

 <form action="afterEditProduct" class="container" >
    <div class="">
      <center><h3><b>PRODUCT EDIT SECTION</b></h3></center>
      <label><b>Product Id</b></label><br>
      <input type="text" name="productId" style="width:100%;" readonly="true" value="${product.productId}"><br>
      
      <label><b>Product Name</b></label><br>
      <input type="text" placeholder="Enter Your Product name" name="productName" style="width:100%;" value="${product.productName}"><br>
      
      <label><b>Brand</b></label><br>
      <input type="text" placeholder="Enter Your Brand name" name="brand" style="width:100%;" value="${product.brand}"><br>
      
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
      <input type="text" placeholder="Enter Product Description" name="description" style="width:100%;" value="${product.description}"><br>
      
      <label><b>Colour</b></label><br>
      <input type="text" placeholder="Enter Product Colour" name="colour" style="width:100%;" value="${product.colour}"><br>
      
      <label><b>Stock</b></label><br>
      <input type="text" placeholder="Enter Product Quantity" name="stock" style="width:100%;" value="${product.quantity}"><br>
            
      <label><b>Price</b></label><br>
      <input type="text" placeholder="Enter Product Price" name="price" style="width:100%;" value="${product.price}"><br>
      
      <div class="clearfix">
       <button type="reset" class="cancelbtn">Reset</button>
        <button type="submit" class="signupbtn">Submit</button>
      </div>
    </div>
  </form>

