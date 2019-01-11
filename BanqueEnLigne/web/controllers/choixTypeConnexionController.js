var app = angular.module('Banque');
app.controller('choixTypeConnexionController', ['$scope', '$location', '$window', 'compteService', function ($scope, $location, $window, compteService) {
        $scope.GoConseiller = function () {
            $location.path('/connexionConseiller');
        };

        $scope.GoClient = function () {
            $location.path('/connexion');
        };


    }
]);
