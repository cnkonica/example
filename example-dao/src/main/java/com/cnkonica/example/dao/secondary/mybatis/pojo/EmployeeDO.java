package com.cnkonica.example.dao.secondary.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDO implements Serializable {
    /** 主键 */
    private Integer id;

    /** 身份证 */
    private String certId;

    /** 姓名 */
    private String name;

    /** 性别 */
    private String gender;

    /** 年龄 */
    private Integer age;

    /** 删除标志 */
    private Boolean deleted;

    /** 创建时间 */
    private Date createdDate;

    /** 创建人 */
    private String createdBy;

    /** 更新时间 */
    private Date updatedDate;

    /** 更新人 */
    private String updateBy;

    private static final long serialVersionUID = 1L;

    /**
     * 获取：主键
     * 表字段：employee.id
     *
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：主键
     * 表字段：employee.id
     *
    * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：身份证
     * 表字段：employee.cert_id
     *
     * @return 身份证
     */
    public String getCertId() {
        return certId;
    }

    /**
     * 设置：身份证
     * 表字段：employee.cert_id
     *
    * @param certId 身份证
     */
    public void setCertId(String certId) {
        this.certId = certId;
    }

    /**
     * 获取：姓名
     * 表字段：employee.name
     *
     * @return 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：姓名
     * 表字段：employee.name
     *
    * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取：性别
     * 表字段：employee.gender
     *
     * @return 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置：性别
     * 表字段：employee.gender
     *
    * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取：年龄
     * 表字段：employee.age
     *
     * @return 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置：年龄
     * 表字段：employee.age
     *
    * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取：删除标志
     * 表字段：employee.deleted
     *
     * @return 删除标志
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置：删除标志
     * 表字段：employee.deleted
     *
    * @param deleted 删除标志
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取：创建时间
     * 表字段：employee.created_date
     *
     * @return 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置：创建时间
     * 表字段：employee.created_date
     *
    * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取：创建人
     * 表字段：employee.created_by
     *
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置：创建人
     * 表字段：employee.created_by
     *
    * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 获取：更新时间
     * 表字段：employee.updated_date
     *
     * @return 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置：更新时间
     * 表字段：employee.updated_date
     *
    * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 获取：更新人
     * 表字段：employee.update_by
     *
     * @return 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置：更新人
     * 表字段：employee.update_by
     *
    * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}