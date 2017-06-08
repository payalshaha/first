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

<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/applyEducationLoan" modelAttribute="educationLoanDetails">
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
        <td><form:input path="eduLoanAmount" /></td>
        <td><form:errors path="eduLoanAmount" cssClass="error" /></td>
    </tr>
    
    <%--  <tr>
        <td>Loan Apply Date :</td>
        <td><form:input path="eduLoanApplyDate" /></td>
        <td><form:errors path="eduLoanApplyDate" cssClass="error" /></td>
    </tr> --%>
    
    <tr>
        <td>Duration Of The Loan :</td>
        <td><form:input path="eduLoanDuration" /></td>
        <td><form:errors path="eduLoanDuration" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Course Fee  :</td>
        <td><form:input path="courseFee" /></td>
        <td><form:errors path="courseFee" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Course name :</td>
        <td><form:input path="courseName" /></td>
        <td><form:errors path="courseName" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Father Name :</td>
        <td><form:input path="fatherName" /></td>
        <td><form:errors path="fatherName" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>ID No :</td>
        <td><form:input path="idNumber" /></td>
        <td><form:errors path="idNumber" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Annual Income :</td>
        <td><form:input path="fatherAnnualIncome" /></td>
        <td><form:errors path="fatherAnnualIncome" cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="Add"></td>
    </tr>
</table>
</form:form>

</body>
</html>