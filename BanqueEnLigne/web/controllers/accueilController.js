var app = angular.module('Banque');
app.controller('AccueilController', ['$scope', '$location', '$window', 'connexionService', function ($scope, $location, $window, connexionService) {
        $scope.GoCompte = function () {
            console.log("$location");
            console.log($location);
            $location.path('/comptes');
        };
        $scope.Deconnexion = function () {
            connexionService.deconnexion().then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $location.path('/accueil');
                        }
                    }

            )
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
