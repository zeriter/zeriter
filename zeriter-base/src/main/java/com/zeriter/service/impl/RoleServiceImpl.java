package com.zeriter.service.impl;

import com.zeriter.entity.domin.Role;
import com.zeriter.mapper.RoleMapper;
import com.zeriter.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
