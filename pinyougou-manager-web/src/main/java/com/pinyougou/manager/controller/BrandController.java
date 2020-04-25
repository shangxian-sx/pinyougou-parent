package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author sx
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    /**
     *查询品牌列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    /**
     *
     * @param page 当前页
     * @param size 每页行数
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page,int size){
        return brandService.findPage(page,size);
    }


    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    /**
     * 查找单一品牌信息
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(long id){
        return brandService.findOne(id);
    }


    /**
     * 修改单一品牌方法
     * @param brand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    /**
     * 多选删除品牌
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    /**
     *
     * @param brand 品牌
     * @param page  当前页
     * @param rows  每页显示行数
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand,int page,int rows){
        return brandService.findPage(brand,page,rows);
    }


    /**
     * 引入TypeTemplate中的品牌下拉列表
     * 列表数据
     * @return map
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}
