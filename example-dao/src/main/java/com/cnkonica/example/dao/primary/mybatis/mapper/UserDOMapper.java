package com.cnkonica.example.dao.primary.mybatis.mapper;

import com.cnkonica.example.dao.primary.mybatis.pojo.UserDO;

public interface UserDOMapper {
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
    int insert(UserDO record);

    /**
     * 选择插入数据库记录
     *
     * @param record
     */
    int insertSelective(UserDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    UserDO selectByPrimaryKey(Integer id);

    /**
     * 选择根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(UserDO record);
}