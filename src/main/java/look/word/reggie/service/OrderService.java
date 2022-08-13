package look.word.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import look.word.reggie.pojo.entity.Orders;

/**
 * 订单表(Orders)表服务接口
 *
 * @author LookWord
 * @since 2022-08-11 14:57:24
 */
public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     */
    void submit(Orders orders);
}

