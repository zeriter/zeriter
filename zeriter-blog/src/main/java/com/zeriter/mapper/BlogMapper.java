package com.zeriter.mapper;

import com.zeriter.entity.Blog;
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
public interface BlogMapper extends BaseMapper<Blog> {

    List<Blog> getBlogListByPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    Integer selectByGroupId(@Param("groupId")String groupId);
}
