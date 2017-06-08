<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First Page</title>

<style>
	.cssClass {
		background-color: red;
	}
</style>



</head>
<body>
<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/performtransaction" modelAttribute="transaction">

<table>

<%-- <tr>
        <td>Transaction Id:</td>
        <td><form:input path="transactionId" /></td>
        <td><form:errors path="transactionId" cssClass="error" /></td>
    </tr> --%>
    
    
    <tr>
        <td>Transaction Amount:</td>
        <td><form:input path="transactionAmount" /></td>
        <td><form:errors path="transactionAmount" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>transactionType:</td>
        <td><form:input path="transactionType" /></td>
        <td><form:errors path="transactionType" cssClass="error" /></td>
    </tr>
    
    <%-- <tr>
        <td>Account Number:</td>
        <td><form:input path="accountNumber" /></td>
        <td><form:errors path="accountNumber" cssClass="error" /></td>
    </tr> --%>
    
    
      <tr>
        <td>Transaction Descriptionr:</td>
        <td><form:input path="transactionDescription" /></td>
        <td><form:errors path="transactionDescription" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td colspan="2"><input type="submit" value="Add"></td>
    </tr>
    
    
</table>


</form:form>
</body>

</html>