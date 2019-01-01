var app = angular.module('Banque', ['ngRoute']);
app.config(function ($routeProvider) {
    $routeProvider
            .when('/connexion', {

                templateUrl: 'connexion.html',
                controller: 'ConnexionController',
                controllerAs: 'vm'
            })
            .when('/accueil', {
                templateUrl: 'accueil.html'
            })
            .otherwise({redirectTo: '/connexion'});
}); 