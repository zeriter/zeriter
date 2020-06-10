package com.zeriter.service;

import com.zeriter.entity.Zgroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeriter.reqAndResp.ListGroups;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-06-09
 */
public interface IZgroupService extends IService<Zgroup> {

    ListGroups getlist();
}
