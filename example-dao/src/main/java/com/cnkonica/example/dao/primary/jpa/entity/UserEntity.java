package com.cnkonica.example.dao.primary.jpa.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "example")
@DynamicInsert
public class UserEntity {
    private int id;
    private String name;
    private Integer age;
    private BigDecimal salary;
    private Byte deleted;
    private String creator;
    private Timestamp gmtCreate;
    private String updator;
    private Timestamp gmtUpdated;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "deleted")
    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "gmt_create")
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "updator")
    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    @Basic
    @Column(name = "gmt_updated")
    public Timestamp getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Timestamp gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(salary, that.salary) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(gmtCreate, that.gmtCreate) &&
                Objects.equals(updator, that.updator) &&
                Objects.equals(gmtUpdated, that.gmtUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary, deleted, creator, gmtCreate, updator, gmtUpdated);
    }
}
