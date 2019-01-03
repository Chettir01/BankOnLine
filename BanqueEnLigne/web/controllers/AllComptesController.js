var app = angular.module('Banque');
app.controller('AllComptesController', ['$scope', '$location', '$window', 'compteService', function ($scope, $location, $window, compteService) {
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
        $scope.GoDetailsCompte= function(numeroCompte){
            $location.path('/detailsCompte/'+numeroCompte);
        }
        $scope.GoAccueil = function () {
            $location.path('/accueil');
        };
        $scope.Deconnexion = function () {
            $location.path('/connexion');
        };

    }
]);


