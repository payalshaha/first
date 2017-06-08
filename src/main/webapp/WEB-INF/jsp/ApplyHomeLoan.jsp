<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Registration Page</title>
<style>
	.cssClass {
		background-color: red;
	}
</style>
</head>
<body>

<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/adduserhomeloandetails" modelAttribute="homeLoanDetails">
<table>
    <%-- <tr>
        <td>Account Number :</td>
        <td><form:input path="accountNumber" /></td>
        <td><form:errors path="accountNumber" cssClass="error" /></td>
    </tr> --%>
    <tr>
       
        <td><form:hidden path="accountNumber"/></td>
        <td><form:errors path="accountNumber" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Loan Amount :</td>
        <td><form:input path="loanAmount" /></td>
        <td><form:errors path="loanAmount" cssClass="error" /></td>
    </tr>
     <tr>
        <td>Loan Apply Date :</td>
        <td><form:input path="loanApplyDate" /></td>
        <td><form:errors path="loanApplyDate" cssClass="error" /></td>
    </tr>
     <tr>
        <td>Duration of the Loan :</td>
        <td><form:input path="loanDuration" /></td>
        <td><form:errors path="loanDuration" cssClass="error" /></td>
    </tr>
    
     <tr>
        <td>Annual Income :</td>
        <td><form:input path="annualIncome" /></td>
        <td><form:errors path="annualIncome" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Company Name :</td>
        <td><form:input path="companyName" /></td>
        <td><form:errors path="companyName" cssClass="error" /></td>
    </tr>
     <tr>
        <td>Designation :</td>
        <td><form:input path="designation" /></td>
        <td><form:errors path="designation" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Total Experience :</td>
        <td><form:input path="totalExp" /></td>
        <td><form:errors path="totalExp" cssClass="error" /></td>
    </tr>
     <tr>
        <td>Experience with current company :</td>
        <td><form:input path="expCurrentDate" /></td>
        <td><form:errors path="expCurrentDate" cssClass="error" /></td>
    </tr>
    
    
    <tr>
        <td colspan="2"><input type="submit" value="Add"></td>
    </tr>
</table>
</form:form>

</body>
</html>