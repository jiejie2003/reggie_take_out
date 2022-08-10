package look.word.reggie.pojo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息(User)表实体类
 *
 * @author LookWord
 * @since 2022-08-10 17:19:25
 */
@Data
@SuppressWarnings("serial")
public class User extends Model<User> {
    /**
     * 主键
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别
     */
    private String sex;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 状态 0:禁用，1:正常
     */
    private Integer status;


}

