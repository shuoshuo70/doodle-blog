package com.doodle.blog.mapper;

import com.doodle.blog.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
    @Select("select tag_id as tagId, tag_name as tagName from tag")
    List<Tag> queryTags();
}
