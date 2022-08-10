package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import look.word.reggie.common.CustomException;
import look.word.reggie.pojo.entity.Category;
import look.word.reggie.pojo.entity.Dish;
import look.word.reggie.pojo.entity.Setmeal;
import look.word.reggie.mapper.CategoryMapper;
import look.word.reggie.service.CategoryService;
import look.word.reggie.service.DishService;
import look.word.reggie.service.SetMealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Resource
    private DishService dishService;

    @Resource
    private SetMealService setMealService;

    @Override
    public void remove(Long id) {
        // 查询该分类是否还有套餐和菜品
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        //如果已经关联，抛出一个业务异常
        if (count1 > 0) {
            throw new CustomException("当前分类下关联了菜品，不能删除");//已经关联菜品，抛出一个业务异常
        }

        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setMealService.count(queryWrapper);
        //如果已经关联，抛出一个业务异常
        if (count2 > 0) {
            throw new CustomException("当前分类下关联了套餐，不能删除");//已经关联菜品，抛出一个业务异常
        }

        removeById(id);
    }
}
