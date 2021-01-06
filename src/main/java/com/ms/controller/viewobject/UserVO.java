package com.ms.controller.viewobject;

/**
 * @author 王智芳
 * @data 2021/1/6 10:50
 */
public class UserVO {
    private Integer id;

    private String name;

    private Byte gender;

    private Integer age;

    private String telphone;

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserVO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", telphone='").append(telphone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
