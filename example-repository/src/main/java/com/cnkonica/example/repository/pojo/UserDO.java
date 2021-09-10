package com.cnkonica.example.repository.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserDO implements Serializable {
    /**  */
    private Long id;

    /** 用户名 */
    private String username;

    /** 密码，加密存储 */
    private String password;

    /** 注册手机号 */
    private String phone;

    /** 注册邮箱 */
    private String email;

    /** 创建时间 */
    private Date created;

    /**  */
    private Date updated;

    /** 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat */
    private String sourceType;

    /** 昵称 */
    private String nickName;

    /** 真实姓名 */
    private String name;

    /** 使用状态（Y正常 N非正常） */
    private String status;

    /** 头像地址 */
    private String headPic;

    /** QQ号码 */
    private String qq;

    /** 账户余额 */
    private BigDecimal accountBalance;

    /** 手机是否验证 （0否  1是） */
    private String isMobileCheck;

    /** 邮箱是否检测（0否  1是） */
    private String isEmailCheck;

    /** 性别，1男，2女 */
    private String sex;

    /** 会员等级 */
    private Integer userLevel;

    /** 积分 */
    private Integer points;

    /** 经验值 */
    private Integer experienceValue;

    /** 生日 */
    private Date birthday;

    /** 最后登录时间 */
    private Date lastLoginTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取：
     * 表字段：user.id
     *
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：
     * 表字段：user.id
     *
    * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：用户名
     * 表字段：user.username
     *
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：用户名
     * 表字段：user.username
     *
    * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取：密码，加密存储
     * 表字段：user.password
     *
     * @return 密码，加密存储
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：密码，加密存储
     * 表字段：user.password
     *
    * @param password 密码，加密存储
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取：注册手机号
     * 表字段：user.phone
     *
     * @return 注册手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：注册手机号
     * 表字段：user.phone
     *
    * @param phone 注册手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取：注册邮箱
     * 表字段：user.email
     *
     * @return 注册邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：注册邮箱
     * 表字段：user.email
     *
    * @param email 注册邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取：创建时间
     * 表字段：user.created
     *
     * @return 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置：创建时间
     * 表字段：user.created
     *
    * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取：
     * 表字段：user.updated
     *
     * @return 
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置：
     * 表字段：user.updated
     *
    * @param updated 
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取：会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     * 表字段：user.source_type
     *
     * @return 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置：会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     * 表字段：user.source_type
     *
    * @param sourceType 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * 获取：昵称
     * 表字段：user.nick_name
     *
     * @return 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置：昵称
     * 表字段：user.nick_name
     *
    * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取：真实姓名
     * 表字段：user.name
     *
     * @return 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：真实姓名
     * 表字段：user.name
     *
    * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取：使用状态（Y正常 N非正常）
     * 表字段：user.status
     *
     * @return 使用状态（Y正常 N非正常）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置：使用状态（Y正常 N非正常）
     * 表字段：user.status
     *
    * @param status 使用状态（Y正常 N非正常）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取：头像地址
     * 表字段：user.head_pic
     *
     * @return 头像地址
     */
    public String getHeadPic() {
        return headPic;
    }

    /**
     * 设置：头像地址
     * 表字段：user.head_pic
     *
    * @param headPic 头像地址
     */
    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }

    /**
     * 获取：QQ号码
     * 表字段：user.qq
     *
     * @return QQ号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置：QQ号码
     * 表字段：user.qq
     *
    * @param qq QQ号码
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 获取：账户余额
     * 表字段：user.account_balance
     *
     * @return 账户余额
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * 设置：账户余额
     * 表字段：user.account_balance
     *
    * @param accountBalance 账户余额
     */
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * 获取：手机是否验证 （0否  1是）
     * 表字段：user.is_mobile_check
     *
     * @return 手机是否验证 （0否  1是）
     */
    public String getIsMobileCheck() {
        return isMobileCheck;
    }

    /**
     * 设置：手机是否验证 （0否  1是）
     * 表字段：user.is_mobile_check
     *
    * @param isMobileCheck 手机是否验证 （0否  1是）
     */
    public void setIsMobileCheck(String isMobileCheck) {
        this.isMobileCheck = isMobileCheck == null ? null : isMobileCheck.trim();
    }

    /**
     * 获取：邮箱是否检测（0否  1是）
     * 表字段：user.is_email_check
     *
     * @return 邮箱是否检测（0否  1是）
     */
    public String getIsEmailCheck() {
        return isEmailCheck;
    }

    /**
     * 设置：邮箱是否检测（0否  1是）
     * 表字段：user.is_email_check
     *
    * @param isEmailCheck 邮箱是否检测（0否  1是）
     */
    public void setIsEmailCheck(String isEmailCheck) {
        this.isEmailCheck = isEmailCheck == null ? null : isEmailCheck.trim();
    }

    /**
     * 获取：性别，1男，2女
     * 表字段：user.sex
     *
     * @return 性别，1男，2女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置：性别，1男，2女
     * 表字段：user.sex
     *
    * @param sex 性别，1男，2女
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取：会员等级
     * 表字段：user.user_level
     *
     * @return 会员等级
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * 设置：会员等级
     * 表字段：user.user_level
     *
    * @param userLevel 会员等级
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * 获取：积分
     * 表字段：user.points
     *
     * @return 积分
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置：积分
     * 表字段：user.points
     *
    * @param points 积分
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 获取：经验值
     * 表字段：user.experience_value
     *
     * @return 经验值
     */
    public Integer getExperienceValue() {
        return experienceValue;
    }

    /**
     * 设置：经验值
     * 表字段：user.experience_value
     *
    * @param experienceValue 经验值
     */
    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    /**
     * 获取：生日
     * 表字段：user.birthday
     *
     * @return 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置：生日
     * 表字段：user.birthday
     *
    * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取：最后登录时间
     * 表字段：user.last_login_time
     *
     * @return 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置：最后登录时间
     * 表字段：user.last_login_time
     *
    * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}