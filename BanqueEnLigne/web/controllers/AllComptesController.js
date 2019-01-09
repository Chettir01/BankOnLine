var app = angular.module('Banque');
app.controller('AllComptesController', ['$scope', '$location', '$window', 'compteService', function ($scope, $location, $window, compteService) {
        $scope.comptesClient;
        $scope.init = function () {
          //  if ($scope.comptesClient === undefined) {
                compteService.getComptes().then(
                        function (result) {
                            if (result !== null) {
                                console.log(result);
                                $scope.comptesClient = result;
                            }
                        }
                )
          //  }
        };
        $scope.init();
        $scope.GoDetailsCompte = function (numero) {
            $location.path('/detailsCompte').search({compte: numero});
        }
        $scope.GoAccueil = function () {
            $location.path('/accueil');
        };
        
        $scope.GoPartager = function (numero) {
            $location.path('/ajoutCompte').search({compte: numero});
        };
        

    }
]);


