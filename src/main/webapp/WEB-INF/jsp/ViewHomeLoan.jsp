<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Insert title here</title>
</head>
<body ng-app="myApp">

	<!-- Please add your application links by replacing the below sample links -->
	<br>
	<!-- <a href="#">Sample Link 1</a> -->
	<div ng-controller="EmpCtrl">
       <h1>{{data[0].accountHolderName}}</h1>
      <input type="text" ng-model="search.$" placeholder="Search"/>
       <hr/>
    ${accountNumber}
        <table>
        
        <tr>
            <td>S. No</td>
                <td>Loan Id</td>
                <td>Loan Account Number</td>
                <td>Loan Amount</td>
                 <td>Loan Apply Date</td> 
                <td>Annual Income</td>
                <td>Company Name</td>
                <td>Designation</td>
                <td>Total Experience</td>
                <td>Current Experience</td>
                <td>Loan Duration</td>
           </tr>
          <tr ng-repeat="user in user1 | filter: search"> 
                <td>{{$index + 1}}</td>
                <td>{{user.homeLoanId}}</td>
                <td>{{user.homeLoanAccountNumber}}</td>
                <td>{{user.loanAmount}}</td>
                <td>{{user.loanApplyDate}}</td>
                <td>{{user.annualIncome}}</td>
                <td>{{user.companyName}}</td>
                <td>{{user.designation}}</td>
                 <td>{{user.totalExp}}</td>
                 <td>{{user.expCurrentDate}}</td>
                 <!-- <td>{{user.totalExp}}</td> -->
                 <td>{{user.loanDuration}}</td>
                  
            
           <!--  </tr> -->
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'viewuserhomeloandetails?accountNumber=${accountNumber}'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.data = data;
            	$scope.user1 = data[0].homeloan;
            })
        
           
        })
    </script>

</body>
</html>