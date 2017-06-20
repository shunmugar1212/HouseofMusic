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
<div class="col-lg-9"></div>
<div class="col-lg-2">
<a href="NewAddress" class="btn btn-lg btn-block btn-info">Add Address</a>
</div>
</div>
<c:forEach items="${shippingList}" var="shipping" varStatus="status">  
<div class="container">
            <div class="col-sm-12">
                <div class="bs-calltoaction bs-calltoaction-info">
                    <div class="row">
                        <div class="col-md-9 cta-contents">
                            <h1 class="cta-title">Address Info</h1>
                            <div class="cta-desc">
                                <p>Name:${shipping.name}</p>
                                <p>Contact No.:${shipping.contact}</p>
                                <p>Address:${shipping.address}</p>
                                <p>City code:${shipping.citycode}</p>
                            </div>
                        </div>
                        <div class="col-md-3 cta-button">
                            <a href="Payment?Id=${shipping.id}" class="btn btn-lg btn-block btn-success">Next</a>
                            <a href="deleteShipping?Id=${shipping.id}" class="btn btn-lg btn-block btn-danger">Delete</a>
                        </div>
                     </div>
                </div>
            </div>
        </div>
</c:forEach>
</body>