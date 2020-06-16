// 页面加载
$(function(){
    loadPage.getGroupList();
    loadPage.getTagList();
})

var loadPage = {
    getGroupList:function(){
        $.ajax({
            url:'/zblog/group/list',
            type: "GET",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                $('#group').html('');
                var itemHtml="";
                data.data.groups.forEach(element => {
                    itemHtml = itemHtml + "<option value=\""+element.groupId+"\">"+element.groupName+"</option>"
                });
                $('#group').html(itemHtml);
            }
        })
    },
    getTagList:function(){
        $.ajax({
            url:'/zblog/tag/list',
            type: "GET",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                $('#label').html('');
                var itemHtml="";
                data.data.forEach(element => {
                    itemHtml = itemHtml + "<input id=\"input"+element.tagId+"\" class=\"input\" type=\"checkbox\" name=\"labels\" style=\"display:none;\" value = \""+element.tagId+"\"/>"+
                   "<label for=\"input"+element.tagId+"\" target=\"_blank\" class=\"ui left pointing label m-margin-tiny\" style=\"margin-left: 10px;\" onclick=\"mtoggle(this)\" id = \"label"+element.tagId+"\">"+element.tagName+"</label>"
                });
                $('#label').html(itemHtml);
            }
        })
    },

}
// 添加拼接分组
function appendGroup(){
    $('.addGroup').html('');
    $('.addGroup').html("<div class=\"field item\">"+
    "<div class=\"ui icon input\">"+
        "<input type=\"text\" id=\"groupName\" placeholder=\"add...\">"+
        "<i class=\"add link icon\" onclick=\"addGroup()\"></i>"+
    "</div>"+
    "</div>")
}
// 添加分组请求
function addGroup(){
    var groupName = $("#groupName").val();
    if (groupName==null|| groupName=="") {
        alert("不能为空");
        $('.addGroup').html('');
        $('.addGroup').html("<a class=\"item\" onclick=\"appendGroup()\"><i class=\"add circle icon\"></i></a>");
    } else {

        $.ajax({
            url:'/zblog/group/group',
            type: "PUT",
            data: "{\"groupName\":\""+ groupName.trim()+"\"}",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                if(data.code==200){
                    alert("添加成功")
                    $('.addGroup').html('');
                    $('.addGroup').html("<a class=\"item\" onclick=\"appendGroup()\"><i class=\"add circle icon\"></i></a>");
                    loadPage.getGroupList();
                }else if(data.code==201){
                    alert("添加失败，失败原因"+data.message);
                }
              
            }
        }) 
    }
    
 }

function mtoggle(doc) {
    $(doc).toggleClass('blue');
}
function appendLabel(){
    $('.addLabel').html('');
    $('#label').append("<div class=\"field item\" id=\"addLabel\">"+
    "<div class=\"ui icon input\">"+
        "<input type=\"text\" id=\"labelName\" placeholder=\"add...\">"+
        "<i class=\"add link icon\" onclick=\"addLabel()\"></i>"+
    "</div>"+
    "</div>");
 }
 function addLabel(){
    var tagName = $("#labelName").val();
    if (tagName==null|| tagName=="") {
        alert("不能为空");
        $("#addLabel").remove()
                $('.addLabel').html('');
                $('.addLabel').html("<a class=\"item\" onclick=\"appendLabel()\"><i class=\"add circle icon\"></i></a>");
    } else {
        $.ajax({
            url:'/zblog/tag/tag',
            type: "PUT",
            data:"{\"tagName\":\""+tagName.trim()+"\"}",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                if(data.code==200){
                    alert("添加成功")
                    $("#addLabel").remove()
                    $('.addLabel').html('');
                    $('.addLabel').html("<a class=\"item\" onclick=\"appendLabel()\"><i class=\"add circle icon\"></i></a>");
                    loadPage.getTagList();
                }else if(data.code==201){
                    alert("添加失败，失败原因"+data.message);
                }
               
            }
        }) 
    }
    
  }

$("#title").blur(function(){
    title = $("#title").val().trim();
    if(title==null||title==""){
        alert("请输入文章标题");
    } 
});
// $("input[name='type']:checked").click(function(){
//     $(this).prop("checked","checked");
// })

$("#subnow").click(function(){
    title = encodeURIComponent($("#title").val().trim());
    content = encodeURIComponent($("#content").val());
    var blogType = $(":radio:checked").val(); 
    var groupId = $("#group").val();
    var labels = ""; 
    if(title==null||title==""){
        alert("请输入文章标题");
    }else if(content==null||content==""){
        alert("请输入文章内容");
    }else if(blogType ==null||blogType==""|| blogType==undefined){
        alert("请选择文章类型");
    }else if(groupId ==null||groupId==""|| groupId==undefined){
        alert("请选择文章分组");
    }else{
        $.each($('input:checkbox:checked'),function(){
            labels = labels+ $(this).val()+";";
        });
        if(labels ==null||labels==""|| labels==undefined){
            alert("请选择文章标签");
        }else{
            //增加博客
            $.ajax({
                url:'/zblog/blog/blog',
                type: "PUT",
                data:"{\"title\":\""+title.trim()+"\","+"\"content\":\""+content+"\","+"\"blogType\":\""+blogType+"\","+"\"groupId\":\""+groupId+"\","+"\"labels\":\""+labels+"\"}",
                dataType: "json",
                contentType : "application/json;charsetset=UTF-8",//必须
                success: function(data) {
                    if(data.code==200){
                        alert("添加成功")
                        window.location.href="/zeriter-blog/article.html?key="+data.data;  
                    }else if(data.code==201){
                        alert("添加失败，失败原因"+data.message);
                    }
                
                }
            }) 
        }
    }
   
   
    

});