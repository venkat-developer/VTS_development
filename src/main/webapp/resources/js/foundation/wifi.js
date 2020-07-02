/*

   Get the content from the form "detailform" and display it the table
*/
    
    var uploads = {
  
        /*
            Reset the particular form
        */
        
        
       formreset : function (formId) {
        
            document.forms[formId].reset();
              
       },

        
        /*
            Add Rows to the table
        
        */
        
        addRows : function (tableId,fileId) {
        
           var table = document.getElementById(tableId);
           var rowCount = table.rows.length;
           var row = table.insertRow(rowCount);
           var cell1 = row.insertCell(0);
        
           var element1 = document.createElement("input");
           element1.type = "checkbox";
           element1.name="chkbox[]";
           cell1.appendChild(element1);
        
           var cell2 = row.insertCell(1);
           cell2.innerHTML=$('#'+fileId).val();
        
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

    function addRow() {
       
         uploads.addRows("dataTable","filename");
         uploads.formreset("detailform"); 
      
          
        };
 
/*
    Clear all the rows in the table and adds all list options back to the dropdown list
*/
 
        function deleteAllRows(value) {
           
              uploads.clearAllRows("dataTable");    
           
        };
 
/*
    Clear the particular row from the table and add that particular list name to the dropdownlist 
*/         
        
        function deleteRow() {
         
            uploads.clearSingleRow("dataTable");
       };
  
/*
    Once Submit button is clicked it Enable All the options in the Stop Details
*/


