<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.bs-calltoaction{
    position: relative;
    width:auto;
    padding: 15px 25px;
    border: 1px solid black;
    margin-top: 10px;
    margin-bottom: 10px;
    border-radius: 5px;
}

    .bs-calltoaction > .row{
        display:table;
        width: calc(100% + 30px);
    }
     
        .bs-calltoaction > .row > [class^="col-"],
        .bs-calltoaction > .row > [class*=" col-"]{
            float:none;
            display:table-cell;
            vertical-align:middle;
        }

            .cta-contents{
                padding-top: 10px;
                padding-bottom: 10px;
            }

                .cta-title{
                    margin: 0 auto 15px;
                    padding: 0;
                }

                .cta-desc{
                    padding: 0;
                }

                .cta-desc p:last-child{
                    margin-bottom: 0;
                }

            .cta-button{
                padding-top: 10px;
                padding-bottom: 10px;
            }

@media (max-width: 991px){
    .bs-calltoaction > .row{
        display:block;
        width: auto;
    }

        .bs-calltoaction > .row > [class^="col-"],
        .bs-calltoaction > .row > [class*=" col-"]{
            float:none;
            display:block;
            vertical-align:middle;
            position: relative;
        }

        .cta-contents{
            text-align: center;
        }
}
.bs-calltoaction.bs-calltoaction-info{
    color: #fff;
    background-color: #5bc0de;
    border-color: #46b8da;
}

.bs-calltoaction.bs-calltoaction-info .cta-button .btn{
    border-color:#fff;
}
</style>

<body style="background-image: url('resources/images/bg.png');">
<div class="col-lg-12">
<div class="col-lg-7"></div>
<div class="col-lg-2">
<p class="btn btn-lg btn-block btn-info">Grand Tot:Rs.${GrandTotal}</p>
</div>
<div class="col-lg-2">
<c:if test="${isCartEmpty=='true'}">
No Items
</c:if>
<c:if test="${isCartEmpty=='false'}">
<a href="Address" class="btn btn-lg btn-block btn-success">Proceed</a>
</c:if>
</div>
</div>
<c:forEach items="${mycartList}" var="mycart" varStatus="status">
<div class="container">
            <div class="col-sm-12">
                <div class="bs-calltoaction bs-calltoaction" style="background-color: white;">
                    <div class="row">
                         <div class="col-md-3 cta-contents">
                           <img class="img-responsive" src="resources/images/product/${mycart.productId}.jpg"></img>
                        </div>
                        <div class="col-md-6 cta-contents">
                            <h1 class="cta-title">${mycart.productName}</h1>
                            <div class="cta-desc">
                                <p><b>Status:</b>${mycart.status}</p>
                                <p><b>Date of Order:</b>${mycart.date}</p>
                                <p><b>Delivery In:</b>${mycart.days}days</p>
                                <p><b>Price:</b>Rs.${mycart.price}</p>
                                <p><b>Quantity:</b>${mycart.quantity}</p>
                                <p><b>Total Amount:</b>Rs.${mycart.total}</p>
                                <p></p>
                            </div>
                        </div>
                        <div class="col-md-3 cta-button">
                            <a href="deleteMycart?cartid=${mycart.id}" class="btn btn-lg btn-block btn-danger"><span class="glyphicon glyphicon-remove"></span>Delete</a>
                        </div>
                     </div>
                </div>
            </div>
        </div>
</c:forEach><br>
<div class="container">
            <div class="col-sm-12">
            <a href="http://localhost:8080/front/afterlogin" class="btn btn-lg btn-block btn-info">Continue Shopping</a>
            </div>
            </div>
            <br>
</body>