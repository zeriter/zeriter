$(function(){
    loadPage.getCountAndBlogList(loadPage.pageNum,loadPage.pageSize);
    loadPage.getGroupList();
    // $.ajax({
    //     url:'http://localhost:8111/tag/list',
    //     type: "GET",
    //     dataType: "json",
    //     contentType : "application/json;charsetset=UTF-8",//必须
    //     success: function(data) {
    //         $('.m-lable').html('');
    //         var itemHtml="";
    //         data.data.forEach(element => {
    //             itemHtml = itemHtml + "<a href=\"#\" target=\"_blank\" class=\"ui teal basic left pointing label m-margin-tiny\">"
    //                         +element.tagName+
    //                         "<div class=\"detail\">"+1+"</div></a>"
    //         });
    //         $('.m-lable').html(itemHtml);
    //     }
    // })
    // $.ajax({
    //     url:'http://localhost:8111/tag/list',
    //     type: "GET",
    //     dataType: "json",
    //     contentType : "application/json;charsetset=UTF-8",//必须
    //     success: function(data) {
    //         $('.m-group').html('');
    //         var itemHtml="";
    //         data.data.forEach(element => {
    //             itemHtml = itemHtml + "<a class=\"item\" href=\"#\">"+
    //                        element.tagName+"<div class=\"ui teal basic left pointing label\">"+
    //                        1+"</div></a>"
    //         });
    //         $('.m-group').html(itemHtml);
    //     }
    // })
   
})
var loadPage = {
    "pageNum": 1,
    "pageSize": 5,

    // 获取主页博客列表
    getCountAndBlogList:function(pageNum,pageSize) {
       param = {
           "pageNum":pageNum,
           "pageSize":pageSize
       }
        $.ajax({
            url:'/zblog/blog/list',
            data: param,
            type: "GET",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                $('.m-main').html('');
                var itemHtml="<div class=\"ui top attached segment\">"+
                             "<div class=\"ui middle aligned two column grid\">"+
                             "<div class=\"column\">"+
                             "<div class=\"ui teal header\">博客</div>"+
                             "</div>"+
                             "<div class=\"right aligned column\">"+
                             "共 <h2 class=\"ui orange header m-inline-block\">"+data.data.count+
                             "</h2>篇</div></div></div>"+"<div class=\"ui attached segment\">";
                data.data.blogs.forEach(element => {
                    time = element.createDate;
                    itemHtml = itemHtml +
                                "<div class=\"ui padded vertical segment\">"+
                                "<div class=\"ui mobile reversed stackable grid\">"+
                                "<div class=\"eleven wide column\">"+
                                "<h3 class=\"ui header\"><a href=\"article.html\">"+ element.blogTitle+
                                "</a></h3>"+
                                "<p class=\"m-text\">"+element.blogContent+
                                "</p><div class=\"ui grid\">"+
                                "<div class=\"eleven wide column\"><div class=\"ui horizontal link list\"><div class=\"item\">"+
                                "<img src=\""+
                                "img/1005-100x100.jpg\""+
                                " class=\"ui avatar image\"><div class=\"content\"><a href=\"#\" class=\"header\">"+"白墨"+
                                "</a></div></div><div class=\"item\"><i class=\"calendar icon\"></i>"+formatTime(time)+
                                "</div><div class=\"item\"><i class=\"eye icon\"></i>"+element.click+"</div></div></div></div></div><div class=\"five wide column\"><a href=\"#\" target=\"_blank\"><img src=\"img/1005-800x450.jpg\" class=\"ui rounded image\"></a></div></div></div>"
                });
                itemHtml = itemHtml +"</div><div class=\"ui bottom attached segment\"><div class=\"ui middle aligned two column grid\"><div class=\"column\"><a href=\"#\" class=\"ui mini teal basic button\">上一页</a></div><div class=\"right aligned column\"><a href=\"#\" class=\"ui mini teal basic button\">下一页</a></div></div></div>"
                $('.m-main').html(itemHtml);
            }
        })
    },
    // 获取分组列表
    getGroupList:function(){
        $.ajax({
            url:'/zblog/group/list',
            type: "GET",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                $('.m-group').html('');
                var itemHtml="";
                data.data.groups.forEach(element => {
                    itemHtml = itemHtml + "<a class=\"item\" href=\"#\">"+
                            element.groupName+"<div class=\"ui teal basic left pointing label\">"+
                            element.count+"</div></a>"
                });
                $('.m-group').html(itemHtml);
            }
        })
    }

}
//格式化时间
function formatTime(date){
         var arr=date.split("T");
         var d=arr[0];
       var darr = d.split('-');
    
       var t=arr[1];
       var tarr = t.split('.000');
       var marr = tarr[0].split(':');
    
       var dd = parseInt(darr[0])+"-"+parseInt(darr[1])+"-"+parseInt(darr[2])+" "+parseInt(marr[0])+":"+parseInt(marr[1])+":"+parseInt(marr[2]);
     return dd;
    }