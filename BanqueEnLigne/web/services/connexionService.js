
var app=angular.module('Banque',[]);
 
 app.service('connexionService',function(){
     
      var service = {};
 
        service.Login = Login;
        
        service.SetCredentials = SetCredentials;
        service.ClearCredentials = ClearCredentials;
        service.session=null;
        service.currentUser=null;
 
        return service;
     
        function connexion(login,password) {
            
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
                            deferred.resolve(user);
                        },
                        function (errResponse) {
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
        };
 });
