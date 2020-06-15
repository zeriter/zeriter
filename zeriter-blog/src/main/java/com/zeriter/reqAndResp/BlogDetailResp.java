package com.zeriter.reqAndResp;

import com.zeriter.entity.Blog;
import com.zeriter.entity.Comment;
import com.zeriter.entity.Tag;
import com.zeriter.entity.Zgroup;
import lombok.Data;

import java.util.List;

@Data
public class BlogDetailResp {
    private Blog blog;
    private List<Comment> comments;
    private Zgroup zgroup;
    private List<Tag> tags;
}
