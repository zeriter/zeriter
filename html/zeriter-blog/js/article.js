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