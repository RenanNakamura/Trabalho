module = angular.module("Disciplina", []);

module.controller("ManterDisciplina", ["$scope","$http", ManterDisciplina]);


function ManterDisciplina($scope,$http) {
    
    $scope.iniciar = funcaoIniciar;
    $scope.salvar = funcaoSalvar;
    $scope.excluir = funcaoExcluir;
    $scope.editar = funcaoEditar;
    
    $scope.disciplinas = [];
    $scope.disciplina = {};
    $scope.isNovo = true;
    
    function funcaoEditar(aValor) {
        $scope.disciplina = angular.copy(aValor);
        $scope.isNovo = false;
    }

    
    function funcaoExcluir(aValor) {
        $http.delete("/Disciplinas/" + aValor.id).success(onSuccess).error(onError);
        
        function onSuccess(data, status){
            console.log("entrou!");
            funcaoCarregar();
        }
        
        function onError(data, status){
            alert("Deu erro!" + data);
        }
     }
    
    function funcaoSalvar() {
        if($scope.isNovo){
            $http.post("/Disciplinas", $scope.disciplina).success(onSuccess).error(onError);
        }else{
            $http.put("/Disciplinas", $scope.disciplina).success(onSuccess).error(onError);
        }
        
        function onSuccess(data, status){
            funcaoCarregar();
            $scope.disciplina = {};
            $scope.isNovo = true;
        }
        
        function onError(data, status){
            alert("Deu erro!" + data);
        }
    }
    
    function funcaoCarregar() {
        $http.get("/Disciplinas").success(onSuccess).error(onError);
        
        function onSuccess(data, status) {
            $scope.disciplinas = data;       
            console.log(data);
        }
        function onError(data, status) {
            alert("Deu erro: " + data);
        }
    }
    
    function funcaoIniciar() {
        funcaoCarregar();
    }
        
}


