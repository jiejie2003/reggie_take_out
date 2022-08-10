package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import look.word.reggie.common.CustomException;
import look.word.reggie.pojo.dto.DishDto;
import look.word.reggie.pojo.entity.Dish;
import look.word.reggie.mapper.DishMapper;
import look.word.reggie.pojo.entity.DishFlavor;
import look.word.reggie.service.DishFlavorService;
import look.word.reggie.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Resource
    private DishFlavorService dishFlavorService;

    @Override
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        this.save(dishDto);

        // 1、插入口味
        Long dishId = dishDto.getId();//菜品id
        //菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);// 绑定口味菜品关系
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public DishDto getByIdWithFlavor(Long id) {
        Dish byId = this.getById(id);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(byId, dishDto);

        //查询当前菜品对应的口味信息，从dish_flavor表查询
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, id);
        List<DishFlavor> list = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(list);
        return dishDto;
    }

    @Override
    public void updateWithFlavor(DishDto dishDto) {
        try {
            // 更新菜品表
            this.updateById(dishDto);
            // 更新菜品口味表
            //清理当前菜品对应口味数据---dish_flavor表的delete操作
            LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
            dishFlavorService.remove(queryWrapper);

            //添加当前提交过来的口味数据---dish_flavor表的insert操作
            List<DishFlavor> flavors = dishDto.getFlavors();
            flavors = flavors.stream().map((item) -> {
                item.setDishId(dishDto.getId());
                return item;
            }).collect(Collectors.toList());
            dishFlavorService.saveBatch(flavors);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改失败,请重试");
        }
    }
}
