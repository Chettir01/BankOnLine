var app = angular.module('Banque');
app.controller('AllComptesController', ['$scope', '$location', '$window','$routeParams', 'compteService', function ($scope, $location,$routeParams, $window, compteService) {
        $scope.comptesClient;
        $scope.init = function () {
            compteService.getComptes().then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $scope.comptesClient=result;
                        }
                    }
            )
        };
        $scope.init();
        $scope.GoDetailsCompte= function(numero){
            $location.path('/detailsCompte').search({compte:numero});
        }
        $scope.GoAccueil = function () {
            $location.path('/accueil');
        };
        $scope.Deconnexion = function () {
            $location.path('/connexion');
        };

    }
]);


