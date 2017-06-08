<html>
<head>
    <title>Transaction List</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
</head>
<body ng-app="myApp">
    <div ng-controller="EmpCtrl">
       <h2>Your account number is:{{userdisplay[0].accountNumber}}</h2>
      <input type="text" ng-model="search.$" placeholder="Search"/>
       <hr/>

        <table>
        
        <tr>
            <td>S. No</td>
                <td>Account Holder Name</td>
                <td>Transaction Id</td>
                <td>Transaction Description</td>
                 <td>Transaction Type</td> 
                <td>Transaction Amount</td>
                
           </tr>
        
        
            <tr ng-repeat="list in li | filter: search">
                <td>{{$index + 1}}</td>
                <td>{{userdisplay[0].accountHolderName}}</td>
                <td>{{list.transactionId}}</td>
                <td>{{list.transactionDescription}}</td>
                <td>{{list.transactionType}}</td>
                 <td>{{list.transactionAmount}}</td>
            </tr>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'transaction'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.userdisplay=data;
            	$scope.li = data[0].trans;
            	
            })
        
           
        })
    </script>
</body>
</html>