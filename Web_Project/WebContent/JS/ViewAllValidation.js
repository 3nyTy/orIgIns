function validateViewAll()
{
	
        // regular expression to match required date format
        re = /^(\d{1,2})\/(\d{2})\/(\d{4})$/;

        if(document.all.fdate.value != "") {
          if(regs1 = document.all.fdate.value.match(re)) {
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
       

        if(document.all.tdate.value != "") {
          if(regs2 = document.all.tdate.value.match(re)) {
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
              alert("Please Enter to date in the field");
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
    
   // return false;
}