package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @author sx
 */
public interface BrandService {
    /**
     * 查找所有品牌
     *
     * @return 查找结果
     */
    public List<TbBrand> findAll();

    /**
     * 品牌分页
     * @param pageNum 当前页面
     * @param pageSize 每页记录数
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);

    /**
     *  增加方法
     * @param brand
     */
    public void add(TbBrand brand);

    /**
     * 修改信息
     * @param brand
     */
    public void update(TbBrand brand);

    /**
     * 根据id查找实体单一品牌
     * @param id
     * @return
     */
    public TbBrand findOne(long id);

    /**
     * 多选删除品牌
     * @param ids
     */
    public void delete(long[] ids);

    /**
     * 品牌条件查询
     * @param brand 品牌列表
     * @param pageNum   当前页面
     * @param pageSize 每页记录数
     * @return
     */
    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);

    /**
     *  引入TypeTemplate中的品牌下拉列表
     * @return map
     */
    public List<Map> selectOptionList();
}
