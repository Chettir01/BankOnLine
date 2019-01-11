var app = angular.module('Banque');
app.controller('AccueilConseillerController', ['$scope', '$location', '$window', 'compteService', function ($scope, $location, $window, compteService) {
        $scope.visible = false;
        $scope.information;
        $scope.goClient = function () {
            $location.url('/connexion');
        };
        $scope.init = function () {
            console.log($location);
            $scope.information = $location.search().information;
        }
        $scope.init();
        $scope.connexion = function () {
            console.log('controlleur connexion');
            connexionService.connexion($scope.identifiant, $scope.password).then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $scope.information = result;
                            $location.path('/accueilConseiller').search({compte: numero});
                        }
                    }

            ).catch(
                    $scope.visible = true
                    )
        };
    }
]);
