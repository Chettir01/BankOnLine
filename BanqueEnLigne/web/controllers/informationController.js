var app = angular.module('Banque');
app.controller('InformationController', ['$scope', '$location', 'informationService', function ($scope, $location, informationService) {
        $scope.information;
        $scope.type;
        $scope.init = function () {
            informationService.GetInformation().then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            if (result.nomentreprise === undefined) {
                                $scope.type = "PARTICULIER";
                            } else {
                                $scope.type = "PROFESSIONEL";
                            }
                            $scope.information = result;
                        }
                    }
            )
        };
        $scope.ModifierInformation = function () {
            informationService.Changerinformation($scope.information,$scope.type).then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $scope.information = result;
                        }
                    }
            )
        };
        $scope.init();
        $scope.GoDetailsCompte = function (numero) {
            $location.path('/detailsCompte').search({compte: numero});
        }
        $scope.GoAccueil = function () {
            $location.path('/accueil');
        };

    }
]);

