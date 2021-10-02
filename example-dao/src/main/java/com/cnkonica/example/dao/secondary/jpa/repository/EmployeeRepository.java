package com.cnkonica.example.dao.secondary.jpa.repository;

import com.cnkonica.example.dao.secondary.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>, JpaSpecificationExecutor<EmployeeEntity> {
    List<EmployeeEntity>  findByAge(Integer age);

    @Query("select t from EmployeeEntity t where t.age = (select min(age) from EmployeeEntity )")
    List<EmployeeEntity> getMinAge();

    @Query("select t from EmployeeEntity t where t.age = :age and t.gender = :gender")
    List<EmployeeEntity> selectByAgeAndGender(@Param("age") Integer age,@Param("gender") String gender);

    @Transactional
    @Modifying
    @Query("update EmployeeEntity  set name = :name where id = :id")
    int updateById(@Param("id") Integer id,@Param("name") String name);
}
