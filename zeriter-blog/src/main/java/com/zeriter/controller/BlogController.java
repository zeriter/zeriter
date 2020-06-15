package com.zeriter.controller;


import com.zeriter.reqAndResp.*;
import com.zeriter.service.IBlogService;
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
@RequestMapping("/blog")
@Slf4j
public class BlogController {
    @Resource
    private IBlogService blogService;

    @GetMapping("list")
    public Result list(Page page){
        if (null == page.getPageNum()||null == page.getPageSize()){
            return new Result(200,"请求参数错误");
        }else{
            log.info("参数正确：pagenum:"+page.getPageNum()+" pagesize:"+page.getPageSize());
            ListBlogsResp blogs = blogService.getBlogListByPage(page);
            Result<ListBlogsResp> result = new Result(200,"返回成功");
            result.setData(blogs);
            return result;
        }
    }
    @GetMapping("top4")
    public Result getTop4(){
        ListBlogsResp blogs = blogService.getTop4();
        Result<ListBlogsResp> result = new Result(200,"返回成功");
        result.setData(blogs);
        return result;
    }

    @PutMapping("blog")
    public Result addBlog(@RequestBody BlogAddReq blog){
        log.info(blog.toString());
        try{
            String blogId = blogService.insertBlog(blog);
            Result result = new Result(200,"插入成功");
            result.setData(blogId);
            return result;
        }catch (Exception e){
            Result result = new Result(201,"插入失败"+e.toString());
            return result;
        }
    }
    @GetMapping("{blogId}")
    public Result getBlogById(@PathVariable("blogId") String blogId){
        if (null == blogId||"".equals(blogId)){
            return new Result(200,"请求参数错误");
        }else{
            log.info(blogId);
            BlogDetailResp blogs = blogService.getBlogDeail(blogId);
            Result result = new Result(200,"返回成功");
            result.setData(blogs);
            return result;
        }
    }
}
