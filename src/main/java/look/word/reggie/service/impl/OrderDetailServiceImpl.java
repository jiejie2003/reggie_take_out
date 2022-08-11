package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import look.word.reggie.mapper.OrderDetailMapper;
import look.word.reggie.pojo.entity.OrderDetail;
import look.word.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * 订单明细表(OrderDetail)表服务实现类
 *
 * @author LookWord
 * @since 2022-08-11 15:02:13
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}

