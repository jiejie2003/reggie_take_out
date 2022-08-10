package look.word.reggie.pojo.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 套餐菜品关系(SetmealDish)表实体类
 *
 * @author LookWord
 * @since 2022-08-10 11:04:28
 */
@Data
@SuppressWarnings("serial")
public class SetmealDish extends Model<SetmealDish> {
    /**
     * 主键
     */
    private Long id;
    /**
     * 套餐id
     */
    private Long setmealId;
    /**
     * 菜品id
     */
    private String dishId;
    /**
     * 菜品名称 （冗余字段）
     */
    private String name;
    /**
     * 菜品原价（冗余字段）
     */
    private Double price;
    /**
     * 份数
     */
    private Integer copies;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;
    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;
    /**
     * 逻辑删除 0 未删除 1 已删除
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(value = "is_deleted")
    private Integer deleted;


}

