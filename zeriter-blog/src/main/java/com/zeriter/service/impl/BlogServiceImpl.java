package com.zeriter.service.impl;

import com.zeriter.entity.Blog;
import com.zeriter.entity.Comment;
import com.zeriter.entity.Tag;
import com.zeriter.entity.Zgroup;
import com.zeriter.mapper.BlogMapper;
import com.zeriter.mapper.CommentMapper;
import com.zeriter.mapper.TagMapper;
import com.zeriter.mapper.ZgroupMapper;
import com.zeriter.reqAndResp.BlogAddReq;
import com.zeriter.reqAndResp.BlogDetailResp;
import com.zeriter.reqAndResp.ListBlogsResp;
import com.zeriter.reqAndResp.Page;
import com.zeriter.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeriter.util.Sequence;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Resource
    private BlogMapper blogMapper;
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ZgroupMapper groupMapper;
    @Resource
    private TagMapper tagMapper;

    @Override
    public ListBlogsResp getBlogListByPage(Page page) {
        Integer count = this.count();
        List<Blog> blogs = blogMapper.getBlogListByPage(page.getPageNum()-1,page.getPageSize());
        return new ListBlogsResp(count,blogs);
    }

    @Override
    public ListBlogsResp getTop4() {
        List<Blog> blogs = blogMapper.getTop4();
        return new ListBlogsResp(0,blogs);
    }

    @Override
    public String insertBlog(BlogAddReq addblog) {
        Blog blog = new Blog();
        blog.setBlogId(Sequence.getBlogSeq());
        blog.setBlogTitle(addblog.getTitle());
        blog.setBlogContent(addblog.getContent());
        blog.setCreateDate(new Date());
        blog.setShowSts("0");
        blog.setDeleteSts("0");
        blog.setTagId(addblog.getLabels());
        blog.setClick(1);
        blog.setBlogType(addblog.getBlogType());
        blog.setGroupId(addblog.getGroupId());
        blogMapper.insert(blog);
        Comment comment = new Comment();
        comment.setCommentId(Sequence.getCommentSeq());
        comment.setParentCommentId("0");
        comment.setBlogId(blog.getBlogId());
        comment.setCreateDate(new Date());
        comment.setDeleteSts("1");
        comment.setShowSts("1");
        commentMapper.insert(comment);
        return blog.getBlogId();
    }

    @Override
    public BlogDetailResp getBlogDeail(String blogId) {
        Blog blog = blogMapper.selectByBlogId(blogId);
        List<Comment> comments = commentMapper.selectByBlogId(blogId);
        Zgroup zgroup = groupMapper.selectByBlogId(blog.getGroupId());
        List<Tag> tags = new ArrayList<Tag>();
        String[] tagIds = blog.getTagId().split(";");
        List<String> tagIdList = Arrays.asList(tagIds);
        tagIdList.stream().forEach(action->{
            Tag tag = tagMapper.selectByBlogId(action.trim());
            tags.add(tag);
        });
        BlogDetailResp resp = new BlogDetailResp();
        resp.setBlog(blog);
        resp.setComments(comments);
        resp.setTags(tags);
        resp.setZgroup(zgroup);
        return resp;
    }
}
