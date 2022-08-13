package look.word.reggie.controller;

import lombok.extern.slf4j.Slf4j;
import look.word.reggie.common.R;
import look.word.reggie.pojo.entity.Orders;
import look.word.reggie.service.OrderDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单明细
 */
@Slf4j
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Resource
    private OrderDetailService orderDetailService;


}
