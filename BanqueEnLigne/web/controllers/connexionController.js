(function () {
    'use strict';

    angular
            .module('app')
            .controller('connexionController', connexionController);

    connexionController.$inject = ['UserService','$scope', '$rootScope','$route', '$location', 'AuthenticationService', 'FlashService', 'ConnexionService'];
    function connexionController(UserService,$scope, $rootScope, $location, AuthenticationService, FlashService, ConnexionService,$route) {

        var vm = this;
        vm.user = null;


        initController();
        $scope.password="";
        $scope.identifiant="";
         function connexion () {
            Console.log("ok connexion");
            ConnexionService.connexion($scope.identifiant, $scope.password)
                    .then(function (user) {
                        if (user !== null) {
                            vm.user = user;
                            
                            $location.path('/accueil');;
                        }
                        

                    });

        }


        function initController() {

        }



        function loadCurrentUser() {
            UserService.GetByName($rootScope.globals.currentUser.username)
                    .then(function (user) {
                        vm.user = user;
                    });
        }

        function loadAllUsers() {
            UserService.GetAll($rootScope.globals.currentUser.username)
                    .then(function (users) {
                        vm.allUsers = users;
                    });
        }

        function loadAllFriends() {
            UserService.GetAllFriends($rootScope.globals.currentUser.username)
                    .then(function (users) {
                        vm.allFriends = users;
                    });
        }

        function deleteUser(id) {

            UserService.Delete(id)
                    .then(function () {
                        AuthenticationService.ClearCredentials();
                        FlashService.Success('Compte supprimé', true);
                        $location.path('/login');
                    });
        }

        function addFriend(id) {
            UserService.AddFriend($rootScope.globals.currentUser.username, id)
                    .then(function () {
                        loadAllFriends();
                    });
        }

        //********
        // Todo
        //********
        function deleteFriend(id) {

        }
    }

})();
