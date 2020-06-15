$(function(){
    loadPage.getArticle();
})
var loadPage = {
    getArticle:function(){
        blogId = window.location.href.split("=")[1],
        $.ajax({
            url:'/zblog/blog/'+blogId,
            type: "GET",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
               if(data.code ==200){
                $("#articleTime").html("<i class=\"calendar icon\"></i>"+formatTime(data.data.blog.createDate));
                $("#articleEye").html("<i class=\"eye icon\"></i>"+data.data.blog.click);
                if(data.data.blog.blogType=="1"){
                    $("#articleType").html("原创")
                }else if(data.data.blog.blogType=="2"){
                    $("#articleType").html("转载")
                }else if(data.data.blog.blogType=="3"){
                    $("#articleType").html("翻译")
                }
                $("#articleTitle").html(decodeURIComponent(data.data.blog.blogTitle ));
                
                $("#test-editormd-view2").html("<textarea id=\"append-test\" style=\"display:none;\">"+decodeURIComponent(data.data.blog.blogContent)+"</textarea>"   );
                var show, 
                show = editormd.markdownToHTML("test-editormd-view2", {
                    htmlDecode      : "style,script,iframe",  // you can filter tags decode
                    emoji           : true,
                    taskList        : true,
                    tex             : true,  // 默认不解析
                    flowChart       : true,  // 默认不解析
                    sequenceDiagram : true,  // 默认不解析
                });
                // tags
                var itemHtml = ""
                data.data.tags.forEach(element => {
                    time = element.createDate;
                    itemHtml = itemHtml +
                       "<div class=\"ui  basic teal left pointing label\" >"+element.tagName+"</div>"
                });
                $("#tags").html(itemHtml)
               }
            }
        })
    },
}

//格式化时间
function formatTime(date){
         var arr=date.split("T");
         var d=arr[0];
       var darr = d.split('-');
    
       var t=arr[1];
       var tarr = t.split('.000');
       var marr = tarr[0].split(':');
    
       var dd = parseInt(darr[0])+"-"+parseInt(darr[1])+"-"+parseInt(darr[2]);
     return dd;
    }