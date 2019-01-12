
var app = angular.module('Banque');

app.service('connexionService', ['$q', '$http', function ($q, $http) {

        var service = {};

        service.session;
        this.connexion = function (login, password) {

            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/connexion.htm',
                method: "POST",
                params: {
                    'identifient': login,
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

        this.deconnexion = function (login, password) {

            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/deconnexion.htm',
                method: "DELETE"
            }).then(
                    function (response) {
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                        deferred.reject(errResponse);
                    }
            );
            return deferred.promise;
        };
        
        this.connexionConseiller = function (login, password) {

            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/authconseiller.htm',
                method: "GET",
                params: {
                    'identifient': login,
                    'password': password
                }
            }).then(
                    function (response) {
                        var user = response.data;
                        service.currentUser = user;
                        deferred.resolve(user);
                    },
                    function (errResponse) {
                        deferred.reject(errResponse);
                    }
            );
            return deferred.promise;
        };
        
        this.deconnexionConseiller = function () {

            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/deconnexionconseiller.htm',
                method: "GET"
            }).then(
                    function (response) {
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                        deferred.reject(errResponse);
                    }
            );
            return deferred.promise;
        };
        
        
        
    }]);
