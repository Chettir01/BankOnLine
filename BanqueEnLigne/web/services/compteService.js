
var app = angular.module('Banque');

app.service('compteService', ['$q', '$http', function ($q, $http) {

        var service = {};

        this.getComptes = function () {

            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/allcomptes.htm',
                method: "GET",
                data: {
                }
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
    }]);