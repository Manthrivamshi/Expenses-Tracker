<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	    
    <style>
        *{
            margin: 0px;
            padding: 0px;
        }
        
        body{
            width:100%;
            height:100%;
        
            background-image: linear-gradient(to top, rgb(230, 66, 186) 0%,rgb(230, 81, 230)10%);
        }
    
       #abc{
            width: 100%;
            height: 100%;
            background-color: rgb(246, 135, 246);
            padding:30px;
            padding-left: 50px;
            display: flex;
            align-items: center;
        }
        
        #abc2{
            width: 100%;
            height: 100%;
            position: absolute;
        }
        
        #abc3{
            background-color: white;
            width:500px;
            height: 500px;
            position: absolute;
            border-radius: 10px;
            position: relative;
            left: 600px;
            top: 50px;
            padding: 70px;
            align-items: center;
            align-content: center;
            justify-content: center;
           
        }
        #sign{
            font-size: 40px;
            margin-bottom: 30px;
            text-align: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        a{
            
            background-color: blue;
            color: aliceblue;
            font-weight: bold;
            border: none;
            padding-left: 80px;
            padding-right: 80px;
            padding-top: 20px;
            padding-bottom: 20px;
            
        }
        #Google{
           
            border: 1px solid rgba(25, 25, 25, 0.135);
            
            margin-left: 50px;  
           
        }
        input{
            width: 450px;
            height: 40px;
            background-color: whitesmoke;
            border: 0px;
        }
        #username{
            margin-top: 20px;
            font-size: 20px;
        }
        #pass{
            
            font-size: 20px;
        }
        button{
            width: 450px;
            height: 40px;
           background-color: black;
            font: white;
        }
        button{
            font: white;
        }
        #forgot{
            background-color: none;
            font: none;
            padding-left: 0px;
            padding-right: 0px;
            padding-top: 0px;
            padding-bottom: 0px;
        }
        #member{
        
            background-color: none;
            font: none;
            padding-left: 0px;
            padding-right: 0px;
            padding-top: 0px;
            padding-bottom: 0px;
        }
        
        
    </style>
</head>


<body>

			
			
<form method="POST" action="Login">
    <div id="container">
   <div id="abc">
    <img src="./media/index.png" alt="">
    
    <h1>Spring Expenses Tracker</h1>
   </div>
   <div id="abc2">
    <div id="abc3">
        <p id="sign">Sign In With</p>
        <br>
        <a id="facebook" href="https://www.facebook.com/" target="_blank">facebook</a>
        <a id="google" href="https://www.google.com" target="_blank">Google</a>
        <br>
        <br>
        <br>
        <p id="username">Username</p>
        <input type="text" placeholder="" name="username">
        <br>
        <br>
        <p id="password">password</p>
        <a id ="forgot" href="">Forgot?</a>
        <br>
        <input type="password" placeholder="" id="pass" name="password">
        
        
        
        <br>
        <br>
       <input type="submit" value="submit">
       
       
        <br>
        <p>Not a member?</p>
	
        <a id ="member" href="Register.jsp">Sign Up now?</a>
    </div>
   </div>
</div>
</form>
</body>
</html>