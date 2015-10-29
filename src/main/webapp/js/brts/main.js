
/*
  Offcanvas and Orbit Function

*/
$(function(){
$(document).foundation({
    	 orbit: {
    		    animation: 'slide',
    		    timer_speed: 1000,
    		    pause_on_hover: true,
    		    animation_speed: 500,
    		    navigation_arrows: true,
    		    bullets: false
         },
         offcanvas : {
                  open_method: 'move', 
    		      close_on_click : true
    		  }
       });
});    
    
/*
   Loading the html pages of top ,offcanvas and footer html files
*/    


$(function(){

   $('#header').load("/HITS-UI/main.do?type=Header");
   $('#navbar').load("/HITS-UI/main.do?type=SideBar");  
   $('#footer').load("/HITS-UI/main.do?type=Footer");
   $('#track').load("/HITS-UI/main.do?type=LastLogin&reportType=track");
   $('#idle').load("/HITS-UI/main.do?type=LastLogin&reportType=idle");
   $('#stats').load("/HITS-UI/main.do?type=LastLogin&reportType=stats");
   $('#activity').load("/HITS-UI/main.do?type=LastLogin&reportType=activity");
   $('#map').load("/HITS-UI/main.do?type=LastLogin&reportType=map");
});

    