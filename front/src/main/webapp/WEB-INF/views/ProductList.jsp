<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
*{
  box-sizing:border-box;
  -moz-box-sizing:border-box;
}
body {
	background: #fffff;
  font-family: Baskerville, Times,   serif;
  min-height: 1000px;
}
#columns {
	max-width: 900px;
	margin: 50px auto;
}

figure {
	background: #fefefe;
	border: 2px solid #fcfcfc;
  border-radius:3px;
	box-shadow: 0 1px 2px rgba(34, 25, 25, 0.4);
	margin: 0 2px 15px;
	padding: 15px;
	padding-bottom: 10px;
	transition: all .5s ease-in-out;
  display: inline-block;
  width:30%;
  float:left;
  margin-right:2%;
}
#columns:hover figure:not(:hover) {
	opacity: 0.4;
}
figure img {
 	width: 100%; height: auto;
	border-bottom: 1px solid #ccc;
	padding-bottom: 15px;
	margin-bottom: 5px;
}

figure figcaption {
  font-size: 18px;
  text-align:center;
	color: #808080;
  line-height: 1.5;
}
figure span{
  font-size:14px;
  color:#839d57;
  display:block;
  text-align:center;
}
figure span.location{
  margin-top:8px;
  color:#808080;
}
a.button{
  display:block;
  text-align:center;
  text-decoration:none;
  width:80%;
  margin:15px auto;
  font-family: Avenir , arial, san-serif !important;
  font-weight:bold;
  height: 35px;
  line-height: 35px;
  color: #fff;
  padding: 0 20px;
  background: #00c6d2;
  transition: All 500ms ease-out;
  -webkit-transition: All 500ms ease-out;
  -moz-transition: All 500ms ease-out;
  -o-transition: All 500ms ease-out;
  -webkit-box-shadow: inset 0 0 1px rgba(0,0,0,.29), inset 0 0 13px rgba(0,0,0,.1);
  -moz-box-shadow: inset 0 0 1px rgba(0,0,0,.29), inset 0 0 13px rgba(0,0,0,.1);
  box-shadow: inset 0 0 1px rgba(0,0,0,.29), inset 0 0 13px rgba(0,0,0,.1);
}
a.button:hover{
  border: none;
  background-color: #b0c778;
  -webkit-box-shadow: inset 0 0 1px #000, inset 0 0 13px rgba(0,0,0,.2);
  -moz-box-shadow: inset 0 0 1px #000, inset 0 0 13px rgba(0,0,0,.2);
  box-shadow: inset 0 0 1px #000, inset 0 0 13px rgba(0,0,0,.2);
}
@media screen and (max-width:750px){
  figure{
    width:48%;
    margin-right:1%;
  }
}
@media screen and (max-width:500px){
  figure{
    width:90%;
    margin:5px auto;
    display:block;
  }
}
</style>
<body style="background-image: url('resources/images/bg.png');">
<div id="columns">
<c:forEach items="${ProductList}" var="product">
  <figure>
  <img src="resources/images/product/${product.productId}.jpg">
	<figcaption>${product.productName}</figcaption>
    <span class="businessName">${product.brand}</span>
    <span class="location">Rs.${product.price}</span>
    <c:if test="${isUser == 'true' }">
    <a class="button" href="ProductDesPage?productId=${product.productId}">Read Profile</a>
	</c:if>
	<c:if test="${isUser != 'true' }">
    <a class="button" href="#" onclick="alert('Hello &#9786;\nFirst you need to sign in!')">Read Profile</a>
	</c:if>
	</figure>
  </c:forEach>
</div>
</body>