function validateof()
{
    
    
    var x = document.getElementById("roomno").value;
    if (x == null || x == "" || isNaN(x)) {
    alert("Please enter valid room number\n");
    return false;
    } 

    // category validation
    var x1 = document.addRoom.category;
    if (x1.selectedIndex == 0) {

		alert("Please select a category \n");
		return false;
    }
    var x3 = document.getElementsByName("speciality");
    var y=0;
    for ( var i = 0; i < x3.length; i++) {
		if (x3[i].checked == true) {
			y=1;
			break;
		} 
    }
     if(y==0){

			alert("Please select a speciality");
			return false;

		}
    
    // tariff validation
    var x4 = document.getElementById("tariff").value;
    if (x4 == ""||x4==null||isNaN(x4)) {
		alert("please enter tariff");
		return false;
    }
    
    var image=document.getElementById("photo").value;
    
    if(image==""||image==null){
    	
    	alert("Please select an image");
    	return false;
    }
    
    var x5 = document.getElementsByName("adstatus");
    var z=0;
    
    for ( var i = 0; i < x5.length; i++) {
		if (x5[i].checked == true) {
		 z=1;
		 var y=i;
			break;
		}
    }

		if(z==0) {
			alert(" Please select a a/d status \n ");
			return false;
		}
    
		 var re = /^(\d{1,2})\/(\d{2})\/(\d{4})$/;
		 if(x5[y].value=="Deactivated")
			 {   if(document.addRoom.startdate.value != "") {
		          if(regs1 = document.addRoom.startdate.value.match(re)) {
		              // day value between 1 and 31
		              if(regs1[1] < 1 || regs1[1] > 31) {
		                alert("Invalid value for day: " + regs[1]);
		            //    form.startdate.focus();
		                return false;
		              }
		              // month value between 1 and 12
		              if(regs1[2] < 1 || regs1[2] > 12) {
		                alert("Invalid value for month: " + regs[2]);
		              //  form.startdate.focus();
		                return false;
		              }
		              // year value between 1902 and 2017
		              if(regs1[3] < 1900 || regs1[3] > 2050) {
		                alert("Invalid value for year: " + regs1[3] + " - must be between 1902 and " + 2050);
		            //    form.startdate.focus();
		                return false;
		              }
		            } 
		            else {
		              alert("Invalid date format: " + document.DateForm.date.value);
		         //     form.startdate.focus();
		              return false;
		            }
		            }
		            else{
		                alert("Please Enter from date in the field");
		                return false;
		            }
		         

		          if(document.addRoom.enddate.value != "") {
		            if(regs2 = document.addRoom.enddate.value.match(re)) {
		              // day value between 1 and 31
		              if(regs2[1] < 1 || regs2[1] > 31) {
		                alert("Invalid value for day: " + regs2[1]);
		            //    form.startdate.focus();
		                return false;
		              }
		              // month value between 1 and 12
		              if(regs2[2] < 1 || regs2[2] > 12) {
		                alert("Invalid value for month: " + regs2[2]);
		              //  form.startdate.focus();
		                return false;
		              }
		              // year value between 1902 and 2014
		              if(regs2[3] < 1900 || regs2[3] > 2050) {
		                alert("Invalid value for year: " + regs2[3] + " - must be between 1902 and " + 2050);
		            //    form.startdate.focus();
		                return false;
		              }
		            } 
		            else {
		              alert("Invalid date format: " + document.DateForm.date.value);
		         //     form.startdate.focus();
		              return false;
		            }
		            }
		            else{
		                alert('Please Enter to date in the field');
		                return false;
		            }
		          if(regs2[3]<regs1[3])
		          	{
		                alert('Check out date cannot be less than check in date');
		                return false;
		          	}
		          else if(regs2[3]==regs1[3])
		          	{
		          	if(regs2[2]<regs1[2])
		          		{
		          		alert('Check out date cannot be less than check in date');
		          		return false;
		          		}
		          	else if(regs2[2]==regs1[2])
		          		{
		          		if(regs2[1]<regs1[1])
		          			{
		          			alert('Check out date cannot be less than check in date');
		          			return false;
		          			}
		          		}
		          	}
		          }
         
        
        
         
         alert("All details are validated  ");
        return true;

}










