package com.zeriter.mapper;

import com.zeriter.entity.Zgroup;
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
public interface ZgroupMapper extends BaseMapper<Zgroup> {

    List<Zgroup> getlist();

    Zgroup selectByBlogId(@Param("groupId") String groupId);
}
