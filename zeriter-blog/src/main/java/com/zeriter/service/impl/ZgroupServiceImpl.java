package com.zeriter.service.impl;

import com.zeriter.entity.Zgroup;
import com.zeriter.mapper.BlogMapper;
import com.zeriter.mapper.ZgroupMapper;
import com.zeriter.reqAndResp.ListGroups;
import com.zeriter.service.IZgroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-06-09
 */
@Service
public class ZgroupServiceImpl extends ServiceImpl<ZgroupMapper, Zgroup> implements IZgroupService {

    @Resource
    private ZgroupMapper zgroupMapper;
    @Resource
    private BlogMapper blogMapper;
    @Override
    public ListGroups getlist() {
        List<Zgroup> groups = zgroupMapper.getlist();
        for (Zgroup group:groups){
            Integer count = blogMapper.selectByGroupId(group.getGroupId());
            group.setCount(count);
        }
        return new ListGroups(groups);
    }

}
