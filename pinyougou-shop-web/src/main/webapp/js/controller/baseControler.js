app.controller("baseController",function ($scope) {
//重新加载列表，数据（刷新列表）
    $scope.reloadList = function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);

    };

    //分页控件配置 currentionConf:当前页 ； totalitems：总记录页 ；  itemsPerpage ： 每页记录数 ； perPageOptions ： 分页选项 ； onChange ： 当页码变更时自动变更此方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    //用户勾选的集合
    $scope.selectIds = [];
    //用户勾选复选框
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
        }
    };
    //条件查询中定义searchEntity
    $scope.searchEntity = {};


    //提取json字符串数据中某个属性，返回拼接字符串 逗号分隔
    $scope.jsonToString=function(jsonString,key){
        var json=JSON.parse(jsonString);//将json字符串转换为json对象
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=","
            }
            value+=json[i][key];
        }
        return value;
    }

});