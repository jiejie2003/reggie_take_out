package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import look.word.reggie.mapper.OrdersMapper;
import look.word.reggie.pojo.entity.Orders;
import look.word.reggie.service.OrdersService;
import org.springframework.stereotype.Service;

/**
 * 订单表(Orders)表服务实现类
 *
 * @author LookWord
 * @since 2022-08-11 14:57:24
 */
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}

