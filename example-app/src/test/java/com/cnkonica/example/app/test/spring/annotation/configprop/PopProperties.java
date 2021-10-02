package com.cnkonica.example.app.test.spring.annotation.configprop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@PropertySource(value = "classpath:app.properties")
@Component
@ConfigurationProperties(prefix = "app")
public class PopProperties {
    private Boolean normalBoolean;
    private Integer normalNumber;
    private String normalString;
    private List<String> myList;
    private Map<String, String> myMap;
    private User myUser;

    public Boolean getNormalBoolean() {
        return normalBoolean;
    }

    public void setNormalBoolean(Boolean normalBoolean) {
        this.normalBoolean = normalBoolean;
    }

    public Integer getNormalNumber() {
        return normalNumber;
    }

    public void setNormalNumber(Integer normalNumber) {
        this.normalNumber = normalNumber;
    }

    public String getNormalString() {
        return normalString;
    }

    public void setNormalString(String normalString) {
        this.normalString = normalString;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }

    public static class User{
        private String name;
        private String gender;
        private Integer age;
        private BigDecimal salary;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PopProperties{" +
                "normalBoolean=" + normalBoolean +
                ", normalNumber=" + normalNumber +
                ", normalString='" + normalString + '\'' +
                ", myList=" + myList +
                ", myMap=" + myMap +
                ", myUser=" + myUser +
                '}';
    }
}
