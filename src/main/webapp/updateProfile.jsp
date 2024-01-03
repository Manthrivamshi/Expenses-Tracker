<%@page import="com.jsp.expenseTracker.entity.User"%>
<%@page import="com.jsp.expenseTracker.entity.Expense"%>
<%@page import="com.jsp.expenseTracker.servlets.*"%>
<%@page import="com.jsp.expenseTracker.service.UserService"%>
<%@page import="com.jsp.expenseTracker.service.ExpenseService"%>
<%@page import="com.jsp.expenseTracker.service.*"%>
<%@page import="com.jsp.expenseTracker.service.ExpensesServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
       *{
            margin: 0px;
            padding: 0px;
        }
        body{
            width: 100%;
            height: 100%;
           
            
        }
        #body{
            width: 100%;
            height: 100%;
            background-color:white;
            position: relative;
        }
        #abc{
            height: 40px;
            background-color: rgb(246, 135, 246);
            padding:30px;
            display: flex;
            align-items: center;
        }
       
        h2{
            font-size: 20px;
            padding-left: 20px;
        }
        #icon{
            position: absolute;
            right: 18px;
            font-size: 30px;
        }
        #home{
            font-size: 30px;
            color: green;
            position: absolute;
            right: 700px;
        }
        #abc2{
        	margin:30px;
        	width: 700px;
        	height: 500px;
        	background-color: lime;
        }
    </style>
</head>
<body>
	<%
		int userId = Integer.parseInt(request.getParameter("userId"));
		UserService service = new  UserServiceImp();
		User user1 = service.findByUserId(userId);
	%>
	<form action="updateProfile" method="POST" enctype="multipart/form-data">

     <div id="body"> 
		<div id="abc">
		<img alt="" src="./media/index.png">
			<h2>Spring Expenses Tracker</h2>
           <a href=""> <i class="fa-solid fa-user" id="icon"></i></a>
            <a href=""><i class="fa-solid fa-home" id="home"></i></a>
		</div>
        <div id="abc1">
            
          <%
          	HttpSession session2=request.getSession();
         User user = (User) session2.getAttribute("userInfo");
          	
          	
 
          %>
    <center><div id="abc2">
    <br>
    <h1>Update Your Profile</h1>
      <br>
     <label for=""><p>Username</p></label>
       
        <input type="text" value="<%= user.getUsername()%>">
       
        <label for=""><p>Email:</p></label>
      
        <input type="email" value="<%= user.getEmail()%>">
    
   
        <label for=""><p>Mobile:</p></label>
     
        <input type="number" value="<%= user.getMobile()%>">
       
        <label for=""><p>Password:</p></label>
      
        <input type="password" value="<%= user.getPassword()%>">
   
        <label for=""><p>Profile Photo:</p></label>
   
        <input type="file" id="fileInput" accept="image/*" name="imageFile">
		
		<img alt="" src="" id="displayImage">  
		
		<input name="id" value=<%= user.getUserId()%> type="number" hidden>      
   	<br>
        <input type="submit" value="Update Profile">
    </div></center>
    
    	
    </div>
    </div>
</form>
<script>

	const fileInput = document.getElementById("fileInput");
	const displayImage = document.getElementById("displayImage");
	
	fileInput.addEventListener("change", function(){
		const file = fileInput.files[0];
		if(file && file.type.startsWith("image/")){
			const reader = new FileReader();
			reader.onload = function(e){
				displayImage.src = e.target.result;
				displayImage.style.display = "block";
			};
			reader.readAsDateURL(file);
		}
	});
</script>
</body>
</html>