function validateRegistrationForm() {
	

	var result = true;
	var name = document.getElementById("name").value;
	if (name == "") {
		result = false;
	alert("Please Enter the Customert Name..!!\n");

	}
	pattern = /^[A-Z a-z]{0,50}$/;
	if (!pattern.test(name)) {
		result = false;
		alert("Name should have only characters..!!\n");
	}
	var address = document.getElementById("address").value;
	if (address == "") {
		result = false;
		alert("Please enter address..!!\n");
	}
	var email = document.getElementById("email").value;
	if (email == "") {
		result = false;
		alert("Please enter Email Id..!!\n");
		document.getElementById("email").value = "";
		document.getElementById("email").focus();

	}
	var email = document.getElementById("email").value;
	var pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if (!pattern.test(email)) {
		result = false;
		alert("Please Enter a valid EmailId containing @ and ...!!\n");
	}
	var contactNo = document.getElementById("contactNo").value;
	if (contactNo == "") {
		result = false;
	alert("Please enter Contact Number ..!!..!!\n");
	}
	if (isNaN(contactNo)) {
		result = false;
		alert("Please enter contact Number in digits..!!\n");
	}
	if (contactNo.length != 10) {
		result = false;
	alert("Contact Number should have 10 digits..!!\n");
	}
	var userId = document.getElementById("userId").value;
	if (userId == "") {
		result = false;
		alert("Please enter a valid userId ..!!\n");
	}
	var password = document.getElementById("password").value;
	if (password == "") {
		result = false;
		alert("Please enter a password ..!!\n");
	}
	var pattern = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
	if (!pattern.test(password)) {
		result = false;
		alert("Please enter a valid password containing uppercase lowercase lettersand digits and special characters..!!\n");
	}
	var confirmPassword = document.getElementById("confirmPassword").value;
	if (confirmPassword == "") {
		result = false;
	alert("Please confrim password ..!!\n");
	}
	
	return result;

}