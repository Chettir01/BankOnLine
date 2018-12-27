(function () {
    'use strict';
 
    angular
        .module('app')
        .factory('ConnexionService', ConnexionService);
 
    ConnexionService.$inject = ['$cookies', '$rootScope', 'UserService'];
    function ConnexionService($cookies, $rootScope, UserService) {s
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
        }
 
        function Login(username, password, callback) {
                var response;
                UserService.GetByName(username)
                    .then(function (user) {
                        if (user !== null) {
                            if (user.password === password) {
                                response = { success: true };
                            }
                            else {
                                response = { success: false, message: 'Erreur login / Mot de passe' };
                            }
                        }
                        else {
                            response = { success: false, message: 'Compte inexistant' };
                        }
                        callback(response);
                    });
            }
 
        function SetCredentials(username, password) {
            $rootScope.globals = {
                currentUser: {
                    username: username,
                    password: password
                }
            };
            console.log('currentUser: username:' + $rootScope.globals.currentUser.username + 'pass:' + $rootScope.globals.currentUser.password
                    );
            $cookies.putObject('globals', $rootScope.globals);
        }
 
        function ClearCredentials() {
            $cookies.remove('globals');
        }
    }
 
})();