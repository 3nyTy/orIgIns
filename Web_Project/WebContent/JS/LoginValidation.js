function validateLoginForm()
{
	var str="";
	var result=true;
	var userId = document.getElementById("userId").value;
	if (userId == "") {
		result = false;
		str = str + "Please enter a valid userId ..!!\n";
	}
	var password = document.getElementById("password").value;
	if (password == "") {
		result = false;
		str = str + "Please enter a password ..!!\n";
	}
	if(result==false)
		alert(str);
	return result;
}