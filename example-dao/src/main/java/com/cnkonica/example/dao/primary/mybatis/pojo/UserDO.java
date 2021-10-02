package com.cnkonica.example.dao.primary.mybatis.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserDO implements Serializable {
    /** 主键 */
    private Integer id;

    /** 名字 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 工资 */
    private BigDecimal salary;

    /** 删除标志 */
    private Byte deleted;

    /** 创建人 */
    private String creator;

    /** 创建时间 */
    private Date gmtCreate;

    /** 更行人 */
    private String updator;

    /** 更新时间 */
    private Date gmtUpdated;

    private static final long serialVersionUID = 1L;

    /**
     * 获取：主键
     * 表字段：user.id
     *
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：主键
     * 表字段：user.id
     *
    * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：名字
     * 表字段：user.name
     *
     * @return 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：名字
     * 表字段：user.name
     *
    * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取：年龄
     * 表字段：user.age
     *
     * @return 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置：年龄
     * 表字段：user.age
     *
    * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取：工资
     * 表字段：user.salary
     *
     * @return 工资
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * 设置：工资
     * 表字段：user.salary
     *
    * @param salary 工资
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * 获取：删除标志
     * 表字段：user.deleted
     *
     * @return 删除标志
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * 设置：删除标志
     * 表字段：user.deleted
     *
    * @param deleted 删除标志
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取：创建人
     * 表字段：user.creator
     *
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置：创建人
     * 表字段：user.creator
     *
    * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 获取：创建时间
     * 表字段：user.gmt_create
     *
     * @return 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置：创建时间
     * 表字段：user.gmt_create
     *
    * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取：更行人
     * 表字段：user.updator
     *
     * @return 更行人
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * 设置：更行人
     * 表字段：user.updator
     *
    * @param updator 更行人
     */
    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    /**
     * 获取：更新时间
     * 表字段：user.gmt_updated
     *
     * @return 更新时间
     */
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    /**
     * 设置：更新时间
     * 表字段：user.gmt_updated
     *
    * @param gmtUpdated 更新时间
     */
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }
}