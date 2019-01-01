var app = angular.module('Banque');
app.controller('AccueilController', ['$scope', '$location', '$window', 'connexionService', function ($scope, $location, $window, connexionService) {
        $scope.goCompte = function () {
            $location.url('/comptes');
        };
        
    }
]);
