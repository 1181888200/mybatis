package com.lwl.mybatis.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @description： 所有类的基类
 * @author     ：lwl
 * @date       ：2020/6/24 14:09
 * @version:     1.0.0
 */
@Data
@Accessors(chain = true)
public class BaseModel implements Serializable {
    /**
     *  主键
     */
    private Long id;
    private String createUser;
    private Date createTime;
    private String modifyUser;
    private Date modifyTime;
}
