package com.edu.manage.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author lufei
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sm_admin")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户OA号
     */
    private String username;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 角色id
     */
    private Integer role;

    /**
     * 学校id
     */
    private Integer schoolid;

    private Integer classid;

    /**
     * 父级管理者
     */
    private String father;

    private String province;

    private String city;

    private String district;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 最后登录时间
     */
    private String loginDate;

    /**
     * 是否停用，0--使用，1--停用
     */
    private Integer useType;

    /**
     * 是否有效,默认值1(1、有效，0、无效)
     */
    private Integer iseffective;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
