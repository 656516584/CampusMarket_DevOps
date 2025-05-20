package cn.service.impl;

import cn.mapper.CategoryMapper;
import cn.pojo.api.ApiResult;
import cn.pojo.api.Result;
import cn.pojo.dto.query.extend.CategoryQueryDto;
import cn.pojo.entity.Category;
import cn.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类别业务逻辑接口实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 新增
     *
     * @param category 参数
     * @return Result<String> 后台通用返回封装类
     */
    @Override
    public Result<String> save(Category category) {
        if (!StringUtils.hasText(category.getName())) {
            return ApiResult.error("商品分类名不能为空");
        }
        categoryMapper.save(category);
        return ApiResult.success("商品分类新增成功");
    }

    /**
     * 修改
     *
     * @param category 参数
     * @return Result<String> 后台通用返回封装类
     */
    @Override
    public Result<String> update(Category category) {
        categoryMapper.update(category);
        return ApiResult.success("商品分类修改成功");
    }

    /**
     * 删除
     *
     * @param ids 待删除ID集合
     * @return Result<String> 后台通用返回封装类
     */
    @Override
    public Result<String> batchDelete(List<Integer> ids) {
        categoryMapper.batchDelete(ids);
        return ApiResult.success("商品分类删除成功");
    }

    /**
     * 查询
     *
     * @param categoryQueryDto 查询参数
     * @return Result<List < Category>> 后台通用返回封装类
     */
    @Override
    public Result<List<Category>> query(CategoryQueryDto categoryQueryDto) {
        int totalCount = categoryMapper.queryCount(categoryQueryDto);
        List<Category> categoryList = categoryMapper.query(categoryQueryDto);
        return ApiResult.success(categoryList, totalCount);
    }
}