package com.zeriter.controller;


import com.zeriter.reqAndResp.ListBlogs;
import com.zeriter.reqAndResp.Page;
import com.zeriter.reqAndResp.Result;
import com.zeriter.service.IBlogService;
import lombok.extern.slf4j.Slf4j;
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
            ListBlogs blogs = blogService.getBlogListByPage(page);
            Result<ListBlogs> result = new Result(200,"返回成功");
            result.setData(blogs);
            return result;
        }
    }

}
