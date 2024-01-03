<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Total Expenses</title>
    <script src="https://kit.fontawesome.com/c51795afff.js" crossorigin="anonymous"></script>
    <link rel="icon" href="./media/index.png">
    <link rel="stylesheet" href="totalexpenses.css">
    <style>
    *
        {
            margin:0%;
            padding:0%;
        }
    #output
    {
    	margin-top:490px;
    	margin-left:507px;
    }
    



        .header
        {
            margin:0px;
            padding:0px;
            height:90px;
            width:100%;
            background-color: rgba(246, 135, 246);
        }

        div b{
            position: absolute;
            top:5%;
            left:8%;
            font-size: 25px;
        }
        body
        {
            background-image: url("bg.png");
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size:cover;
        }
        .maib
        {
          border-style: none;
           padding-top:8px;
           height:530px;
           width:70%;
           background-image: linear-gradient(to bottom,lightgreen,rgba(255, 255, 0,0.5),rgba(255, 166, 0,0.5),rgba(138, 43, 227,0.3));
        }
        div div
        {
            margin-top:50px;
        }
        h2{
            font-size: 30px;
            font-weight: bold;
            letter-spacing: 6px;
        }
        input
        {
            height:70px;
            width:700px;
            border-style:none;
            border-bottom-style:solid;
            font-size: 20px;
            font-style: oblique;
            color:red;
            text-align: center;
            box-shadow:2px 2px 5px 5px grey;
        }
        input::placeholder
        {
            color:red;
            padding-left:30px;

        }
        label
        {
            font-size: large;
            font-weight: bold;

        }
        .lb
        {
            height:50px;
            width:140px;
            border-style:none;
            background-color:blueviolet;
            color:white;
            letter-spacing: 2px;
            font-weight: bold;
        }

        .header #dd
        {
            font-size:large;
            position:absolute;
            right:18%;
            top:5%;
            text-decoration: none;
            color:black;
        }
    </style>
</head>
<body>
  <%
 String popup=  (String) request.getAttribute("processMsg");
    Double result=(Double)request.getAttribute("result");
    if(popup!=null  && result!=null){
    %>
    <script>alert('CALUCLATION IN PROGRES !!');
</script>    
    <%} %>

 <div class="header">
        <a href="index.png"> <img src="./media/index.png" style="height:47px;width:47px;padding:22px;margin-left:33px;"> </a>
            <b>Spring Expenses Tracker</b>
            <a href="home.jsp" id="dd"><i class="fa-solid fa-home"></i>&nbsp;Home</a>

    </div><br><br>
    <center>
    <div class="maib">
<h2>Total Expenses</h2>
<div>
<form method="post" action="TotalExpenses">
    <label>Start Date</label><br><br>
    <input type="date" placeholder="dd-mm-yyyy" name="sd">
    <br><br><br><br>
    <label>End Date</label><br><br>
    <input type="date" placeholder="dd-mm-yyyy" name="ed">
    <br><br><br>
    <%if (result!=null ){ %>
    <b id="output" style="color:blue;font-size:21px;"><%=popup%><%=result %></b>
  <%} %>  <br><br>
    <input type="submit" value="submit" class="lb">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="reset" class="lb">
</form></div>
    </div></center>
    
    
  
</body>
</html>