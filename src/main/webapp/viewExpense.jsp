<%@page import="com.jsp.expenseTracker.entity.Expense"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<link rel="icon" href="./media/index.png">
	
	<style type="text/css">
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
        #abc1{
            width:1000px;
            height: 600vh;
            background-color: aqua;
            position: absolute;
            left: 300px;
        }
        #tab{
            width: 100%;
           display: flex;
           align-items: center;
           justify-content: center;
           padding: 30px;
           padding: 30px;
        }
        table{
           
            border: 1px solid black;
            
        }
        th{
            border: 1px solid black;
        }
       
       
        
	</style>
</head>
<body>
<form action="viewExpenses" method="get">
    <div id="body"> 
		<div id="abc">
		<img alt="" src="./media/index.png">
			<h2>Spring Expenses Tracker</h2>
           <a href="login.jsp"> <i class="fa-solid fa-user" id="icon"></i></a>
            <a href="Home.jsp"><i class="fa-solid fa-home" id="home"></i></a>
		</div>
   <div id="abc1">
            <center><h1>Expenses Details</h1></center>
         <div id="tab">
               <table>
                    <tr>
                        <th>Sr. No</th>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Action</th>

                    </tr>
                    	<%
                    		List<Expense> listOfExpenses = (List)request.getAttribute("list");
                    		if(listOfExpenses != null){
                    		int a=0;
                    		for(Expense e : listOfExpenses){
                    	
                    	%>
                    <tr>
                    	<th><%= ++a%></th>
                        <td><%= e.getDate()%></td>
                        <td><%= e.getAmount()%></td>
                        <td><%= e.getCategory()%></td>
                        <td><%= e.getDescription()%></td>
                        
                        
                       <td>
                       <a href="updateExpense.jsp?expencesId=<%=e.getExpenseId()%>"><input type="submit" value="update"></a>
                        
                       <a href="DeleteExpense?expencesId=<%=e.getExpenseId()%>"><input type="button" value="delete"></a></td>
                        
                    </tr>
                   <%
                    		}//close foreach
                    	}//close if
                    	
                   %>
                  
                </table>
            </div>
            
        </div>
        </div>
</form>
	
</body>
</html>