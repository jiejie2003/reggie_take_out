package look.word.reggie.pojo.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 菜品口味关系表(DishFlavor)表实体类
 *
 * @author LookWord
 * @since 2022-08-10 09:09:39
 */
@Data
@SuppressWarnings("serial")
public class DishFlavor extends Model<DishFlavor> {
    /**
     * 主键
     */
    private Long id;
    /**
     * 菜品
     */
    private Long dishId;
    /**
     * 口味名称
     */
    private String name;
    /**
     * 口味数据list
     */
    private String value;
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
    @TableField(value = "is_deleted")
    private Integer deleted;


}

