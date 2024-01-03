<%@page import="com.jsp.expenseTracker.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	
	
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <style>
        *{
            box-sizing: border-box;
            margin: 0px;
        }
        .header{
            width: 100%;
            height: 100px;
            background-color: violet;
            display: flex;
            flex-direction: row;
           

        }
        #icon1{
          align-self: center;
         
        }
        #img1{
            width: 50px;
            height: 50px;
            padding-left:10px;
        }

        #Spring{
            align-self: center;
           
        }
        #spring1{
            padding-left: 20px;
        }
        #icon2{
            align-self: center;
        }
        #span1{
            position: relative;
            left: 1050px;
            font-size: 10vh;
        }
        .container{
            width: 100%;
            height:550px;
            background-color: blue;
            display: flex;
            justify-content:center;
            align-items: center;
        }
        .division{
            width: 250px;
            height: 150px;
            text-align: center;
            padding-top:50px ;
            font-size: 25px;
            box-sizing: border-box;
            color: white;
        }
        .parent{
            width:800px;
            height: 500px;
            /* border: 5px solid orangered; */
          
        }
        
        #div1{
            float: left;
        }
        @keyframes div1 {
            30%{
                transform: translateX(40px);
                transform: scale(1.2);
                font-size: 30px;
                font-weight: bold;
            }
            60%{
                transform: translateX(-40px);
            }
            100%{
                transform: translateX(0px);
            }
        }
        #div1:hover{
            animation: div1 2s ease 1 ;
        }
        #div2{
           
            float: right;
        }
        @keyframes div2 {
            30%{
                transform: translateX(40px);
                transform: scale(1.2);
                font-weight: bold;
            }
            60%{
                transform: translateX(-40px);
            }
            100%{
                transform: translateX(0px);
            }
        }
        #div2:hover{
            animation: div1 2s ease 1 ;
        }
        #div3{
            clear: both;
            margin-top: 340px;
        }
        @keyframes div3 {
            30%{
                transform: translateX(40px);
                transform: scale(1.2);
                font-weight: bold;
            }
            60%{
                transform: translateX(-40px);
            }
            100%{
                transform: translateX(0px);
            }
        }
        #div3:hover{
            animation: div1 2s ease 1 ;
        }
        #div4{
            margin-top: -150px;
            margin-left: 540px;
        }
        @keyframes div4 {
            30%{
                transform: translateX(40px);
                transform: scale(1.2);
                font-weight: bold;
            }
            60%{
                transform: translateX(-40px);
            }
            100%{
                transform: translateX(0px);
            }
        }
        #div4:hover{
            animation: div1 2s ease 1 ;
        }
        #div5{
            /* background-color: rgb(0, 255, 213); */
            margin-top: -320px;
            margin-left: 270px;
            color: green;
            font-weight: bold;

        }
        @keyframes div5 {
            100%{
                transform: scale(2);
            }
        }
        #div5:hover{
            animation: div1 4s ease 1 reverse ;
        }
        .footer{
            width: 100%;
		    height: 50px;
		    background-color: black;
		    position: absolute;
		    top: 94%;
        }
        .items:hover
        {
        	background-color: grey;
        	cursor:pointer;
        	color:aliceblue;
        	font-weight: bolder;
        }
        #lastbox{
        	width: 150px;
        	height: 35px;
        	position: relative;
        	left:1000px;
        	display:none;
        	border-radius: 10px;
        	font-size: 20px;
        	cursor: pointer;
        }
        #icon2:hover #lastbox
        {
        	display: block;
        	z-index: 2;
        }
    </style>
</head>
<body>
      <%
      String message = (String)request.getAttribute("msg");
		//User user = (User)request.getAttribute("userInfo");
		HttpSession session2=request.getSession();
		User user = (User)session2.getAttribute("userInfo");
      %>
    <div class="header">
        <div id="icon1"><img src="media/index.png" alt="" id="img1"></div>
        <div id="Spring"><h1 id="spring1">Spring expenses Tracker</h1></div>
        <div id="icon2">
        <a href=""><span id="span1" class="material-symbols-outlined" >manage_accounts </span></a>
    
        	<div id="lastbox">
        		<ul type="none">
        			<li class="items"><a href="updateProfile.jsp?userId=<%=user.getUserId()%>">Update Profile</a></li>
        			<a href=""><li class="items">About Us</li></a>
        			<li class="items">Contact Us</li>
        			<a href="login.jsp"><li class="items">Logout</li></a>
        		</ul>
        	</div>
        </div>
    </div>
    <div class="container">
        <div class="parent">
        
            <a href="AddExpence.jsp"><div id="div1" class="division"> <span class="material-symbols-outlined">person_add</span><br> Add Expenses</div></a>
            <a href="viewExpense.jsp"><div id="div2" class="division"><span class="material-symbols-outlined">visibility</span><br>View Expenses</div></a>
            <div id="div3" class="division"><span class="material-symbols-outlined">functions</span><br>Total Expenses</div>
            <div id="div4" class="division"><span class="material-symbols-outlined">filter_alt</span><br>Filter Expenses</div>
            
            
      	<%

			if(message != null){
		%>
			<script type="text/javascript">
				alert("<%= message%>");
			</script>	
		<%
			}
			message = null;
		%>
	
		
		<div>
			<%
				if(user != null){
			%>
				<div id="div5" class="division"><h1 id="wel">Welcome <%= user.getFullname() %></h1></div>
				
			<%
				}
			%>
		</div>
	</div>
    <div class="footer" style="color: white; text-align: center; padding-top: 10px;" >&copy; 2023 jSPIDER. All rights reserved</div>
</body>
</html>