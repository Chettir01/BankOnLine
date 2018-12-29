var app = angular.module('Banque', []);
app.controller('indexController', ['$scope', '$location', '$window', function ($scope, $location, $window) {
        $scope.goClient = function () {
            $location.url('/connexion');
            ;
        };
        $scope.endroit = $window.location.host;
    }]);