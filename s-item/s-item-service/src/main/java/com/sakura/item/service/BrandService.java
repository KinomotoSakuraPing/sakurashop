package com.sakura.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sakura.common.PageResult;
import com.sakura.item.mapper.BrandMapper;
import com.sakura.item.po.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/14 10:40
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name", "%" + key + "%")
                    .orEqualTo("letter", key);
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo);
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        // 新增品牌信息
        this.brandMapper.insertSelective(brand);
        // 新增品牌和分类中间表
        cids.forEach(cid->brandMapper.insertCategoryBrand(cid,brand.getId()));
    }

    /**
     * 删除品牌
     * @param id
     * @param
     */
    @Transactional
    public int deleteBrand(Long id) {
        // 新增品牌信息
        return this.brandMapper.deleteByPrimaryKey(id);
        // 新增品牌和分类中间表
    }/**
     * 品牌
     * @param
     * @return
     */
    public List<Brand> selectAll() {
        // 新增品牌信息
        return this.brandMapper.selectAll();
        // 新增品牌和分类中间表
    }
}
