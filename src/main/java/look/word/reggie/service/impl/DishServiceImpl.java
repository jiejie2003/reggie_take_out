package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import look.word.reggie.entity.Dish;
import look.word.reggie.mapper.DishMapper;
import look.word.reggie.service.DishService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
