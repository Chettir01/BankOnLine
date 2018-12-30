
angular.module('Banque', [])
        .controller('connexionController', ['$scope', '$location', '$window','connexionService', function ($scope, $location, $window,connexionService) {
        $scope.goClient = function () {
        $location.url('/connexion');
        };
        $scope.connexion = function () {
            console.log('controlleur connexion');
            connexionService.connexion($scope.identifiant, $scope.password).then(
                    function (user) {
                        if (user !== null) {
                      
                            $location.path('/accueil');
                        }
                    }
        
        )};
   }
   ]);
