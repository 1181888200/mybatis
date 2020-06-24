package com.lwl.mybatis.day1;

import com.lwl.mybatis.common.domain.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description： 用户信息
 * @author     ：lwl
 * @date       ：2020/6/24 14:08
 * @version:     1.0.0
 */
@Data
@Accessors(chain = true)
public class User extends BaseModel {

    private String name;

    private String sex;

    private String password;

    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                "} " + super.toString();
    }
}
