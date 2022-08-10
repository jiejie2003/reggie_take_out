package look.word.reggie.pojo.dto;

import lombok.Data;
import look.word.reggie.pojo.entity.Dish;
import look.word.reggie.pojo.entity.DishFlavor;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();

    /**
     * 菜品分类名称
     */
    private String categoryName;

    private Integer copies;
}
