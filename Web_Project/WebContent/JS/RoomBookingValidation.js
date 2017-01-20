function validateRoomBookingForm()
{
	
	var result = true;
	var name = document.getElementById("name").value;
	if (name == "") {
		result = false;
		alert("Please Enter the Customert Name..!!\n");
	}

	
	var email = document.getElementById("email").value;
	if (email == "") {
		result = false;
      alert("Please enter Email Id..!!\n");
		

	}
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
	if (contactNo.length != 10) {
		result = false;
		alert("Contact Number should have 10 digits..!!\n");
		
	}
	
	if (isNaN(contactNo)) {
		result = false;
		alert("Please enter contact Number in digits..!!\n");
	}
  	

	return result;

}