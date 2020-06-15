package com.zeriter.service;

import com.zeriter.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeriter.reqAndResp.BlogAddReq;
import com.zeriter.reqAndResp.BlogDetailResp;
import com.zeriter.reqAndResp.ListBlogsResp;
import com.zeriter.reqAndResp.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-06-09
 */
public interface IBlogService extends IService<Blog> {

    ListBlogsResp getBlogListByPage(Page page);

    ListBlogsResp getTop4();

    String insertBlog(BlogAddReq blog);

    BlogDetailResp getBlogDeail(String blogId);
}
