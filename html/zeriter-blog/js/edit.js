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
    }else if(!title.match("^[a-zA-Z0-9_\u4e00-\u9fa5]+$")){
        alert("请不要输入特殊字符!");
           $("#title").val("");
        
}
    
});
// $("input[name='type']:checked").click(function(){
//     $(this).prop("checked","checked");
// })

$("#subnow").click(function(){
    title = $("#title").val().trim();
    content = encodeURIComponent($("#content").val());
    if(title==null||title==""){
        alert("请输入文章标题");
    }else if(!title.match("^[a-zA-Z0-9_\u4e00-\u9fa5]+$")){
            alert("请不要输入特殊字符!");
               $("input[name='key']").val("");
            
    }else if(content==null||content==""){
        alert("请输入文章内容");
    }
    // type = $("input[name='type':checked]").val();
    // alert(type);
    
    var blogType = $(":radio:checked").val(); 
    if(blogType ==null||blogType==""|| blogType==undefined){
        alert("请选择文章类型");
    }
    var groupId = $("#group").val();
    if(groupId ==null||groupId==""|| groupId==undefined){
        alert("请选择文章分组");
    }
    var labels = ""; 
    $.each($('input:checkbox:checked'),function(){
        labels = labels+ $(this).val()+";";
    });
    if(labels ==null||labels==""|| labels==undefined){
        alert("请选择文章标签");
    }
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
                $("#addLabel").remove()
                $('.addLabel').html('');
                $('.addLabel').html("<a class=\"item\" onclick=\"appendLabel()\"><i class=\"add circle icon\"></i></a>");
                loadPage.getTagList();
            }else if(data.code==201){
                alert("添加失败，失败原因"+data.message);
            }
           
        }
    }) 

});