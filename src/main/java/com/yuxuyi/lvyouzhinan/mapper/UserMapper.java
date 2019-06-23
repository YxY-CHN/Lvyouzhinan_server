package com.yuxuyi.lvyouzhinan.mapper;

import com.yuxuyi.lvyouzhinan.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(name,phone,password) values(#{name},#{phone},#{password})")
    void save(User user);

    @Select("select * from user where id=#{id}")
    User getById(Integer id);

    @Update("update user set name=#{name},phone=#{phone},password=#{password} where id=#{id}")
    void update(User user);

    @Delete("delete from user where id=#{id}")
    void deleteById(Integer id);

    @Select("select * from user where name=#{name}")
    User getByName(String user);
}
