package com.yuxuyi.lvyouzhinan.mapper;

import com.yuxuyi.lvyouzhinan.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from admin")
    List<Admin> findAll();

    @Insert("insert into admin(name,password) values(#{name},#{password})")
    void save(Admin admin);

    @Select("select * from admin where name=#{name}")
    Admin getByName(String name);

    @Select("select * from admin where id=#{id}")
    Admin getById(Integer id);

    @Update("update admin set name=#{name},password=#{password} where id=#{id}")
    void update(Admin admin);

    @Delete("delete from admin where id=#{id}")
    void deleteById(Integer id);
}
