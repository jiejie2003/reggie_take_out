package look.word.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import look.word.reggie.pojo.entity.ShoppingCart;

public interface ShoppingCartService extends IService<ShoppingCart> {
    /**
     * 根据用户id查询用户购物车数据
     */
    ShoppingCart getCartInfoByUserId(Long currentUserId, ShoppingCart shoppingCart);

}
