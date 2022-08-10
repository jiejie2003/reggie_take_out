package look.word.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import look.word.reggie.pojo.dto.SetmealDto;
import look.word.reggie.pojo.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {
    void saveWithDish(SetmealDto setmealDto);
}
