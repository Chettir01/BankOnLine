
var app = angular.module('Banque');

app.factory('informationService', ['$q', '$http', function informationFactory($q, $http) {

        return {

            Changerinformation: function (client, type) {

                var deferred = $q.defer();
                $http({
                    url: 'http://localhost:8084/BanqueEnLigne/detailsclient.htm',
                    method: "POST",
                    params: {
                        login: client.login,
                        mdp: client.mdp,
                        adresse: client.adresse,
                        tel: client.tel,
                        date: client.dateNaissance,
                        prenom: client.prenom,
                        nom: client.nom,
                        civilite: client.civilite,
                        entreprise: client.nomentreprise,
                        type: type

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
            },

            /////////////////////////////////////////////////////////////
            GetInformation: function () {

                var deferred = $q.defer();
                $http({
                    url: 'http://localhost:8084/BanqueEnLigne/detailsclient.htm',
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
            },
            
            /////////////////////////////////////////////////////////////
            CreationClient: function (client, type) {

                var deferred = $q.defer();
                $http({
                    url: 'http://localhost:8084/BanqueEnLigne/creationclient.htm',
                    method: "POST",
                    params: {
                        login: client.login,
                        mdp: client.mdp,
                        adresse: client.adresse,
                        tel: client.tel,
                        date: client.datenaissance,
                        prenom: client.prenom,
                        nom: client.nom,
                        civilite: client.civilite,
                        entreprise: client.nomentreprise,
                        type: type
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
            
            

        }
    }]);

