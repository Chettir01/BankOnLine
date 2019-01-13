var app = angular.module('Banque');
app.controller('AccueilConseillerController', ['$scope', '$location', '$window', 'connexionService', 'compteService', function ($scope, $location, $window, connexionService, compteService) {
        $scope.visible = false;
        $scope.information;
        $scope.agiosError = false;
        $scope.agios = function () {
            compteService.Agios().then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $scope.information = result;
                            $scope.agiosError = false;
                        }
                    }
            ).catch(
                    $scope.agiosError = true
                    )
        };
        $scope.valider = function (numero) {
            compteService.Valider(numero).then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $scope.information = result;
                        }
                    }
            )/*.catch(
                    $location.url('/connexionConseiller')
                    )*/

        };
        $scope.invalider = function(numero){
            compteService.Invalider(numero).then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $scope.information = result;
                        }
                    }
            )
        }
        $scope.init = function () {
            console.log($location);
            $scope.information = $location.search().information;
        };
        $scope.init();
        $scope.deconnexionConseiller = function () {
            connexionService.deconnexionConseiller().then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $location.url('/choixTypeConnexion');
                        }
                    }
            )
        };


    }
]);
