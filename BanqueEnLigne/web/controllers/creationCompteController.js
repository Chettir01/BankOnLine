var app = angular.module('Banque');
app.controller('CreationCompteController', ['$scope', '$location', '$window', 'compteService', function ($scope, $location, $window, compteService) {
        $scope.listeTypeCompte;
        $scope.typeCompte;
        $scope.init = function () {
            $scope.success = false;
            $scope.erreur = false;
            $scope.incomplet = false;
            compteService.GetTypeCompte().then(
                    function (result) {
                        console.log(result);
                        $scope.listeTypeCompte = result;
                    }

            )
        };
        $scope.init();
        $scope.CreationCompte = function () {

                compteService.CreateCompte($scope.typeCompte).then(
                        function (result) {
                            console.log(result);
                            alert('Votre nouveau compte est créé et en attente de validation.')
                        }
                ).catch(
                        function (result) {
                           alert('Création impossible')
                        }

                );
        }
    }
]);
