//品牌控制
app.controller("brandController", function ($scope, $http,brandService,$controller) {

    //控制器继承baseController.js
    $controller("baseController",{$scope:$scope});

    //查询品牌列表
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        )
    }






    //分页
    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };




    //查询单一品牌id
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };
    //修改保存
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id != null) {
            object = brandService.update($scope.entity);
        } else {
            object = brandService.add($scope.entity);
        }
        object.success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }



    //删除品牌
    $scope.dele = function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                } else {
                    alert(response.message);
                }
            }
        );
    }

    //条件查询
    $scope.search = function (page, rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }
});