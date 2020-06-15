package com.zeriter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sequence {
    private static Integer num = 0;
    public static  String getBlogSeq(){
        return "blog_"+seqSuffix();
    }
    public static  String getGroupSeq(){
        return "group_"+seqSuffix();
    }
    public static  String getTagSeq(){
        return "tag_"+seqSuffix();
    }
    public static  String getCommentSeq(){
        return "comment_"+seqSuffix();
    }

    public static String seqSuffix() {
        Date now = new Date();
        return ""+now.getYear()+now.getMonth()+now.getDay()+now.getHours()+now.getMinutes()+now.getSeconds()+num;
    }
}
