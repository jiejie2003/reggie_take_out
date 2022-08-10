package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import look.word.reggie.pojo.entity.Setmeal;
import look.word.reggie.mapper.SetMealMapper;
import look.word.reggie.service.SetMealService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SetMealServiceImpl extends ServiceImpl<SetMealMapper, Setmeal> implements SetMealService {
}
