var app = angular.module('Banque');
app.controller('AllComptesController', ['$scope', '$location', '$window', 'compteService', function ($scope, $location, $window, compteService) {
        $scope.init = function () {
            compteService.getComptes().then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            return result;
                        }
                    }
            )
        };
        $scope.init();

        $scope.GoAccueil = function () {
            $location.path('/accueil');
        };
        $scope.Deconnexion = function () {
            $location.path('/connexion');
        };

    }
]);


