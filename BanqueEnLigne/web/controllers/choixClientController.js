var app = angular.module('Banque');
app.controller('ChoixClientController', ['$scope', '$location', function ($scope, $location) {
        $scope.goCreationCompte = function (typeClient) {
            $location.url('/creationClient').search({type: typeClient});
        };
    }
]);
