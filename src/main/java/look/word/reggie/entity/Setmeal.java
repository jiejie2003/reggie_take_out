package look.word.reggie.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 套餐(Setmeal)表实体类
 *
 * @author LookWord
 * @since 2022-08-09 16:18:33
 */
@Data
@SuppressWarnings("serial")
public class Setmeal extends Model<Setmeal> {
    /**
     * 主键
     */
    private Long id;
    /**
     * 菜品分类id
     */
    private Long categoryId;
    /**
     * 套餐名称
     */
    private String name;
    /**
     * 套餐价格
     */
    private Double price;
    /**
     * 状态 0:停用 1:启用
     */
    private Integer status;
    /**
     * 编码
     */
    private String code;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 图片
     */
    private String image;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    private Long createUser;
    /**
     * 修改人
     */
    private Long updateUser;
    /**
     * 逻辑删除 0 未删除 1 已删除
     */
    @TableField(value = "is_deleted")
    private Integer deleted;


}

