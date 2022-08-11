package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import look.word.reggie.mapper.ShoppingCartMapper;
import look.word.reggie.pojo.entity.ShoppingCart;
import look.word.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
    @Override
    public ShoppingCart getCartInfoByUserId(Long currentUserId, ShoppingCart shoppingCart) {
        shoppingCart.setUserId(currentUserId);
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,currentUserId);

        // 不是套餐就是单独的菜品
        Long dishId = shoppingCart.getDishId();
        if (dishId!=null){
            queryWrapper.eq(ShoppingCart::getDishId,dishId);
        }else {
            queryWrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());
        }
        return baseMapper.selectOne(queryWrapper);
    }
}
