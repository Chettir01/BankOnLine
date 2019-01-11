var app = angular.module('Banque');
app.controller('ConnexionConseillerController', ['$scope', '$location', '$window', 'connexionService', function ($scope, $location, $window, connexionService) {
  $scope.visible = false;
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
                    $scope.visible = true
                    )
        };
    }
]);
