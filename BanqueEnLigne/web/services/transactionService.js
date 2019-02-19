
var app = angular.module('Banque');

app.service('transactionService', ['$q', '$http', function ($q, $http) {

        var service = {};

        service.session = null;
        this.GetTransactions = function (numeroCompte) {

            var deferred = $q.defer();
            $http({
                url: '/BanqueEnLigne/detailscompte.htm',
                method: "GET",
                params: {
                    'compte': numeroCompte
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
    }]);
