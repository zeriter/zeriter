package com.zeriter.mapper;

import com.zeriter.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
