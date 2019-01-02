var app = angular.module('Banque', ['ngRoute']);
app.config(function ($routeProvider) {
    $routeProvider
            .when('/connexion', {

                templateUrl: 'connexion.html',
                controller: 'ConnexionController',
                controllerAs: 'vm'
            })
            .when('/comptes', {

                templateUrl: 'allComptes.html',
                controller: 'AllComptesController',
                controllerAs: 'vm'
            })
            .when('/accueil', {
                templateUrl: 'accueil.html',
                controller: 'AccueilController',
                controllerAs: 'vm'
            })
            .otherwise({redirectTo: '/connexion'});
}); 