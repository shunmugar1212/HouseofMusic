<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
//Reusing bootstrap 3 panel CSS
.panel {
    background-color: #FFFFFF;
    border: 1px solid rgba(0, 0, 0, 0);
    border-radius: 4px 4px 4px 4px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
    margin-bottom: 20px;
}   

.panel-primary {
    border-color: #428BCA;
}   

.panel-primary > .panel-heading {
    background-color: #428BCA;
    border-color: #428BCA;
    color: #FFFFFF;
}   

.panel-heading {
    border-bottom: 1px solid rgba(0, 0, 0, 0);
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
    padding: 10px 15px;
}   

.panel-title {
    font-size: 16px;
    margin-bottom: 0;
    margin-top: 0;
}   

.panel-body:before, .panel-body:after {
    content: " ";
    display: table;
}   

.panel-body:before, .panel-body:after {
    content: " ";
    display: table;
}   

.panel-body:after {
    clear: both;
}   

.panel-body {
    padding: 15px;
}   

.panel-footer {
    background-color: #F5F5F5;
    border-bottom-left-radius: 3px;
    border-bottom-right-radius: 3px;
    border-top: 1px solid #DDDDDD;
    padding: 10px 15px;
}

//CSS from v3 snipp
.user-row {
    margin-bottom: 14px;
}

.user-row:last-child {
    margin-bottom: 0;
}

.dropdown-user {
    margin: 13px 0;
    padding: 5px;
    height: 100%;
}

.dropdown-user:hover {
    cursor: pointer;
}

.table-user-information > tbody > tr {
    border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information > tbody > tr:first-child {
    border-top: 0;
}


.table-user-information > tbody > tr > td {
    border-top: 0;
}
</style>

<body style="background-image: url('resources/images/bg.png');">
<br><br>
<div class="container">
 <div class="well span8 offset2">
 
 		        <div class="row-fluid user-row">
            <div class="span10">
                <strong>COD</strong><br>
                <span class="text-muted">Cash on Delivery</span>
            </div>
            <div class="span1 dropdown-user" data-for=".alexanderMahrt">
                <i class="icon-chevron-down glyphicon glyphicon-chevron-down text-muted"></i>
            </div>
        </div>
        <div class="row-fluid user-infos alexanderMahrt">
            <div class="span10 offset1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Payment Information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row-fluid">
                            <div class="form-group">
                                    <label class="control-label" for="password_confirm">Are you accecpt to pay the amount on delivery?</label>
                            </div>
                           <div class="form-group">
                                    <a href="Thankyou"><button class="btn btn-success">Confirm</button></a>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row-fluid user-row">
            <div class="span10">
                <strong>Payment by Card</strong><br>
                <span class="text-muted">Visa / Master / Mastor</span>
            </div>
            <div class="span1 dropdown-user" data-for=".cyruxx">
                <i class="icon-chevron-down glyphicon glyphicon-chevron-down text-muted"></i>
            </div>
        </div>
        <div class="row-fluid user-infos cyruxx">
            <div class="span10 offset1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Card Information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row-fluid">
                            <div class="form-group">
                                <label class="control-label" for="username">Card Holder's Name</label>
                            <div class="controls">
                                <input type="text" id="username" name="username" placeholder="Name" class="form-control">
                            </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="card_number">Card Number</label>
                            <div class="controls">
                                <input type="text" id="card_number" name="card_number" placeholder="XXXX-XXXX-XXXX-XXXX" class="form-control">
                            </div>
                            </div>
                            <div class="form-group">
                            <label class="control-label" for="expiry_month">Card Expiry Date</label>
                                <div class="">
                                 <input type="text" id="card_number" name="card_number" placeholder="MM/YYYY"
                                       class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label class="control-label" for="password_confirm">Card CVV</label>


                                    <input type="password" id="password_confirm"
                                           name="password_confirm" placeholder="cvv"
                                           class="form-control">
                                </div>
                                <div class="form-group">
                                    <a href="Thankyou"><button class="btn btn-success">Pay Now</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</div>
</body>

<script>
$(document).ready(function() {
    var panels = $('.user-infos');
    var panelsButton = $('.dropdown-user');
    panels.hide();

    //Click dropdown
    panelsButton.click(function() {
        //get data-for attribute
        var dataFor = $(this).attr('data-for');
        var idFor = $(dataFor);

        //current button
        var currentButton = $(this);
        idFor.slideToggle(400, function() {
            //Completed slidetoggle
            if(idFor.is(':visible'))
            {
                currentButton.html('<i class="icon-chevron-up glyphicon glyphicon-chevron-up text-muted"></i>');
            }
            else
            {
                currentButton.html('<i class="icon-chevron-down glyphicon glyphicon-chevron-down text-muted"></i>');
            }
        })
    });
});
</script>