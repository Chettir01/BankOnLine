var app = angular.module('Banque');
app.controller('AjoutCompteClientController', ['$scope', '$location', '$routeParams', '$window', 'compteService', function ($scope, $location, $window, $routeParams, compteService) {
        $scope.login;

        $scope.init = function () {
            $scope.introuvable = false;
        }
        $scope.init();
        $scope.PartagerCompte = function () {
            console.log($routeParams);
            console.log($location);
            console.log('Compte : ' + $location.search().compte);
            compteService.PartagerCompte($location.search().compte, $scope.login).then(
                    function (user) {
                        if (user !== null) {
                            console.log(user);
                            $location.path('/accueil');
                            $scope.introuvable = false;
                            alert('Le compte a été partagé avec le client ' + $scope.login)
                        }
                    }

            )
                    .catch(
                            function (result) {
                                $scope.introuvable = true
                            }
                    )
        };
    }
]);

