/**
 * 
 */

var status = 1;
var Menus = new DvMenuCls;

document.onclick=Menus.Clear;
function switchSysBar(){
	var switchPoint=document.getElementById("switchPoint");
	var frmTitle=document.getElementById("frmTitle");
     if (1 == window.status){
		  window.status = 0;
		  //alert(switchPoint);

          switchPoint.style.backgroundImage = 'url(../image/left1.png)';
          frmTitle.style.display="none";
     }
     else{
		  window.status = 1;
          switchPoint.style.backgroundImage = 'url(../image/right.png)'; 
          frmTitle.style.display="";
     }
}




