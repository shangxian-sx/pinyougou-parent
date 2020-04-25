package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author sx
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;

    /**
     * 查找所有品牌
     *
     * @return 查找结果
     */
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    /**
     * 品牌分页
     *
     * @param pageNum  当前页面
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //分页
        PageHelper.startPage(pageNum,pageSize);

        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);

        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 增加方法
     *
     * @param brand
     */
    @Override
    public void add(TbBrand brand) {
        brandMapper.insert(brand);
    }

    /**
     * 修改信息
     *
     * @param brand
     */
    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    /**
     * 根据id查找实体brand
     *
     * @param id
     * @return
     */
    @Override
    public TbBrand findOne(long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 多选删除品牌
     *
     * @param ids
     */
    @Override
    public void delete(long[] ids) {
        for(long id:ids){
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 品牌条件查询
     *
     * @param brand    品牌列表
     * @param pageNum  当前页面
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        //分页
        PageHelper.startPage(pageNum,pageSize);

        TbBrandExample example = new TbBrandExample();

        TbBrandExample.Criteria criteria = example.createCriteria();

        if(brand!=null){
            if(brand.getName()!=null && brand.getName().length()>0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
            }
        }


        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);

        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 引入TypeTemplate中的品牌下拉列表
     * 列表数据
     * @return map
     */
    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }

}
