var app = angular.module('Banque', ['ngRoute']);
app.config(['$routeProvider', function ($routeProvider) {
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
                .when('/detailsCompte', {
                    templateUrl: 'detailsCompte.html',
                    controller: 'DetailsCompteController',
                    controllerAs: 'vm'
                })
                .when('/virement', {
                    templateUrl: 'virement.html',
                    controller: 'VirementController',
                    controllerAs: 'vm'
                })
                .when('/information', {
                    templateUrl: 'information.html',
                    controller: 'InformationController',
                    controllerAs: 'vm'
                })
                .when('/creationCompte', {
                    templateUrl: 'creationCompte.html',
                    controller: 'CreationCompteController',
                    controllerAs: 'vm'
                })
                .when('/ajoutCompte', {
                    templateUrl: 'ajoutCompteClient.html',
                    controller: 'AjoutCompteClientController',
                    controllerAs: 'vm'
                })
                .otherwise({redirectTo: '/connexion'});
    }]); 