function updateroomvalid() {
       var t=0;
        
        var x = document.getElementsByName("room");
        for ( var i = 0; i < x.length; i++) {
			if (x[i].checked == true)
				{
				t=1;
			
				}
				
        }
        if(t==0)
			{
			alert("please select a room");
			return false;
			}
        return true;
    }




function updateroomdetailsvalidate()
{
    
    
    // tariff validation
    var x4 = document.getElementById("tariff").value;
    if (x4 == ""||x4==null||isNaN(x4)) {
    alert(" Please enter valid tariff");
    return false;
    }
     // category validation

    var x5 = document.updatedetails.category;
    if (x5.selectedIndex == 0) {

		alert("Please select a category ");
		return false;
    }
    
    
    
    var x2=document.getElementById("speciality").value;
    if(x2==null||x2=="")
        {
        alert("Please enter speciality");
        return false;
        }
    
    return true;

}



function activateroomvalidate() {
   var t=0;
    
    var x = document.getElementsByName("roomstate");
    for ( var i = 0; i < x.length; i++) {
		if (x[i].checked == true)
			{
			t=1;
			break;
			}
		
    }
if(t==0)
    {
    alert("select a room");
    return false;
    
    }
return true;
}





function deactivateroomvalid() {
    
    var t=0;
    var x = document.getElementsByName("roomstates");
    for ( var i = 0; i < x.length; i++) {
		if (x[i].checked == true)
		{
			t=1;
			
		}
		}
    if(t==0)
		{
		alert("please select a room");
		return false;
		}
    return true;
}




function deactivateroomdetailsvalidate()
{
    
     var re = /^(\d{1,2})\/(\d{2})\/(\d{4})$/;
     
     if(document.deactivatedetails.startdate.value != "") {
         if(regs1 = document.deactivatedetails.startdate.value.match(re)) {
             // day value between 1 and 31
             if(regs1[1] < 1 || regs1[1] > 31) {
               alert("Invalid value for day: " + regs[1]);
           //    form.startdate.focus();
               return false;
             }
             // month value between 1 and 12
             if(regs1[2] < 1 || regs1[2] > 12) {
               alert("Invalid value for month: " + regs[2]);
             //  form.startdate.focus();
               return false;
             }
             // year value between 1902 and 2014
             if(regs1[3] < 1900 || regs1[3] > 2050) {
               alert("Invalid value for year: " + regs1[3] + " - must be between 1902 and " + 2050);
           //    form.startdate.focus();
               return false;
             }
           } 
           else {
             alert("Invalid date format: " + document.DateForm.date.value);
        //     form.startdate.focus();
             return false;
           }
           }
           else{
               alert("Please Enter from date in the field");
               return false;
           }
        

         if(document.deactivatedetails.enddate.value != "") {
           if(regs2 = document.deactivatedetails.enddate.value.match(re)) {
             // day value between 1 and 31
             if(regs2[1] < 1 || regs2[1] > 31) {
               alert("Invalid value for day: " + regs2[1]);
           //    form.startdate.focus();
               return false;
             }
             // month value between 1 and 12
             if(regs2[2] < 1 || regs2[2] > 12) {
               alert("Invalid value for month: " + regs2[2]);
             //  form.startdate.focus();
               return false;
             }
             // year value between 1902 and 2014
             if(regs2[3] < 1900 || regs2[3] > 2050) {
               alert("Invalid value for year: " + regs2[3] + " - must be between 1902 and " + 2050);
           //    form.startdate.focus();
               return false;
             }
           } 
           else {
             alert("Invalid date format: " + document.DateForm.date.value);
        //     form.startdate.focus();
             return false;
           }
           }
           else{
               alert('Please Enter to date in the field');
               return false;
           }
         if(regs2[3]<regs1[3])
         	{
               alert('Check out date cannot be less than check in date');
               return false;
         	}
         else if(regs2[3]==regs1[3])
         	{
         	if(regs2[2]<regs1[2])
         		{
         		alert('Check out date cannot be less than check in date');
         		return false;
         		}
         	else if(regs2[2]==regs1[2])
         		{
         		if(regs2[1]<regs1[1])
         			{
         			alert('Check out date cannot be less than check in date');
         			return false;
         			}
         		}
     
         	}         	
      return true;




}

