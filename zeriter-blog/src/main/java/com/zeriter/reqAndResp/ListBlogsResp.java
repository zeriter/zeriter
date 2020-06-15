package com.zeriter.reqAndResp;

import com.zeriter.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListBlogsResp {
    private Integer count;
    private List<Blog> blogs;

}
