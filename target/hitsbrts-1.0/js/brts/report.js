/**
 *Creating the new window for print preview 
 */
function openPreview(heading){

	var myWindow=window.open('/HITS-UI/reportsgen.do?reportOption=preview&heading='+heading,'','width=1000,height=1300,scrollbars=1,left=400');
    
};
/**
 *Opening the print option window 
  *
  */
function openPrint(heading){
	
	var myWindow=window.open('/HITS-UI/reportsgen.do?reportOption=print&heading='+heading,'','width=1000,height=1300,scrollbars=1,left=400');
	myWindow.print();
    
};
/**
 *Creating the new window for transaction report - print preview 
 */
function openTransactionPreview(heading,from,to,operatortype,reportType){
	
	alert("openi")
	var myWindow=window.open('/HITS-UI/reportsgen.do?reportOption=preview&heading='+heading+'&from='+from+'&to='+to+'&operatortype='+operatortype+'&reportType='+reportType,'','width=1000,height=1300,scrollbars=1,left=400');
    
};
/**
 *Opening the print option window for transaction report 
 *
 */
function openTransactionPrint(heading,from,to,operatortype,reportType){
	
	alert("Opening print window");
	var myWindow=window.open('/HITS-UI/reportsgen.do?reportOption=print&heading='+heading+'&from='+from+'&to='+to+'&operatortype='+operatortype+'&reportType='+reportType,'','width=1000,height=1300,scrollbars=1,left=400');
	myWindow.print();
    
};