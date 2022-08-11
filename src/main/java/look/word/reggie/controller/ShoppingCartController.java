package look.word.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.sun.prism.impl.BaseContext;
import lombok.extern.slf4j.Slf4j;
import look.word.reggie.common.R;
import look.word.reggie.common.aop.LogAnnotation;
import look.word.reggie.pojo.entity.ShoppingCart;
import look.word.reggie.service.ShoppingCartService;
import look.word.reggie.service.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 购物车
 */
@Slf4j
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     * A. 获取当前登录用户，为购物车对象赋值
     *
     * B. 根据当前登录用户ID 及 本次添加的菜品ID/套餐ID，查询购物车数据是否存在
     *
     * C. 如果已经存在，就在原来数量基础上加1
     *
     * D. 如果不存在，则添加到购物车，数量默认就是1
     */
    @LogAnnotation(module = "购物车",operation = "添加菜品或者套餐到购物车")
    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart){
        // 当前用户
        Long currentUserId = UserThreadLocal.getCurrentId();

        ShoppingCart cartServiceOne = shoppingCartService.getCartInfoByUserId(currentUserId,shoppingCart);
        // 不存在新增，存在 在原来的基础上加1
        if (cartServiceOne==null){
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
            cartServiceOne = shoppingCart;
        }else {
            cartServiceOne.setNumber(cartServiceOne.getNumber()+1);
            shoppingCartService.updateById(cartServiceOne);
        }

        return R.success(cartServiceOne);
    }

    /**
     * 减少数量
     */
    @PostMapping("sub")
    public R<ShoppingCart> sub(@RequestBody ShoppingCart shoppingCart){

        // 当前用户
        Long currentUserId = UserThreadLocal.getCurrentId();
        ShoppingCart cartServiceOne= shoppingCartService.getCartInfoByUserId(currentUserId,shoppingCart);

        // 不存在新增，存在 在原来的基础上加1
        if (cartServiceOne==null){
            return R.error("购物车没有数据");
        }else {
            cartServiceOne.setNumber(cartServiceOne.getNumber()-1);
            shoppingCartService.updateById(cartServiceOne);
        }
        return R.success(cartServiceOne);

    }
    /**
     * 查看购物车
     * @return
     */
    @GetMapping("/list")
    public R<List<ShoppingCart>> list(){
        Long currentUserId = UserThreadLocal.getCurrentId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,currentUserId);
        queryWrapper.orderByDesc(ShoppingCart::getCreateTime);

        return R.success(shoppingCartService.list(queryWrapper));
    }

    /**
     * 清空购物车
     * @return
     */
    @DeleteMapping("/clean")
    public R<String> clean(){
        //SQL:delete from shopping_cart where user_id = ?
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, UserThreadLocal.getCurrentId());

        shoppingCartService.remove(queryWrapper);
        return R.success("清空购物车成功");
    }

 }
