package com.zeriter.reqAndResp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BlogAddReq {
    private String title;
    private String content;
    private String blogType;
    private String groupId;
    private String labels;

}
