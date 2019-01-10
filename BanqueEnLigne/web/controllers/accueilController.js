var app = angular.module('Banque');
app.controller('AccueilController', ['$scope', '$location', '$window', 'connexionService', function ($scope, $location, $window, connexionService) {
        $scope.contenu;
        $scope.init= function(){
            $scope.contenu = "messageBienvenu.html";
        }
        $scope.init();
        $scope.GoCompte = function () {
            $scope.contenu = "allComptes.html";
        };
        $scope.Deconnexion = function () {
            connexionService.deconnexion().then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $location.path('/connexion');
                        }
                    }

            )
            $location.path('/connexion');
        };
        $scope.GoInformation = function () {
            $scope.contenu = "information.html";
        };
        $scope.GoCreation = function () {
            $scope.contenu = "creationCompte.html";
        };

    }
]);
