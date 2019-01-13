var app = angular.module('Banque');
app.controller('CreationClientController', ['$scope', '$location', 'informationService', function ($scope, $location, informationService) {
        $scope.information;
        $scope.type;
        $scope.init = function () {
            $scope.type = $location.search().type;
        };
        $scope.CreationClient = function () {
            informationService.CreationClient($scope.information, $scope.type).then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $scope.information = result;
                            $location.path("/accueil");
                        }
                    }
            )
        };
        $scope.init();
    }
]);

