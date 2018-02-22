/**
 * 
 */


function validate() {
	var result = true;
	var login = document.getElementsByName("login")[0].value;
	var password = document.getElementsByName("password")[0].value;
	
	
	if (login == '' || login.indexOf("(") >= 0 || login.indexOf(")") >= 0 || login.indexOf("\\") >= 0 || login.indexOf("/") >= 0 ) {
		result = false;	
	}

	if (password == '' || password.indexOf("(") >= 0 || password.indexOf(")") >= 0 || password.indexOf("\\") >= 0 || password.indexOf("/") >= 0 ) {
		result = false;	
	}
	
	
	if (!result) {
		alert("Wrong Login or Email")
	}
	return result;
}