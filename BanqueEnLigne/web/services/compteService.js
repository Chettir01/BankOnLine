
var app = angular.module('Banque');

app.service('compteService', ['$q', '$http', function ($q, $http) {

        var service = {};

        this.getComptes = function () {

            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/allcomptes.htm',
                method: "GET"
            }).then(
                    function (response) {
                        var comptes = response.data;
                        deferred.resolve(comptes);
                    },
                    function (errResponse) {
                        deferred.reject(errResponse);
                    }
            );
            return deferred.promise;
        };

        this.GetTypeCompte = function () {
            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/creationcompte.htm',
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

        this.CreateCompte = function (typeCompte) {
            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/creationcompte.htm',
                method: "POST",
                params: {
                    'type': typeCompte
                }
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

        this.PartagerCompte = function (compte, login) {
            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/ajoutcompteclient.htm',
                method: "POST",
                params: {
                    compte: compte,
                    login: login
                }
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
        
        this.Agios = function () {
            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/agios.htm',
                method: "POST"
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

        this.Valider=function(numero){
            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/validationcompte.htm',
                method: "POST",
                params: {
                    id: numero
                }
            }).then(
                    function (response) {
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                        deferred.reject(errResponse);
                    }
            );
            return deferred.promise;
        }
        
        this.Invalider=function(numero){
            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/cloturecompte.htm',
                method: "POST",
                params: {
                    id: numero
                }
            }).then(
                    function (response) {
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                        deferred.reject(errResponse);
                    }
            );
            return deferred.promise;
        }

    }]);