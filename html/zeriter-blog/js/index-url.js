$(function(){
    $.ajax({
        url:'http://localhost:8111/tag/list',
        type: "GET",
        dataType: "json",
        contentType : "application/json;charsetset=UTF-8",//必须
        success: function(data) {
            $('.m-lable').html('');
            var itemHtml="";
            data.data.forEach(element => {
                itemHtml = itemHtml + "<a href=\"#\" target=\"_blank\" class=\"ui teal basic left pointing label m-margin-tiny\">"
                            +element.tagName+
                            "<div class=\"detail\">"+1+"</div></a>"
            });
            $('.m-lable').html(itemHtml);
        }
    })
    $.ajax({
        url:'http://localhost:8111/tag/list',
        type: "GET",
        dataType: "json",
        contentType : "application/json;charsetset=UTF-8",//必须
        success: function(data) {
            $('.m-group').html('');
            var itemHtml="";
            data.data.forEach(element => {
                itemHtml = itemHtml + "<a class=\"item\" href=\"#\">"+
                           element.tagName+"<div class=\"ui teal basic left pointing label\">"+
                           1+"</div></a>"
            });
            $('.m-group').html(itemHtml);
        }
    })
    $.ajax({
        url:'http://localhost:8111/blog/list',
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
                            "https://unsplash.it/100/100?image=1005\""+
                            " class=\"ui avatar image\"><div class=\"content\"><a href=\"#\" class=\"header\">"+"白墨"+
                            "</a></div></div><div class=\"item\"><i class=\"calendar icon\"></i>2020-01-20"+
                            "</div><div class=\"item\"><i class=\"eye icon\"></i>100</div></div></div><div class=\"right aligned five wide column\"><a href=\"#\" target=\"_blank\" class=\"ui teal basic label\">升级认证</a></div></div></div><div class=\"five wide column\"><a href=\"#\" target=\"_blank\"><img src=\"https://unsplash.it/800/450?image=1005\" class=\"ui rounded image\"></a></div></div></div>"
            });
            itemHtml = itemHtml +"</div><div class=\"ui bottom attached segment\"><div class=\"ui middle aligned two column grid\"><div class=\"column\"><a href=\"#\" class=\"ui mini teal basic button\">上一页</a></div><div class=\"right aligned column\"><a href=\"#\" class=\"ui mini teal basic button\">下一页</a></div></div></div>"
            $('.m-main').html(itemHtml);
        }
    })
})