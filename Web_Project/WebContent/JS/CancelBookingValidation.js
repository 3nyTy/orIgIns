function validateCancelBookingForm()
{
	
	var result = true;
	var bookingId = document.getElementById("bookingId").value;
	if (bookingId == "") {
		result = false;
		alert("Please Enter the Booking Id..!!\n");
	}
	
	
	return result;
}