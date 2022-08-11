package look.word.reggie.pojo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单表(Orders)表实体类
 *
 * @author LookWord
 * @since 2022-08-11 15:01:24
 */
@Data
@SuppressWarnings("serial")
public class Orders extends Model<Orders> {
    /**
     * 主键
     */
    private Long id;
    /**
     * 订单号
     */
    private String number;
    /**
     * 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
     */
    private Integer status;
    /**
     * 下单用户
     */
    private Long userId;
    /**
     * 地址id
     */
    private Long addressBookId;
    /**
     * 下单时间
     */
    private LocalDateTime orderTime;
    /**
     * 结账时间
     */
    private LocalDateTime checkoutTime;
    /**
     * 支付方式 1微信,2支付宝
     */
    private Integer payMethod;
    /**
     * 实收金额
     */
    private BigDecimal amount;
    /**
     * 备注
     */
    private String remark;
    /**
     * 用户名
     */
    private String phone;
    /**
     * 手机号
     */
    private String address;
    /**
     * 详细地址
     */
    private String userName;
    /**
     * 收货人
     */
    private String consignee;


}

