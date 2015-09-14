

/*

   Get the content from the form "detailform" and display it the table
*/
    var acfarefiles=new Array();
    var nonacfarefiles=new Array();
    var	count=0;
    var farechart = {
  
      
        /*
            Appends the options to the dropdown list
        */
        
       optionAppend : function (listId,value) {
           
            $('#'+listId).append('<option>'+value+'</option>');
           
           
        },   
        
        /*
            Remove the selected option from the dropdown list
        
        */
        
       optionCheck : function (listId) {
         
            var selectop=document.getElementById(listId);   
            selectop.remove(selectop.selectedIndex);
                 
        }, 
        
        /*
            Reset the particular form
        */
        
        
       formreset : function (formId) {
        
            document.forms[formId].reset();
              
       },

        
        /*
        
            Disable the options which  are not selected from the dropdown list
        
        */
        
        
       optionDisable : function (selectId) {
        
            var op=document.getElementById(selectId).getElementsByTagName("option");
            var selectopt=document.getElementById(selectId);
            for(var i=0 ; i<op.length; i++)
            {
              if(op[i].value.toLowerCase() == selectopt.value.toLowerCase())  
              {
                continue;    
              }
              else
              {
                op[i].disabled=true;
              }    
                
            }
         },
        
        /*
        
            Enable the options in the dropdown list
        
        */
        
        
        
        optionEnable : function (selectId) {
            
            var op=document.getElementById(selectId).getElementsByTagName("option");
            var selectopt=document.getElementById(selectId);
            for(var i=0 ; i<op.length; i++)
            {
                op[i].disabled=false;
            }    
                        
        },
        
        
        /*
            Add Rows to the table
        
        */
        
        addRows : function (tableId,selectId,fileId1,fileId2) {
        
            //  var table = $('#'+tableId);    
           var table = document.getElementById(tableId);
           var rowCount = table.rows.length;
           var row = table.insertRow(rowCount);
           var cell1 = row.insertCell(0);
        
           var element1 = document.createElement("input");
           element1.type = "checkbox";
           element1.name="chkbox[]";
           cell1.appendChild(element1);
        
           var cell2 = row.insertCell(1);
           cell2.innerHTML=$('#'+selectId).val();
        
           var cell3 = row.insertCell(2);
           cell3.innerHTML =$('#'+fileId1).val(); 
        
           var cell4 = row.insertCell(3);
           //cell4.append($('#nonacfare').val());
           cell4.innerHTML =$('#'+fileId2).val(); 
              
       },
        
        /*
           Delete All Rows from the table
        */
        
        
     clearAllRows : function (tableId) {
        
         try
            {
              var table = document.getElementById(tableId);
              var rowCount = table.rows.length;
              rowCount--;
              var rname,row;    
              for(var i=rowCount; i>0; i--) {
              row=table.rows[i];
              rname=row.cells[1].innerHTML;
              farechart.optionAppend("routename",rname);      
              table.deleteRow(i);
            }
            
            }catch(e) {
                alert(e);
            } 
            
    },
          
    /*
        Delete the Single row from the table
        
    */    
        
        
    clearSingleRow : function (tableId) {
        
             try {
               var table = document.getElementById(tableId);
               var rowCount = table.rows.length;
               for(var i=0; i<rowCount; i++) 
               {
                  var row = table.rows[i];
                  var rname=row.cells[1].innerHTML;
                  var chkbox = row.cells[0].childNodes[0];
                  if(null != chkbox && true == chkbox.checked)
                  {
                     farechart.optionAppend("routename",rname);
                     table.deleteRow(i);
                     rowCount--;
                     i--;
                   }
                  }
                
            }catch(e) {
                alert(e);
            }   
    }
        
        
        
        
    };

/*
    Adding Rows to the table
    
*/
  
   
    var i=0;
    function addRow(value) {
       
    	  //window.location.href="/HITS-UI/farechartupload.do?uploadfiles="+acfarefiles[0];
    	  //String stat=window.
    	  acfarefiles[count]=document.getElementById("acfare").files;
    	  nonacfarefiles[count]=$('#nonacfare').val();
          count++;
         farechart.addRows("dataTable","routename","acfare","nonacfare");
         farechart.optionCheck("routename");
         if(value == 2)
         {     
         farechart.optionDisable("stopname"); 
         }
         farechart.formreset("detailform"); 
      
          
        };
 
/*
    Clear all the rows in the table and adds all list options back to the dropdown list
*/
 
        function deleteAllRows(value) {
           
              farechart.clearAllRows("dataTable");    
              if(value == 2)
              {      
              farechart.optionEnable("stopname");
              }
        };
 
/*
    Clear the particular row from the table and add that particular list name to the dropdownlist 
*/         
        
        function deleteRow() {
         
            farechart.clearSingleRow("dataTable");
       };
  
/*
    Once Submit button is clicked it Enable All the options in the Stop Details
*/

 function enableopt() {
     
      farechart.optionEnable("stopname");  
      farechart.clearAllRows("dataTable");
 };



 function navigation()
 {
	alert('You are in navigation of Farechart.js'); 
	
	//window.location.href="/HITS-UI/chart.do?"+fd;
	
	var formData=new FormData();
	for(var k=0;k<count;k++)
	{
	   formData.append(acfarefiles[k].name,acfarefiles[k]);	
	   document.write(acfarefiles[k].name);
	
	}
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
     if (xhr.readyState === 4) {
          document.write(xhr.responseText);
	        }
	    };
	 xhr.open("POST", "/HITS-UI/chart.do", true);
	 var contentType = "multipart/form-data; boundary=---------------------------314911788813839";
	 xhr.setRequestHeader("Content-Type", contentType);
     xhr.send(formData);
     alert('request sent for the controller ');
 };


 var acfarefile=document.getElementById("acfare");
  var afile=acfarefile.files[0];
 formData.append("files",afile);
 














