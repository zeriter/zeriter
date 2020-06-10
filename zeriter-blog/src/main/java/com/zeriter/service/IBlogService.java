package com.zeriter.service;

import com.zeriter.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeriter.reqAndResp.ListBlogs;
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

    ListBlogs getBlogListByPage(Page page);
}
