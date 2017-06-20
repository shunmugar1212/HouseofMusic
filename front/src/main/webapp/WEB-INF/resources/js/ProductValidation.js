function productValidation(){
	var name = document.getElementById('productName');
	var brand = document.getElementById('brand');
	var description = document.getElementById('description');
	var colour = document.getElementById('colour');
	var stock = document.getElementById('stock');
	var price = document.getElementById('price');
	
	// Check each input in the order that it appears in the form!
	if (notEmpty(name, "Product Name Should not be empty")) {
			if (isAlphanumeric(name, "Please enter only letters and numbers for Product Name")) {

	if (notEmpty(brand, "Brand Name Should not be empty")) {
			if (isAlphabet(brand, "Please enter only letters for Brand Name")) {
						
	if (notEmpty(description, "description should not be empty")) {
			if (isAlphabet(description, "Please enter only letters for description")) {
	
	if (notEmpty(colour, "colour Should not be empty")) {
		if (isAlphanumeric(colour, "Please enter only letters and number for colour")) {

	if (notEmpty(stock, "stock Should not be empty")) {
		if (isNumeric(stock,"Numbers Only for stock")) {

	if (notEmpty(price, "price Should not be empty")) {
		if (isNumeric(price,"Numbers Only for price")) {
									return true;
											}}
		}
	}
		}
	}
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