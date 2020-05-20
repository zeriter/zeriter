package com.zeriter.mapper;

import com.zeriter.entity.domin.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-05-20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
