package com.zeriter.service.impl;

import com.zeriter.entity.domin.User;
import com.zeriter.mapper.UserMapper;
import com.zeriter.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
