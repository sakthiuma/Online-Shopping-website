function veg_category()
{
	var request=new XMLHttpRequest();
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("items").innerHTML=val;
		}
	     };
	request.open("GET","veg",true);
	request.send();
};
	
function nonveg_category()
{
	document.getElementById("items").innerHTML="";
	var request=new XMLHttpRequest();
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("items").innerHTML=val;
		}
	     };
	request.open("GET","nonveg",true);
	request.send();
};

function retrieveitem(str)
{
	var request=new XMLHttpRequest();
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("itemsdesc").innerHTML=request.responseText; 
			
		}
	     };
	request.open("GET","itemdesp?it="+str,true);
	request.send();
};

function retrievenonitem(str)
{
	var request=new XMLHttpRequest();
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("itemsdesc").innerHTML=request.responseText; 
			
		}
	     };
	request.open("GET","itemnondesp?it="+str,true);
	request.send();
};

function increasecart(clicked_id)
{
	
	var request=new XMLHttpRequest();
	var q="p"+clicked_id;
	var q1=clicked_id+"price";
	var qty=1;
	var price=document.getElementsByName(q1)[0].value;
	var name=document.getElementsByName("user_name")[0].value;
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("cartitems").innerHTML=val;
			
		}
	     };
	request.open("GET","cartincdesp?item="+clicked_id+"&qty="+qty+"&price="+price+"&name="+name,true);
	request.send();
	
	
};

function decreasecart(clicked_id)
{
	
	var request=new XMLHttpRequest();
	var q="p"+clicked_id;
	var q1=clicked_id+"price";
	var qty=-1;
	var price=document.getElementsByName(q1)[0].value;
	var name=document.getElementsByName("user_name")[0].value;
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("cartitems").innerHTML=val;
			
		}
	     };
	request.open("GET","cartdecdesp?item="+clicked_id+"&qty="+qty+"&price="+price+"&name="+name,true);
	request.send();
	
	
};

function decreasenoncart(clicked_id)
{
	
	var request=new XMLHttpRequest();
	var q="p"+clicked_id;
	var q1=clicked_id+"price";
	var qty=-1;
	var price=document.getElementsByName(q1)[0].value;
	var name=document.getElementsByName("user_name")[0].value;
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("cartitems").innerHTML=val;
			
		}
	     };
	request.open("GET","cartnondecdesp?item="+clicked_id+"&qty="+qty+"&price="+price+"&name="+name,true);
	request.send();
	
	
};

function increasenoncart(clicked_id)
{
	
	var request=new XMLHttpRequest();
	var q="p"+clicked_id;
	var q1=clicked_id+"price";
	var qty=1;
	var price=document.getElementsByName(q1)[0].value;
	var name=document.getElementsByName("user_name")[0].value;
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("cartitems").innerHTML=val;
			
		}
	     };
	request.open("GET","cartnonincdesp?item="+clicked_id+"&qty="+qty+"&price="+price+"&name="+name,true);
	request.send();
	
	
};

function deletenonfromcart(clicked_id)
{
	
	var request=new XMLHttpRequest();
	var q="p"+clicked_id;
	var q1=clicked_id+"price";
	var qty=0;
	var price=document.getElementsByName(q1)[0].value;
	var name=document.getElementsByName("user_name")[0].value;
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("cartitems").innerHTML=val;
			
		}
	     };
	request.open("GET","removecartnondesp?item="+clicked_id+"&qty="+qty+"&price="+price+"&name="+name,true);
	request.send();
	
	
};
function deletefromcart(clicked_id)
{
	
	var request=new XMLHttpRequest();
	var q="p"+clicked_id;
	var q1=clicked_id+"price";
	var qty=0;
	var price=document.getElementsByName(q1)[0].value;
	var name=document.getElementsByName("user_name")[0].value;
	request.onreadystatechange=function(){
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById("cartitems").innerHTML=val;
			
		}
	     };
	request.open("GET","removecartdesp?item="+clicked_id+"&qty="+qty+"&price="+price+"&name="+name,true);
	request.send();
	
	
};
	