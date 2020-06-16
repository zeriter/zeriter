$(function(){
    loadPage.getCountAndBlogList(loadPage.pageNum,loadPage.pageSize);
    loadPage.getGroupList();
    loadPage.getTagList();
    loadPage.getTop4();   
})
var loadPage = {
    "pageNum": 1,
    "pageSize": 5,
    "count":0,

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
                loadPage.count = data.data.count;
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
                    var string = decodeURIComponent(element.blogContent);
                    var blogContent;
                    if (string.length>60) {
                        var subStr = string.substring(0,200);
                        blogContent = subStr + (string.length > 200 ? '...': '');
                    }else{
                        blogContent =  string;
                    }
                    itemHtml = itemHtml +
                                "<div class=\"ui padded vertical segment\">"+
                                "<div class=\"ui mobile reversed stackable grid\">"+
                                "<div class=\"eleven wide column\">"+
                                "<h3 class=\"ui header\"><a href=\"article.html?key="+element.blogId+"\">"+ decodeURIComponent(element.blogTitle)+
                                "</a></h3>"+
                                "<p class=\"m-text\">"+blogContent+
                                "</p><div class=\"ui grid\">"+
                                "<div class=\"eleven wide column\"><div class=\"ui horizontal link list\"><div class=\"item\">"+
                                "<img src=\""+
                                "img/1005-100x100.jpg\""+
                                " class=\"ui avatar image\"><div class=\"content\"><a href=\"#\" class=\"header\">"+"白墨"+
                                "</a></div></div><div class=\"item\"><i class=\"calendar icon\"></i>"+formatTime(time)+
                                "</div><div class=\"item\"><i class=\"eye icon\"></i>"+element.click+"</div></div></div></div></div><div class=\"five wide column\"><a href=\"#\" target=\"_blank\"><img src=\"img/1005-800x450.jpg\" class=\"ui rounded image\"></a></div></div></div>"
                });
                itemHtml = itemHtml +"</div><div class=\"ui bottom attached segment\"><div class=\"ui middle aligned two column grid\"><div class=\"column\"><a class=\"ui mini teal basic button\" onclick=\"prev()\" id=\"prevBtu\">上一页</a></div><div class=\"right aligned column\"><a class=\"ui mini teal basic button\"  onclick = \"next()\" id = \"nextBtu\">下一页</a></div></div></div>"
                $('.m-main').html(itemHtml);
                // 判断上一页下一页是否展示
                countNum = loadPage.count;
                size = loadPage.pageSize;
                num = loadPage.pageNum
                if(countNum/size<=1){
                    $("#prevBtu").hide();
                    $("#nextBtu").hide();
                }else if(num==1){
                    $("#prevBtu").hide();
                }else if (countNum/size<=num && countNum/size>num-1){
                    $("#nextBtu").hide();
                }else {
                    $("#prevBtu").show();
                    $("#nextBtu").show();
                }
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
    },
    // 获取标签
    getTagList:function () {
        $.ajax({
            url:'/zblog/tag/list',
            type: "GET",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                $('.m-tag').html('');
                var itemHtml="";
                data.data.forEach(element => {
                    itemHtml = itemHtml + "<a class=\"item\" href=\"#\">"
                            +"<div class=\"ui teal basic left pointing label\">"+
                            element.tagName+"</div></a>"
                });
                $('.m-tag').html(itemHtml);
            }
        })
    },
    // 获取top4
    getTop4:function() {
        $.ajax({
            url:'/zblog/blog//top4',
            type: "GET",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                $('.top4').html('');
                var itemHtml="";
                data.data.blogs.forEach(element => {
                    var title =  decodeURIComponent(element.blogTitle);
                    var blogtitle;
                    if (title.length>23) {
                        var subStr = title.substring(0,23);
                        blogtitle = subStr + (title.length > 23 ? '...': '');
                    }else{
                        blogtitle =  title;
                    }
                    itemHtml = itemHtml + "<a class=\"item\" href=\"#\">"+
                    blogtitle+"<div class=\"ui teal basic left pointing label\"><i class=\"heart icon\"></i>"+element.click+"</div>"
                            +"</a>"
                });
                $('.top4').html(itemHtml);
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
function prev(){
    loadPage.getCountAndBlogList(loadPage.pageNum-1,loadPage.pageSize);
    
    loadPage.pageNum = loadPage.pageNum-1;
    console.log("prevBtu");
}
function next(){
    debugger;
    loadPage.getCountAndBlogList(loadPage.pageNum+1,loadPage.pageSize);
    loadPage.pageNum = loadPage.pageNum+1;
    console.log("nextBtu");
}