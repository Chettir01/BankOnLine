
var app = angular.module('Banque');

app.factory('informationService', ['$q', '$http', function informationFactory($q, $http) {

        return {

            Changerinformation: function (numeroClient) {

                var deferred = $q.defer();
                $http({
                    url: 'http://localhost:8084/BanqueEnLigne/detailsclient.htm',
                    method: "POST",
                    params: {
                        Montant: numeroClient
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
            }

        }
    }]);

