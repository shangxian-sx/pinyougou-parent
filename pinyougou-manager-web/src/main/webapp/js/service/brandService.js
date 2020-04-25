//品牌服务
app.service("brandService", function ($http) {
    //查询品牌列表
    this.findAll = function () {
        return $http.get('../brand/findAll.do');
    };
    //分页
    this.findPage = function (page, rows) {
        return $http.get("../brand/findPage.do?page=" + page + "&rows=" + rows);
    }
    //查询单一品牌id
    this.findOne = function (id) {
        return $http.get("../brand/findOne.do?id=" + id);
    }
    //增加
    this.add = function (entity) {
        return $http.post("../brand/add.do", entity);
    }
    //修改
    this.update = function (entity) {
        return $http.post("../brand/update.do", entity);
    }
    //删除
    this.dele=function (ids) {
        return $http.get("../brand/delete.do?ids=" + ids);
    }
    //条件查询
    this.search=function (page,rows,searchEntity) {
        return $http.post("../brand/search.do?page=" + page + "&rows=" + rows, searchEntity);
    }
    //引入TypeTemplate中的品牌下拉列表
    //列表数据
    this.selectOptionList=function () {
        return $http.get("../brand/selectOptionList.do");
    }



});