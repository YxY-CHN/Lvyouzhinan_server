package com.yuxuyi.lvyouzhinan.mapper;

import com.yuxuyi.lvyouzhinan.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from article")
    List<Article> findAll();

    @Insert("insert into article(title,area,image,content) values(#{title},#{area},#{image},#{content})")
    void save(Article article);

    @Select("select * from article where id=#{id}")
    Article getById(Integer id);

    @Update("update article set title=#{title},area=#{area},image=#{image},content=#{content} where id=#{id}")
    void update(Article article);

    @Delete("delete from article where id=#{id}")
    void deleteById(Integer id);
}
