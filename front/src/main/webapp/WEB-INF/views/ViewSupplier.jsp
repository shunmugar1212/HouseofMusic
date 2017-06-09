<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class = "table table-bordered">
   <caption>Supplier List</caption>
   
    <tr>
      <td>S.No</td>
       	 <th>ID</th>
         <th>Name</th>
         <th>Contact</th>
         <th>Description</th>
         <th>Email</th>
         <th>Address</th>
         <th>City code</th>
		 <th class="text-center">Action</th>
      </tr>
  <c:forEach items="${supplierList}" var="supplier" varStatus="status">
  <tr>
  <td>${status.count}</td>
  <td>${supplier.supplierId}</td>
   <td>${supplier.supplierName}</td>
    <td>${supplier.contact}</td>
    <td>${supplier.description}</td>
    <td>${supplier.mail}</td>
    <td>${supplier.address}</td>
    <td>${supplier.citycode}</td>
    <td class="text-center"><a class='btn btn-info btn-xs' href="editSupplier?supplierId=${supplier.supplierId}"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="deleteSupplier?supplierId=${supplier.supplierId}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span>Del</a></td>
  </tr>
  
   </c:forEach>
</table>