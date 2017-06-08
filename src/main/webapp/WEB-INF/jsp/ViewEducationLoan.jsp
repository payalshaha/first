<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myApp">

<!-- <a href="mvc/viewEducationLoanDetails">View Education Loan Details</a> -->
<div ng-controller="EmpCtrl">

<h1>{{data1[0].accountHolderName}}</h1>
       
      <input type="text" ng-model="search.$" placeholder="Search"/>
       <hr/>

        <table>
        
           <tr>
            <td>S. No</td>
                <td>Loan Id</td>
                <td>Loan Account Number</td>
                <td>Loan Amount</td>
                 <td>Loan Apply Date</td> 
                <td>Loan Duration</td>
                <td>Father Annual Income</td>
                <td>Course Fee</td>
                <td>Course Name</td>
                <td>Father Name</td>
                <td>Id Number</td>
           </tr>
             <tr ng-repeat="user in li | filter: search">
           
                <td>{{$index + 1}}</td>
                <td>{{user.educationLoanId}}</td>
                <td>{{user.eduLoanAccountNumber}}</td>
                <td>{{user.eduLoanAmount}}</td>
                 <td>{{user.eduLoanApplyDate}}</td> 
                <td>{{user.eduLoanDuration}}</td>
                <td>{{user.fatherAnnualIncome}}</td>
                <td>{{user.courseFee}}</td>
                <td>{{user.courseName}}</td>
                <td>{{user.fatherName}}</td>
                <td>{{user.idNumber}}</td>
               
            </tr>
        </table>
    </div>
    <script>
    
    
    
    
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'viewEducationLoanDetails'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.data1 = data;
            	$scope.li=data[0].hld;
            })
        
           
        })
    </script>

</body>
</html>