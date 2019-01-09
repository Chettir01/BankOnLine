var app = angular.module('Banque');
app.controller('CreationCompteController', ['$scope', '$location', '$window', 'compteService', function ($scope, $location, $window, compteService) {
        $scope.listeTypeCompte;
        $scope.typeCompte;
        $scope.init = function () {
            compteService.GetTypeCompte().then(
                    function (result) {
                        console.log(result);
                        $scope.listeTypeCompte = result;
                    }
            )
        };
        $scope.init();

        $scope.CreationCompte = function () {
            compteService.CreateCompte($scope.typeCompte).then(
                    function (result) {
                        console.log(result);
                    }
            )
        }

    }
]);
