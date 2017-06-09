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



 <form action="newCategory" method="post" class=" container" >
    <div class="">
      <center><h3><b>CATEGORY ADD SECTION</b></h3></center>
      <label><b>Category Name</b></label><br>
      <input type="text" placeholder="Enter Your Category name" name="categoryName" style="width:100%;" required><br>
      
      <label><b>Description</b></label><br>
      <input type="text" placeholder="Enter Description" name="description" style="width:100%;" required><br>
      
      <div class="clearfix">
        <button type="reset" class="cancelbtn">Reset</button>
        <button type="submit" class="signupbtn">Submit</button>
      </div>
    </div>
  </form>
