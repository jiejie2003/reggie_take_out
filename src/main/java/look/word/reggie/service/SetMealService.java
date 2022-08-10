package look.word.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import look.word.reggie.pojo.dto.SetmealDto;
import look.word.reggie.pojo.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     */
    void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     */
    void removeWithDish(List<Long> ids);
}
