var app = angular.module('Banque');
app.controller('ConnexionConseillerController', ['$scope', '$location', '$window', 'connexionService', function ($scope, $location, $window, connexionService) {
        $scope.erreur;
        $scope.client;
        $scope.init = function () {
            $scope.erreur = false;
            $scope.client = false;
        }
        $scope.init();
        $scope.goClient = function () {
            $location.url('/connexion');
        };
        $scope.connexion = function () {
            console.log('controlleur connexion');
            connexionService.connexionConseiller($scope.identifiant, $scope.password).then(
                    function (user) {
                        if (user !== null) {
                            console.log(user);
                            $location.path('/accueilConseiller').search({information: user});
                        }
                    }

            ).catch(
                    function (result) {
                        $scope.erreur = true
                    }
            )
        };
    }
]);
