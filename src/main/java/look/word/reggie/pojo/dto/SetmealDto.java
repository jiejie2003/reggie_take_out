package look.word.reggie.pojo.dto;

import lombok.Data;
import look.word.reggie.pojo.entity.Setmeal;
import look.word.reggie.pojo.entity.SetmealDish;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;//套餐关联的菜品集合

    private String categoryName;//分类名称
}
