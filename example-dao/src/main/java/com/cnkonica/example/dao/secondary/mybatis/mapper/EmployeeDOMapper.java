package com.cnkonica.example.dao.secondary.mybatis.mapper;

import com.cnkonica.example.dao.secondary.mybatis.pojo.EmployeeDO;

public interface EmployeeDOMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(EmployeeDO record);

    /**
     * 选择插入数据库记录
     *
     * @param record
     */
    int insertSelective(EmployeeDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    EmployeeDO selectByPrimaryKey(Integer id);

    /**
     * 选择根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(EmployeeDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(EmployeeDO record);
}