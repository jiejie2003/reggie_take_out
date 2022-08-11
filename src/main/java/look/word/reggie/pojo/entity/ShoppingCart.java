package look.word.reggie.pojo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 购物车(ShoppingCart)表实体类
 *
 * @author LookWord
 * @since 2022-08-11 09:54:29
 */
@Data
@SuppressWarnings("serial")
public class ShoppingCart extends Model<ShoppingCart> {
    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片
     */
    private String image;
    /**
     * 主键
     */
    private Long userId;
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
    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}

