
<html>
<head>
<title>Main Page</title>
    <link rel="stylesheet" type="text/css" href="maincss.css"> </link>
<script type="text/javascript" src="func.js"></script>
    <style>
        #c1{
            color:white;
            font-weight: bold;
            text-decoration-color: gold;
            position:absolute;
            top:90%;
            left:55%;
            font-family: sans-serif;
            font-size: 30px;
        }
    </style>
</head>
<body>
    <div id="select_category"><p>&nbsp; &nbsp;&nbsp; &nbsp; SELECT CATEGORY</p>
		<button class="butn" onclick="veg_category()">Veg</button>
		<button class="butn1" onclick="nonveg_category()">Non-Veg</button>
		
	</div>
	
	<div id="items"> </div>

	<div id="itemsdesc"> </div>
	
	<input type="hidden" value="${param.name}" name="user_name" />
	<c:set var="u_name" value="${param.name}" scope="application" />
    <div id="c1"> YOUR CART</div><div id="cartitems"></div>
	<a href="thanks.html" ><button class="butn5">Submit</button></a>
	
</body>
</html>