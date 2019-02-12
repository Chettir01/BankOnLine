var app = angular.module('Banque');
app.controller('ConnexionController', ['$scope', '$location', '$window', 'connexionService', 'compteService', function ($scope, $location, $window, connexionService, compteService) {
        $scope.erreur;
        $scope.goChoixClient = function () {
            $location.url('/choixClient');
        };
        $scope.connexion = function () {
            console.log('controlleur connexion');
            console.log(connexionService);
            connexionService.connexion($scope.identifiant, $scope.password).then(
                    function (user) {
                        if (user !== null) {
                            console.log(user);
                            $location.path('/accueil');
                        }
                    }

            ).catch(
                    $scope.erreur = true
                    )
        };
        $scope.creationCompte = function () {
            compteService.CreateCompte().then(
                    function (user) {
                        if (user !== null) {
                            console.log(user);
                            $location.path('/accueil').search({compte: numero});
                        }
                    }
            )
        };
    }
]);
