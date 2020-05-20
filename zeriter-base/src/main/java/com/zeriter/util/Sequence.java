package com.zeriter.util;

import java.util.Date;

public class Sequence {
    private static Integer num = 0;
    public static  String getMenuIdSeq(){
        Date now = new Date();
        return "menu_"+seqSuffix();
    }
    public static  String getMenuCodeSeq(){
        Date now = new Date();
        return "menu_code_"+seqSuffix();
    }
    public static  String getTagSeq(){
        Date now = new Date();
        return "tag_"+seqSuffix();
    }
    public static  String getCommentSeq(){
        Date now = new Date();
        return "comment_"+seqSuffix();
    }

    public static String seqSuffix() {
        Date now = new Date();
        return ""+now.getYear()+now.getMonth()+now.getDay()+now.getHours()+now.getMinutes()+now.getSeconds()+num;
    }
}
