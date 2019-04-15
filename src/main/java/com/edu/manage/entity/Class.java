package com.edu.manage.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("sm_class")
public class Class extends Model<Class> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "classid", type = IdType.AUTO)
    private Integer classid;

    /**
     * 班级名称
     */
    private String classname;

    /**
     * 个性班名
     */
    private String personalityname;

    /**
     * 学校id
     */
    private Integer schoolid;

    /**
     * 学段编号
     */
    private Integer phaseid;

    /**
     * 年级id
     */
    private Integer gradeid;

    /**
     * 班级编号
     */
    private Integer orderid;

    /**
     * 入学年份
     */
    private String enteryear;

    /**
     * 毕业年份
     */
    @TableField("graduateYear")
    private String graduateYear;

    /**
     * 是否毕业 0未毕业 1已毕业
     */
    @TableField("isGraduated")
    private Integer isGraduated;

    /**
     * 班主任id
     */
    private Integer classteacher;

    /**
     * 班内坐次分布
     */
    private String seatxy;

    /**
     * 教室id
     */
    private Integer classroomid;

    /**
     * 接收器id
     */
    private String hdid;

    /**
     * 是否按装设备 1安装 0未安装
     */
    private String issb;

    /**
     * 创建人
     */
    private Integer creater;

    /**
     * 创建时间
     */
    @TableField("creationDate")
    private String creationDate;

    /**
     * 是否有效,默认值1(1、有效，0、无效)
     */
    private Integer iseffective;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
