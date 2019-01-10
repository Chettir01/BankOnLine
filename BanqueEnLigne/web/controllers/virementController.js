var app = angular.module('Banque');
app.controller('VirementController', ['$scope', '$location', '$window', '$routeParams', 'virementService', function ($scope, $location, $routeParams, $window, virementService) {
        $scope.visible = false;
        $scope.GoDetailsCompte = function () {
            $location.path('/detailsCompte').search({compte: $location.search().compte});
        };
        $scope.AjouterVirement = function () {
            virementService.CreerVirement($scope.montant, $scope.iban, $location.search().compte).then(
                    function (result) {
                        console.log("resultat : " + result);
                        $location.path('/detailsCompte').search({compte: $location.search().compte});
                    }
            )
                    .catch(
                            $scope.visible = true
                            )

        }
        $scope.Deconnexion = function () {
            $location.path('/connexion');
        };

    }
]);