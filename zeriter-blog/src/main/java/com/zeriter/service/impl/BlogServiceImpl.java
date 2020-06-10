package com.zeriter.service.impl;

import com.zeriter.entity.Blog;
import com.zeriter.mapper.BlogMapper;
import com.zeriter.reqAndResp.ListBlogs;
import com.zeriter.reqAndResp.Page;
import com.zeriter.service.IBlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Resource
    private BlogMapper blogMapper;
    @Override
    public ListBlogs getBlogListByPage(Page page) {
        Integer count = this.count();
        List<Blog> blogs = blogMapper.getBlogListByPage(page.getPageNum()-1,page.getPageSize());
        return new ListBlogs(count,blogs);
    }
}
