(function () {
    'use strict';

    angular
        .module('Banque', ['ngRoute', 'ngCookies'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider'];
    function config($routeProvider) {
        $routeProvider
            .when('/index', {
                controller: 'controllers/indexController',
                templateUrl: 'Vue/index.html',
                controllerAs: 'vm'
            })

            .when('/connexion', {
                controller: 'connexionController',
                templateUrl: 'connexion.html',
                controllerAs: 'vm'
            })

            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register.html',
                controllerAs: 'vm'
            })

            .otherwise({ redirectTo: '/index' });
    }

    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    
    function run($rootScope, $location, $cookies, $http) {
        
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();