var app = angular.module('Banque');
app.controller('AccueilController', ['$scope', '$location', '$window', 'connexionService', function ($scope, $location, $window, connexionService) {
        $scope.GoCompte = function () {
            $location.path('/comptes');
        };
        $scope.Deconnexion = function () {
            $location.path('/connexion');
        };
        $scope.GoInformation = function () {
            $location.path('/information');
        };
        $scope.GoCreation = function () {
            $location.path('/creation');
        };
        
    }
]);
