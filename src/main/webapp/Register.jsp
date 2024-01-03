<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
        body{
            height: 700px;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        input{
            width:600px;
           padding: 15px;
            border-radius: 10px;
          
        }
        table{
            border-collapse: collapse;
            width:500px;
             height:500px;
            border: 2px solid rgb(108, 53, 212);
            background-color: rgb(127, 6, 240);
            
        }
        #submit{
            background-color:aqua;
        }
    </style>

<body>

    
</head>
<body>
    <div>
    <form method="POST" action="Registration">
      <table cellpadding="15">
        <tr><th> CREATE ACCOUNT</th></tr>
        <tr><td><input type="text" placeholder="Your Name" class="form-input" id="name" name="fullname" required></td></tr>
        <tr><td><input type="text" placeholder="Your UserName" class="form-input" id="username" name="username" required></td></tr>
        <tr><td><input type="email" placeholder="Your Email" class="form-input" id="email" name="email" required></td></tr>
        <tr><td><input type="number"placeholder="Your Mobile" class="form-input" id="mobile" name="mobile" required></td></tr>
        <tr><td><input type="password" placeholder="Password" class="form-input" id="password" name="password" required></td></tr>
        <tr><td><input type="text"  placeholder="Retype Your Password" class="form-input" id="cnpassword" name="cnpassword" required></td></tr>
        <tr><td align="center"><input type="submit" id="submit"></td></tr>
      
       	<tr><td><a id ="member" href="login.jsp">SignIn</a></td></tr>
        

        
        

      </table>
      </form>
    </div>
</body>
</html>
</body>
</html>