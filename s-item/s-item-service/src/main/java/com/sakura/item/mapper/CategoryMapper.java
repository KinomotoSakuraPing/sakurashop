package com.sakura.item.mapper;

import com.sakura.item.po.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/7 11:35
 */
public interface CategoryMapper extends Mapper<Category> {
    /**
     * 根据品牌id查询商品分类
     * @param bid
     * @return
     */
    @Select("SELECT * FROM tb_category WHERE id IN (SELECT category_id FROM tb_category_brand WHERE brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);
}
