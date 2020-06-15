package com.zeriter.controller;


import com.zeriter.entity.Tag;
import com.zeriter.reqAndResp.Result;
import com.zeriter.reqAndResp.TagAddReq;
import com.zeriter.service.ITagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/tag")
@Slf4j
public class TagController {
    @Resource
    private ITagService tagService;

    @GetMapping("list")
    public Result list(){
        List<Tag> tags = tagService.list();
        Result result = new Result(200,"查询成功");
        result.setData(tags);
        return result;
    }

    @PutMapping("tag")
    public Result addTag(@RequestBody TagAddReq tag){
        log.debug(tag.getTagName());
        try{
            tagService.addTag(tag.getTagName());
            Result result = new Result(200,"插入成功");
            return result;
        }catch (Exception e){
            Result result = new Result(201,"插入失败"+e.toString());
            return result;
        }
    }
}
