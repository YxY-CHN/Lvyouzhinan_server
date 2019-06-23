package com.yuxuyi.lvyouzhinan.mapper;

import com.yuxuyi.lvyouzhinan.entity.Article;
import com.yuxuyi.lvyouzhinan.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from comment")
    List<Comment> findAll();

    @Insert("insert into comment(message,article_id) values(#{message},#{article_id})")
    void save(Comment comment);

    @Select("select * from comment where id=#{id}")
    Article getById(Integer id);

    @Update("update comment set message=#{message},article_id=#{article_id} where id=#{id}")
    void update(Comment comment);

    @Delete("delete from comment where id=#{id}")
    void deleteById(Integer id);
}
