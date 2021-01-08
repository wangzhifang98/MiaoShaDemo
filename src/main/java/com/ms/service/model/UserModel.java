package com.ms.service.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * @author 王智芳
 * @data 2021/1/6 10:31
 */
public class UserModel {
    private Integer id;
    @NotBlank(message = "服务端-用户名不能为空")
    @Length(min = 2,max = 4,message = "服务端-长度2到4位")
    private String name;
    @NotNull(message = "服务端-性别不能不填")
    private Byte gender;
    @NotNull(message = "年龄不能为空")
    @Min(value = 0,message = "服务端-年龄必须大于0")
    @Max(value = 100,message = "服务端-年龄必须小于100")
    private Integer age;
    @NotBlank(message = "服务端-手机号不能为空")
    private String telphone;

    private String registerMode;

    private String thirdPartyId;
    @NotBlank(message = "服务端-密码不能为空")
    private String encrptPassword;

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

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public String getEncrptPassword() {
        return encrptPassword;
    }

    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserModel{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", telphone='").append(telphone).append('\'');
        sb.append(", registerMode='").append(registerMode).append('\'');
        sb.append(", thirdPartyId='").append(thirdPartyId).append('\'');
        sb.append(", encrptPassword='").append(encrptPassword).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
