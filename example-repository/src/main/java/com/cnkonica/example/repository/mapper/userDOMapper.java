package com.cnkonica.example.repository.mapper;

import com.cnkonica.example.repository.pojo.userDO;

public interface userDOMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(userDO record);

    /**
     *
     * @param record
     */
    int insertSelective(userDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    userDO selectByPrimaryKey(Long id);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(userDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(userDO record);
}