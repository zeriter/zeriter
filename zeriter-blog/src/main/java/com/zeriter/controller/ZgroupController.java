package com.zeriter.controller;


import com.zeriter.reqAndResp.GroupAddReq;
import com.zeriter.reqAndResp.ListGroupsResp;
import com.zeriter.reqAndResp.Result;
import com.zeriter.service.IZgroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/group")
@Slf4j
public class ZgroupController {
    @Resource
    private IZgroupService groupService;

    @GetMapping("list")
    public Result getlist(){
        ListGroupsResp groups = groupService.getlist();
        Result result = new Result(200,"查询成功");
        result.setData(groups);
        return result;
    }

    @PutMapping("group")
    public Result addGroup(@RequestBody GroupAddReq group){
        log.info("==============>"+group.getGroupName());
        try{
            groupService.addGroup(group.getGroupName());
            Result result = new Result(200,"插入成功");
            return result;
        }catch (Exception e){
            Result result = new Result(201,"插入失败"+e.toString());
            return result;
        }

    }

}
