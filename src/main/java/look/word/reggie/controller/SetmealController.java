package look.word.reggie.controller;

import lombok.extern.slf4j.Slf4j;
import look.word.reggie.common.R;
import look.word.reggie.common.aop.LogAnnotation;
import look.word.reggie.pojo.dto.SetmealDto;
import look.word.reggie.service.SetmealDishService;
import look.word.reggie.service.SetmealService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 套餐管理
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {
    @Resource
    private SetmealService setmealService;
    @Resource
    private SetmealDishService setmealDishService;

    @LogAnnotation(module = "套餐管理", operation = "添加套餐")
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto) {
        setmealService.saveWithDish(setmealDto);

        return R.success("新增套餐成功");
    }
}
