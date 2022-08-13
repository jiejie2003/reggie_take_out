package look.word.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import look.word.reggie.pojo.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService extends IService<ShoppingCart> {
    /**
     * 根据用户id查询用户购物车单个数据
     */
    ShoppingCart getCartInfoByUserId(Long currentUserId, ShoppingCart shoppingCart);

    /**
     * 查询用户所有购物车中的数据
     */
    List<ShoppingCart> getCartListByUserId(Long currentUserId);

    /**
     * 清空用户购物车
     */
    void removeByUserId(Long currentUserId);
}
