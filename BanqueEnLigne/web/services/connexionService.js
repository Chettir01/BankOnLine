
var app=angular.module('Banque');
 
 app.service('connexionService',['$q','$http',function($q,$http){
     
      var service = {};
       
        service.session=null;
        this.connexion=function  (login,password) {
            
            var deferred = $q.defer();
            $http({
            url : 'http://localhost:8084/BanqueEnLigne/connexion.htm',
            method : "POST",
            data : {
                'identifient' : login,
                'password': password
            }
            }).then(
                        function (response) {
                            var user = response.data;
                            service.currentUser=user;
                            deferred.resolve(user);
                        },
                        function (errResponse) {
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
        };
 }]);
