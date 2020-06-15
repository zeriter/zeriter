package com.zeriter.service.impl;

import com.zeriter.entity.Zgroup;
import com.zeriter.mapper.BlogMapper;
import com.zeriter.mapper.ZgroupMapper;
import com.zeriter.reqAndResp.ListGroupsResp;
import com.zeriter.service.IZgroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeriter.util.Sequence;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public ListGroupsResp getlist() {
        List<Zgroup> groups = zgroupMapper.getlist();
        for (Zgroup group:groups){
            Integer count = blogMapper.selectByGroupId(group.getGroupId());
            group.setCount(count);
        }
        return new ListGroupsResp(groups);
    }

    @Override
    public void addGroup(String groupName) {
        Zgroup group = new Zgroup();
        group.setGroupId(Sequence.getGroupSeq());
        group.setCreateDate(new Date());
        group.setGroupName(groupName);
        zgroupMapper.insert(group);
    }

}
