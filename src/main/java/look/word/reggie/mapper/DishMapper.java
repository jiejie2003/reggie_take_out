package look.word.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import look.word.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
