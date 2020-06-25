package com.lwl.mybatis.day2.domain;

import com.lwl.mybatis.common.domain.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description： 角色信息
 * @author     ：lwl
 * @date       ：2020/6/25 11:12
 * @version:     1.0.0
 */
@Data
@Accessors(chain = true)
public class Role extends BaseModel {

    private String name;

    private String remark;

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                "} " + super.toString();
    }
}
