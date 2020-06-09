package com.zeriter.reqAndResp;

import lombok.Data;

import java.util.List;
@Data
public class ListBlogs {
    private List<Blog> blogs;
    private long count;

}
