
var app = angular.module('Banque');

app.service('virementService', ['$q', '$http', function ($q, $http) {

        var service = {};

        service.session = null;
        this.CreerVirement = function (montant,iban,compte) {

            var deferred = $q.defer();
            $http({
                url: 'http://localhost:8084/BanqueEnLigne/virement.htm',
                method: "POST",
                params: {
                    Montant: montant,
                    IBAN:iban,
                    compte:compte
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
