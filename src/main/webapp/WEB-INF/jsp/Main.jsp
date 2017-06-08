<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
</head>
<body>
	<center><h1>Welcome to Bank Management System</h1></center>
	<!-- Please add your application links by replacing the below sample links -->
	<br>
	<!-- <a href="#">Sample Link 1</a> -->
	<table>
	<tr>
	<td>Account Number</td>
	<td>Account Holder Name</td>
	<td>Account Type</td>
	
	<td>Account Balance</td>
	</tr>
	<tr>
	<td>${user.accountNumber}</td>
	<td>${user.accountHolderName}</td>
	<td>${user.accountType}</td>
	
	<td>${user.accountBalance}</td>
	</tr>
	
	</table>
	<table>
	<tr>
	<td><a href="adduserhomeloandetails/${user.accountNumber}">Apply Home Loan</a></td>
	<td><a href="viewuserhomeloandetails1/${user.accountNumber}">View Home Loan</a></td>
	</tr>
	<tr>
	<td><a href="applyLoan/${user.accountNumber}">Apply Education Loan</a></td>
	<td><a href="viewLoan">View Education Loan</a> </td>
	</tr>
	<tr>
	<td><a href="performtransaction/${user.accountNumber}">perform transaction</a></td>
    <td><a href="viewtransaction">view transaction</a></td>
    </tr>
	</table>
	
	

</body>
</html>