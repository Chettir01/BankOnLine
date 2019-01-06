var app = angular.module('Banque');
app.controller('DetailsCompteController', ['$scope', '$location', '$window','$routeParams', 'transactionService', function ($scope, $routeParams, $location, $window, transactionService) {
        $scope.numero = $routeParams.search()['compte'];
        $scope.comptesClient;
        $scope.init = function () {
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
    }
]);