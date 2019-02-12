var app = angular.module('Banque');
app.controller('InformationController', ['$filter', '$scope', '$location', 'informationService', function ($filter, $scope, $location, informationService) {
        $scope.init = function () {
            informationService.GetInformation().then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $scope.information = result;
                            if (result.nomentreprise === undefined) {
                                $scope.type = "PARTICULIER";
                                console.log("Avant : ");
                                console.log($scope.information.dateNaissance);
                                $scope.information.dateNaissance = new Date($scope.information.dateNaissance);
                                console.log("Aprés : ");
                                console.log($scope.information.dateNaissance);
                            } else {
                                $scope.type = "PROFESSIONEL";
                            }


                        }
                    }
            )
        };
        $scope.init();
        $scope.ModifierInformation = function () {
            /* console.log($scope);
             var nouvelle = $scope.annee + "-";
             if ($scope.mois < 10) {
             nouvelle += '0';
             }
             nouvelle += $scope.mois + "-";
             if ($scope.jour < 10) {
             nouvelle += '0';
             }
             nouvelle += $scope.jour;
             console.log('Nouvelle : ' + nouvelle);
             $scope.information.dateNaissance = nouvelle;
             console.log("new");
             console.log($scope.information);*/
            console.log($scope.information.dateNaissance);
            informationService.Changerinformation($scope.information, $scope.type).then(
                    function (result) {
                        if (result !== null) {
                            console.log(result);
                            $location.path("/accueil");
                            alert('Modification effectué.')
                        }
                    }
            ).catch(
                        function (result) {
                           alert('Un probléme est survenue lors de la sauvegarde des modification')
                        }

                );
        };

        $scope.GoDetailsCompte = function (numero) {
            $location.path('/detailsCompte').search({compte: numero});
        }
        $scope.GoAccueil = function () {
            $location.path('/accueil');
        };

    }
]);

