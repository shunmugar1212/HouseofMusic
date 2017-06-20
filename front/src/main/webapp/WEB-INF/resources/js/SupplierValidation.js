function validation(){
	var name = document.getElementById('name');
	var contact = document.getElementById('contact');
	var email = document.getElementById('email');
	var password = document.getElementById('password');
	var confirm = document.getElementById('addrerss');
	var citycode = document.getElementById('citycode');
	
	// Check each input in the order that it appears in the form!
	if (notEmpty(name, "Your Name Should not be empty")) {
			if (isAlphabet(name, "Please enter only letters for Your Name")) {

	if (notEmpty(contact, "Contact Number Should not be empty")) {
			if (isNumeric(contact,"Please enter only number for Contact Number")) {
						
	if (notEmpty(email,"EmailId Should not be empty")) {
			if (emailValidator(email,"EmailId Should be in format of abc@xyz.com ")) {
				if (notEmpty(email,"EmailId Should not be empty")) {
					
	if (notEmpty(password, "password Should not be empty")) {
			if (isAlphanumeric(password,"Numbers and Letters Only for Passwords")) {
	
	if (notEmpty(address, "Address Should not be empty")) {
		if (isAlphanumeric(address, "Please enter only letters and number for Address")) {

	if (notEmpty(citycode, "Citycode Should not be empty")) {
		if (isNumeric(citycode,"Numbers Only for Citycode")) {
												
									return true;
											}
										}
									}
								}
							}}}
						}
					}
				}
			}
		}
	}
		return false;
	}
	function notEmpty(elem, helperMsg) {
		if (elem.value.length == 0) {
			alert(helperMsg);
			elem.focus(); // set the focus to this input
			return false;
		}
		return true;
	}
	function isNumeric(elem, helperMsg) {
		var numericExpression = /^[0-9]+$/;
		if (elem.value.match(numericExpression)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function isAlphanumeric(elem, helperMsg) {
		var alphaExp = /^[0-9a-zA-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function emailValidator(elem, helperMsg) {
		var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		if (elem.value.match(emailExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function isAlphabet(elem, helperMsg) {
		var alphaExp = /^[a-z A-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}