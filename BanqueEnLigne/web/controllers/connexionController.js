var app = angular.module('Banque');
app.controller('ConnexionController', ['$scope', '$location', '$window', 'connexionService', function ($scope, $location, $window, connexionService) {
        $scope.visible = false;
        $scope.goClient = function () {
            $location.url('/connexion');
        };
        $scope.connexion = function () {
            console.log('controlleur connexion');
            connexionService.connexion($scope.identifiant, $scope.password).then(
                    function (user) {
                        if (user !== null) {
                            console.log(user);
                            $location.path('/accueil').search({compte: numero});
                        }
                    }

            ).catch(
                    $scope.visible = true
                    )
        };
    }
]);
