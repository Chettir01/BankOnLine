var app = angular.module('Banque');
app.controller('VirementController', ['$scope', '$location', '$window', '$routeParams', 'virementService', function ($scope, $location, $routeParams, $window, virementService) {
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
                            function (result) {
                                alert('Le virement n\'a pas être effectué')
                            }
                    )

        }
        $scope.Deconnexion = function () {
            $location.path('/connexion');
        };

    }
]);