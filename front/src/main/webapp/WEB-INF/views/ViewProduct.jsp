<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class = "table table-bordered">
   <caption>Product List</caption>
   
  <tr>
      <td>S.NO</td>
       	 <th>ID</th>
         <th>Name</th>
         <th>Brand</th>
         <th>Category</th>
         <th>Supplier</th>
         <th>Description</th>
         <th>Colour</th>
         <th>Stock</th>
         <th>Price</th>
         <th class="text-center">Action</th>
</tr>
  <c:forEach items="${productList}" var="product" varStatus="status">
  <tr>
  <td>${status.count}</td>
  <td>${product.productId}</td>
   <td>${product.productName}</td>
   <td>${product.brand}</td>
   <td>${product.category}</td>
   <td>${product.supplier}</td>
    <td>${product.description}</td>
    <td>${product.colour}</td>
    <td>${product.stock}</td>
     <td>${product.price}</td>
	 <td class="text-center"><a class='btn btn-info btn-xs' href="editProduct?productId=${product.productId}"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="deleteProduct?productId=${product.productId}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span>Del</a></td>
</tr>
  
   </c:forEach>
	
</table>