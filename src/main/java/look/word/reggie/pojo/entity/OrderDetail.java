package look.word.reggie.pojo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单明细表(OrderDetail)表实体类
 *
 * @author LookWord
 * @since 2022-08-11 15:02:12
 */
@Data
@SuppressWarnings("serial")
public class OrderDetail extends Model<OrderDetail> {
    /**
     * 主键
     */
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 图片
     */
    private String image;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 菜品id
     */
    private Long dishId;
    /**
     * 套餐id
     */
    private Long setmealId;
    /**
     * 口味
     */
    private String dishFlavor;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 金额
     */
    private BigDecimal amount;


}

