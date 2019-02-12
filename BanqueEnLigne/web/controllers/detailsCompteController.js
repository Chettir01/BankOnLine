var app = angular.module('Banque');
app.controller('DetailsCompteController', ['$scope', '$location', '$routeParams', 'transactionService', function ($scope, $routeParams, $location, transactionService) {

        $scope.GoVirement = function () {
            console.log("$location : ");
            console.log($location);
            console.log("$routeParams : ");
            console.log($routeParams);
            $routeParams.path("/virement");
        };
        $scope.numero = $routeParams.search()['compte'];
        $scope.init = function () {
            console.log($routeParams);
            console.log("Numero de compte : " + $routeParams.search().compte);
            transactionService.GetTransactions($scope.numero).then(
                    function (result) {
                        if (result !== null) {

                            console.log(result);
                            $scope.comptesClient = result;
                        }
                    }
            )
        };
        $scope.init();
        $scope.GoAccueil = function () {
            $routeParams.path("/accueil");
        };
    }
]);