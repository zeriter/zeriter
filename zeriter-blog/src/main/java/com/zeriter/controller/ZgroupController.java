package com.zeriter.controller;


import com.zeriter.reqAndResp.ListGroups;
import com.zeriter.reqAndResp.Result;
import com.zeriter.service.IZgroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class ZgroupController {
    @Resource
    private IZgroupService groupService;

    @GetMapping("list")
    public Result getlist(){
        ListGroups groups = groupService.getlist();
        Result result = new Result(200,"查询成功");
        result.setData(groups);
        return result;
    }

}
