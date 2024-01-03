<%@page import="com.jsp.expenseTracker.entity.Expense"%>
<%@page import="com.jsp.expenseTracker.service.ExpenseService"%>
<%@page import="com.jsp.expenseTracker.service.ExpensesServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	
	<style type="text/css">
		*{
            margin: 0px;
            padding: 0px;
        }
        body{
            width: 100%;
            height: 100%;
           overflow: hidden;
            
        }
        #body{
            width: 100%;
            height: 100vh;
            background-color: red;
            position: relative;
        }
        #abc{
            height: 40px;
            background-color: rgb(246, 135, 246);
            padding:30px;
            display: flex;
            align-items: center;
        }
        img{
           
            font-size: 30px;
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
            width: 150vh;
            height: 600px;
            background-image: radial-gradient(ellipse at center,deeppink 10%, deeppink 20%, deeppink 30%,deeppink 40%,deeppink 50%,deeppink 60%, deeppink 70%, rgb(255, 20, 114) 80%);
            position: absolute;
            left: 290px;

           

        }
        #gallery{
            size-adjust: 60px;
            position: absolute;
           top: 130px;
           left: 100px;
           display: flex;
           align-self: center;
        }
        #abc3{
            position: absolute;
            right: 60px;
            top: 50px;
        }
        input{
            width: 200px;
            height: 4vh;
            border-radius: 30px;
            padding-left: 30px;
            padding-right: 20px;
            font-size: 20px;
            margin-top:18px;
            border: none;
            outline: none;
        }
        #textarea{
            padding: 20px;
           margin-top: 20px;
           border: none;
        }
        #button{
            width: 100px;
            background-color: rgb(58, 206, 58);
            border: none;
        }
        #drop{
            width: 250px;
            height: 30px;
            border-radius: 20px;
            font-size:10px;
            padding: 20px;
            margin-top: 20px;
        }
        
	</style>
</head>
<body>
<% 

		
		int eid = Integer.parseInt(request.getParameter("expencesId"));
		ExpenseService expenseService = new ExpensesServiceImpl();
		Expense expense = expenseService.findExpenseById(eid);
	%>

<form action="updateExpense" method="get">
         <div id="body"> 
		<div id="abc">
		<img alt="" src="./media/index.png">
			<h2>Spring Expenses Tracker</h2>
           <a href="login.jsp"> <i class="fa-solid fa-user" id="icon"></i></a>
            <a href="Home.jsp"><i class="fa-solid fa-home" id="home"></i></a>
		</div>
       
        <div id="abc1">
            <img src="./media/addExpense.png" alt="" id="gallery" style="width: 300px;">
            <div id="abc3">
                <center><h2>Update Expenses</h2>
                <br>
                <input type="number" placeholder="Amount" name="amount" value="<%=expense.getAmount()%>" >
                <br>
                <input type="date" name="date" value="<%= expense.getDate()%>" >
                <br>
                
                
                <input type="text" placeholder="--Category--" list="drop" name="category" value ="<%=expense.getCategory() %>" >
                      <datalist id="drop">
                    <option value="Utilities">Utilities</option>
                    <option value="Transportation">Transportation</option>
                    <option value="Groceries">Groceries</option>
                    <option value="DiningOut">DiningOut</option>
                    <option value="Entertainment">Entertainment</option>
                    <option value="HealthCare">HealthCare</option>
                    <option value="Education">Education</option>
                    <option value="PersonalCare">PersonalCare</option>
                    <option value="Clothing">Clothing</option>
                    <option value="HomeMaintainance">HomeMaintainance</option>
                    <option value="Gifts&Donations">Gifts&Donations</option>
                    <option value="Saving&investments">Saving&investments</option>
                    <option value="Tax">Tax</option>
                    <option value="Others">Others</option>
                    
               
                </datalist>
                <br>
                <textarea name="Description" id="textarea" cols="26" rows="5" placeholder="Description " style="border-radius: 30px;" <%=expense.getDescription() %>></textarea>
                <br>
                <input type="submit" value="ADD +" id="button" name="">
            </div>

        </div>
        
		<div>
		</form>
	
</body>
</html>