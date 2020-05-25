package com.txx.demo.mapper;

import com.txx.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
interface UserMapper {
@Insert("insert into user (name,accountId,token,gmtCreate,gmtModified) values(#{name},#{accountId},#{token}，#{gmtCreate}，#{gmtModified})")
    void addUser(User user);


}
