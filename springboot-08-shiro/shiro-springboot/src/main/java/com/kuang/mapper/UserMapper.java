package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月18日  周六  11:47
 */
@Repository
@Mapper
public interface UserMapper {

    public User queryUserByName(String name);

}
