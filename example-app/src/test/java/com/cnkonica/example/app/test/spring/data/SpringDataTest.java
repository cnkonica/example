package com.cnkonica.example.app.test.spring.data;

import com.alibaba.fastjson.JSON;
import com.cnkonica.example.app.test.base.SpringBase;
import com.cnkonica.example.dao.primary.jpa.entity.UserEntity;
import com.cnkonica.example.dao.primary.jpa.repository.UserRepository;
import com.cnkonica.example.dao.secondary.jpa.entity.EmployeeEntity;
import com.cnkonica.example.dao.secondary.jpa.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * 1.请务必先使用JPA命名查询
 * 2.命名查询无法解决请使用JPA的动态SQL
 * 3.多表联合查询在对性能有较大提升的情况下，可使用JPA的@Query
 * 4.在动态SQL和JPA的@Query均不好解决的情况下，方可使用jdbc（务必使用防SQL注入方法）
 *
 * */
@Slf4j
public class SpringDataTest extends SpringBase {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    public void testSave() throws Exception{
        UserEntity user = new UserEntity();
        user.setName("cnkonica");
        userRepository.save(user);

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setCertId(UUID.randomUUID().toString().replace("-",""));
        // save 之后id可以拿得到
        EmployeeEntity save = employeeRepository.save(employeeEntity);
        log.info("{}",objectMapper.writeValueAsString(save));
    }

    @Test
    public void testFind() throws Exception{
        // 根据主键查询
        EmployeeEntity employeeEntity = employeeRepository.findById(1).orElse(null);
        log.info("根据主键查询:{}",objectMapper.writeValueAsString(employeeEntity));

        // 根据id批量查询
        List<EmployeeEntity> allById = employeeRepository.findAllById(Lists.newArrayList(1, 2, 3));
        log.info("根据id批量查询:{}",objectMapper.writeValueAsString(allById));

        // 查询不到list为empty
        List<EmployeeEntity> list = employeeRepository.findAllById(Lists.newArrayList(100, 102, 103));
        log.info("查询不到list为empty:{}",objectMapper.writeValueAsString(list));

        // 查询所有记录
        List<EmployeeEntity> all = employeeRepository.findAll();
        log.info("查询所有记录:{}",objectMapper.writeValueAsString(all));

        // 查询所有记录排序
        List<EmployeeEntity> sortList = employeeRepository.findAll(Sort.by("certId", "id"));
        log.info("查询所有记录排序:{}",objectMapper.writeValueAsString(sortList));

        // 分页查询
        long count = employeeRepository.count();
        int page = 0;
        int size = 2;
        long totalPages = count / size == 0 ? count / size : (count / size) + 1;

        while(totalPages >= page){
            Page<EmployeeEntity> pageList = employeeRepository.findAll(PageRequest.of(page, size, Sort.by("certId", "id")));
            if (!pageList.hasContent()) {
                break;
            }
            page++;
            log.info("分页查询,第{}页,数据:{}",page,objectMapper.writeValueAsString(pageList));
        }
        // 自定义查询
        List<EmployeeEntity> employees = employeeRepository.findByAge(27);
        log.info("自定义查询1：{}",objectMapper.writeValueAsString(employees));
        List<EmployeeEntity> minAge = employeeRepository.getMinAge();
        log.info("自定义查询2：{}",objectMapper.writeValueAsString(minAge));
        List<EmployeeEntity> male = employeeRepository.selectByAgeAndGender(27, "male");
        log.info("自定义查询3：{}",objectMapper.writeValueAsString(male));

    }

    @Test
    public void testSpec() throws Exception{
        EmployeeEntity entity = new EmployeeEntity();
        entity.setGender("");
        entity.setAge(null);
        entity.setName("");
        List<EmployeeEntity> all = employeeRepository.findAll((Specification<EmployeeEntity>) (root, criteriaQuery, builder) -> {
            List<Predicate> list = Lists.newArrayList();
            if (StringUtils.isNotBlank(entity.getGender())) {
                list.add(builder.equal(root.get("gender"), entity.getGender()));
            }

            if (entity.getAge() != null) {
                list.add(builder.equal(root.get("age"), entity.getAge()));
            }

            if (StringUtils.isNotBlank(entity.getName())) {
                list.add(builder.like(root.get("name"), "%".concat(entity.getName()).concat("%")));
            }

            return builder.and(list.toArray(new Predicate[0]));
        });
        log.info("动态查询：{}",objectMapper.writeValueAsString(all));

    }


    @Test
    public void testUpdate() throws Exception{
        EmployeeEntity employeeEntity = employeeRepository.findById(1).orElse(null);
        // 如果数据库非空，插入不了，
        // 如果数据库可以为空，加了@DynamicUpdate，只拼接更新的字段，
        employeeEntity.setName(null);
        EmployeeEntity save = employeeRepository.save(employeeEntity);

        int ram = employeeRepository.updateById(1, "ram");
        log.info("{}",ram);

    }

}
