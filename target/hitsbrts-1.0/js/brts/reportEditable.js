var heading ="";  
function reportEdit(headingName,tableColumnNamesList,reportList,depotList) {
	  
		 heading=headingName;
		 var metadata = [];
			var list = tableColumnNamesList;
			 $.each(list, function( index, value ) {
				metadata.push(value);
			});
			 
			if(heading == "DriverDetails"){
			 metadata[4].values = depotList;
			}else if(heading == "Conductor Details"){
				 metadata[3].values = depotList;
			}
			 
			 var data = [];
			 var dataList = reportList;
			 $.each(dataList, function( index, value ) {
				data.push(value);
			});
			
				// this approach is interesting if you need to dynamically create data in Javascript 
				
				/* metadata.push({ name: "name", label: "NAME", datatype: "string", editable: true});
				metadata.push({ name: "firstname", label:"FIRSTNAME", datatype: "string", editable: true});
				metadata.push({ name: "age", label: "AGE", datatype: "integer", editable: true});
				metadata.push({ name: "height", label: "HEIGHT", datatype: "double(m,2)", editable: true});
				metadata.push({ name: "country", label: "COUNTRY", datatype: "string", editable: true});
				metadata.push({ name: "email", label: "EMAIL", datatype: "email", editable: true});
				metadata.push({ name: "freelance", label: "FREELANCE", datatype: "boolean", editable: true});
				metadata.push({ name: "lastvisit", label: "LAST VISIT", datatype: "date", editable: true}); */

				// a small example of how you can manipulate the object in javascript
				/* metadata[4].values = {};
				metadata[4].values["Europe"] = {"be":"Belgium","fr":"France","uk":"Great-Britain","nl":"Nederland"};
				metadata[4].values["America"] = {"br":"Brazil","ca":"Canada","us":"USA"};
				metadata[4].values["Africa"] = {"ng":"Nigeria","za":"South-Africa","zw":"Zimbabwe"};

				var data = [];
				data.push({id: 1, values: {"country":"uk","age":33,"name":"Duke","firstname":"Patience","height":1.842,"email":"patience.duke@gmail.com","lastvisit":"11\/12\/2002"}});
				data.push({id: 2, values: ["Rogers","Denise",59,1.627,"us","rogers.d@gmail.com","","07\/05\/2003"]});
				data.push({id: 3, values: {"name":"Dujardin","firstname":"Antoine","age":21,"height":1.73,"country":"fr","email":"felix.compton@yahoo.fr","freelance":true,"lastvisit":"21\/02\/1999"}});
				data.push({id: 4, values: {"name":"Conway","firstname":"Coby","age":47,"height":1.96,"country":"za","email":"coby@conwayinc.com","freelance":true,"lastvisit":"01\/12\/2007"}});
				data.push({id: 5, values: {"name":"Shannon","firstname":"Rana","age":24,"height":1.56,"country":"nl","email":"ranna.shannon@hotmail.com","freelance":false,"lastvisit":"07\/10\/2009"}});
				data.push({id: 6, values: {"name":"Benton","firstname":"Jasmine","age":61,"height":1.71,"country":"ca","email":"jasmine.benton@yahoo.com","freelance":false,"lastvisit":"13\/01\/2009"}});
				data.push({id: 7, values: {"name":"Belletoise","firstname":"André","age":31,"height":1.84,"country":"be","email":"belletoise@kiloutou.be","freelance":true,"lastvisit":""}});
				data.push({id: 8, values: {"name":"Santa-Maria","firstname":"Martin","age":37,"height":1.80,"country":"br","email":"martin.sm@gmail.com","freelance":false,"lastvisit":"12\/06\/1995"}});
				data.push({id: 9, values: {"name":"Dieumerci","firstname":"Amédé","age":37,"height":1.81,"country":"ng","email":"dieumerci@gmail.com","freelance":true,"lastvisit":"05\/07\/2009"}});
				data.push({id: 10,values: {"name":"Morin","firstname":"Wanthus","age":46,"height":1.77,"country":"zw","email":"morin.x@yahoo.jsdata.com","freelance":false,"lastvisit":"04\/03\/2004"}});
		          */
				editableGrid = new EditableGrid("DemoGridJsData",{
						enableSort: true, // true is the default, set it to false if you don't want sorting to be enabled
						editmode: "absolute", // change this to "fixed" to test out editorzone, and to "static" to get the old-school mode
						editorzoneid: "edition", // will be used only if editmode is set to "fixed"
						pageSize: 10,
				       	tableRendered:  function() {  
				       	updatePaginator(this);
				       	this.initializeGrid(this);
				       	}, 
				      // tableLoaded: function() {  alert('tableLoaded');	this.initializeGrid(this);},
				       	modelChanged: function(rowIndex, columnIndex, oldValue, newValue, row) {
					          updateCellValue(this, rowIndex, columnIndex, oldValue, newValue, row);
				       	}
						
					});
		        
				editableGrid.load({"metadata": metadata, "data": data});
				editableGrid.renderGrid("tablecontent", "testgrid");
		        editableGrid.sort(0, false, 0); 
	}; 
	
	 EditableGrid.prototype.initializeGrid = function() 
	 {
		 with (this) {
			 this.setCellRenderer("action", new CellRenderer({render: function(cell, value) {
					// this action will remove the row, so first find the ID of the row containing this cell 
					var rowId = editableGrid.getRowId(cell.rowIndex);
					
					cell.innerHTML+= "<i onclick=\"editableGrid.deleteRow("+rowId+");\" style=\"cursor:pointer\">"+
					"<img src=\"" + image("delete.png") + "\" border=\"0\" alt=\"delete\" title=\"Delete row\"/></a>";

				}}));
		 }
	 }
	 EditableGrid.prototype.deleteRow = function(id) 
	 {

	   var self = this;

	   if ( confirm('Are you sure you want to delete ? ' )  ) {

	         $.ajax({
	 		url: '/HITS-UI/update.do',
	 		type: 'POST',
	 		dataType: "html",
	 		data: {
	 			reportname:heading,	
	 			type:"delete",
	 			tablename : editableGrid.name,
	 			id: id
	 		},
	 		success: function (response) 
	 		{ 
	 			if (response != null  )
	 		        editableGrid.removeRow(id);
	 		},
	 		error: function(XMLHttpRequest, textStatus, exception) { alert("Not Deleted:\n" + textStatus); },
	 		async: true
	 	});

	         
	   }
	 	
	 }; 
	
	 function highlightRow(rowId, bgColor, after)
	 {
	 	var rowSelector = $("#" + rowId);
	 	rowSelector.css("background-color", bgColor);
	 	rowSelector.fadeTo("normal", 0.5, function() { 
	 		rowSelector.fadeTo("fast", 1, function() { 
	 			rowSelector.css("background-color", '');
	 		});
	 	});
	 }
	
		
	 function highlight(div_id, style) {
	 	highlightRow(div_id, style == "error" ? "#e5afaf" : style == "warning" ? "#ffcc00" : "#8dc70a");
	 }
	 

	 /**
	   updateCellValue calls the PHP script that will update the database. 
	 */
	function updateCellValue(editableGrid, rowIndex, columnIndex, oldValue, newValue, row, onResponse)
	{      
		 if ( confirm('Are you sure you want to update ? ' )  ) {
		$.ajax({
			url: '/HITS-UI/update.do',
			type: 'POST',
			dataType: "html",
		   		data: {
		   		reportname:heading,	
		   		type:"update",	
				tablename : editableGrid.name,
				id: editableGrid.getRowId(rowIndex), 
				newvalue: editableGrid.getColumnType(columnIndex) == "boolean" ? (newValue ? 1 : 0) : newValue, 
				colname: editableGrid.getColumnName(columnIndex),
				coltype: editableGrid.getColumnType(columnIndex)			
			},
			success: function (response) 
			{ 
			//alert('success'+response);
				// reset old value if failed then highlight row
				var success = onResponse ? onResponse(response) : (response != null || !isNaN(parseInt(response))); // by default, a sucessfull reponse can be "ok" or a database id 
							//	alert(success);
				if (!success) 
					editableGrid.setValueAt(rowIndex, columnIndex, oldValue);
			    highlight(row.id, success ? "ok" : "error"); 
			},
			error: function(XMLHttpRequest, textStatus, exception) { 
				var success = onResponse ? onResponse(textStatus) : (textStatus == null || !isNaN(parseInt(textStatus))); // by default, a sucessfull reponse can be "ok" or a database id 
            if (!success) 
			editableGrid.setValueAt(rowIndex, columnIndex, oldValue);
		    highlight(row.id, success ? "ok" : "error");
		    alert("Not updated:\n" + textStatus); 
		    },
			async: true
		});
		 }
	}
	function image(relativePath) {
		return "img/" + relativePath;
	}

	function updatePaginator(grid, divId)
	{
		 divId = divId || "paginator";
			var paginator = $("#" + divId).empty();
			var nbPages = grid.getPageCount();

		

		// get interval
		var interval = grid.getSlidingPageInterval(20);
		if (interval == null) return;

		// get pages in interval (with links except for the current page)
		var pages = grid.getPagesInInterval(interval, function(pageIndex, isCurrent) {
			if (isCurrent) return "" + (pageIndex + 1);
			return $("<a>").css("cursor", "pointer").html(pageIndex + 1).click(function(event) { editableGrid.setPageIndex(parseInt($(this).html()) - 1); });
		});

		// "first" link
		var link = $("<a>").html("<img src='" + image("gofirst.png") + "'/>&nbsp;");
		if (!grid.canGoBack()) link.css({ opacity : 0.4, filter: "alpha(opacity=40)" });
		else link.css("cursor", "pointer").click(function(event) { editableGrid.firstPage(); });
		paginator.append(link);

		// "prev" link
		link = $("<a>").html("<img src='" + image("prev.png") + "'/>&nbsp;");
		if (!grid.canGoBack()) link.css({ opacity : 0.4, filter: "alpha(opacity=40)" });
		else link.css("cursor", "pointer").click(function(event) { editableGrid.prevPage(); });
		paginator.append(link);

		// pages
		for (p = 0; p < pages.length; p++) paginator.append(pages[p]).append(" | ");

		// "next" link
		link = $("<a>").html("<img src='" + image("next.png") + "'/>&nbsp;");
		if (!grid.canGoForward()) link.css({ opacity : 0.4, filter: "alpha(opacity=40)" });
		else link.css("cursor", "pointer").click(function(event) { editableGrid.nextPage(); });
		paginator.append(link);

		// "last" link
		link = $("<a>").html("<img src='" + image("golast.png") + "'/>&nbsp;");
		if (!grid.canGoForward()) link.css({ opacity : 0.4, filter: "alpha(opacity=40)" });
		else link.css("cursor", "pointer").click(function(event) { editableGrid.lastPage(); });
		paginator.append(link);
		
		
		
		
	    
	}; 
