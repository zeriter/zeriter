package com.zeriter.mapper;

import com.zeriter.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-06-09
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> selectByBlogId(@Param("blogId") String blogId);
}
