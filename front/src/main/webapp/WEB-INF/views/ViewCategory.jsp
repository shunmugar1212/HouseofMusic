<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body style="background-image: url('resources/images/bg.png');">
<table class = "table table-bordered">
   <caption>Category List</caption>
   
  <tr>
      <td>S.NO</td>
       	 <th>ID</th>
         <th>Name</th>
         <th>Description</th>
		 <th class="text-center">Action</th>
      </tr>
  <c:forEach items="${categoryList}" var="category" varStatus="status">
  <tr>
  <td>${status.count}</td>
  <td>${category.categoryId}</td>
   <td>${category.categoryName}</td>
    <td>${category.description}</td>
	<td class="text-center"><a class='btn btn-info btn-xs' href="editCategory?categoryId=${category.categoryId}"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="deleteCategory?categoryId=${category.categoryId}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span>Del</a></td>
    </tr>
  
  </c:forEach>
	
</table>
</body>