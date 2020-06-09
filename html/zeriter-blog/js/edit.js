function appendGroup(){
   $('.addGroup').html('');
$('.addGroup').html("<div class=\"field item\">"+
"<div class=\"ui icon input\">"+
    "<input type=\"text\" id=\"groupName\" placeholder=\"add...\">"+
    "<i class=\"add link icon\" onclick=\"addGroup()\"></i>"+
"</div>"+
"</div>")
}
function addGroup(){
    var groupName = $("#groupName").val();
    if (groupName==null|| groupName=="") {
        alert("不能为空");
        $('.addGroup').html('');
        $('.addGroup').html("<a class=\"item\" onclick=\"appendGroup()\"><i class=\"add circle icon\"></i></a>");
    } else {
        $.ajax({
            url:'http://localhost:8080/group/group',
            type: "PUT",
            data:"{\"name\":\""+groupName+"\"}",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                alert("chenggong dahui ")
                $('.addGroup').html('');
                $('.addGroup').html("<a class=\"item\" onclick=\"appendGroup()\"><i class=\"add circle icon\"></i></a>");
                $('#group').html('');
                var itemHtml="";
                data.data.forEach(element => {
                    itemHtml = itemHtml + "<option value=\""+element.id+"\">"+element.name+"</option>"
                });
                $('#group').html(itemHtml);
            }
        }) 
    }
    
 }

 $(function(){
    $.ajax({
        url:'http://localhost:8080/group/list',
        type: "GET",
        dataType: "json",
        contentType : "application/json;charsetset=UTF-8",//必须
        success: function(data) {
            $('#group').html('');
            var itemHtml="";
            data.data.forEach(element => {
                itemHtml = itemHtml + "<option value=\""+element.id+"\">"+element.name+"</option>"
            });
            $('#group').html(itemHtml);
        }
    })
    $.ajax({
        url:'http://localhost:8080/label/list',
        type: "GET",
        dataType: "json",
        contentType : "application/json;charsetset=UTF-8",//必须
        success: function(data) {
            $('#label').html('');
            var itemHtml="";
            data.data.forEach(element => {
                itemHtml = itemHtml + "<input id=\"input"+element.id+"\" class=\"input\" type=\"checkbox\" name=\"labels\" style=\"display:none;\" value = \""+element.id+"\"/>"+
               "<label for=\"input"+element.id+"\" target=\"_blank\" class=\"ui left pointing label m-margin-tiny\" style=\"margin-left: 10px;\" onclick=\"mtoggle("+element.id+")\" id = \"label"+element.id+"\">"+element.name+"</label>"
            });
            $('#label').html(itemHtml);
        }
    })
})
function mtoggle(id) {
    $("#label"+id).toggleClass('blue');
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
    var labelName = $("#labelName").val();
    if (labelName==null|| labelName=="") {
        alert("不能为空");
        $("#addLabel").remove()
                $('.addLabel').html('');
                $('.addLabel').html("<a class=\"item\" onclick=\"appendLabel()\"><i class=\"add circle icon\"></i></a>");
    } else {
        $.ajax({
            url:'http://localhost:8080/label/label',
            type: "PUT",
            data:"{\"name\":\""+labelName+"\"}",
            dataType: "json",
            contentType : "application/json;charsetset=UTF-8",//必须
            success: function(data) {
                $("#addLabel").remove()
                $('.addLabel').html('');
                $('.addLabel').html("<a class=\"item\" onclick=\"appendLabel()\"><i class=\"add circle icon\"></i></a>");
                $('#label').html('');
            var itemHtml="";
            data.data.forEach(element => {
                itemHtml = itemHtml + "<input id=\"input"+element.id+"\" class=\"input\" type=\"checkbox\" style=\"display:none;\"/>"+
               "<label for=\"input"+element.id+"\" target=\"_blank\" class=\"ui left pointing label m-margin-tiny\" style=\"margin-left: 10px;\" onclick=\"mtoggle("+element.id+")\" id = \"label"+element.id+"\">"+element.name+"</label>"
            });
            $('#label').html(itemHtml);
            }
        }) 
    }
    
  }

// 自定义json格式化表单

(function($){
    $.fn.serializeJson=function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);
   $("#subnow").on("click",function(){
   var form=$("form").serializeJson();
   var title = $("#title").val();
   var content = $("#content").val();
   if(title == null || title == "" || content == null || content == "" ){
       alert("请检查文章内容")
   }else{
    form.title=title;
    form.content=encodeURIComponent(content);
   }
   
   var data = JSON.stringify(form)
//    var arry = $("#form").serializeJson();//序列化表单
   console.log(data)
   $.ajax({
       url:'http://localhost:8080/blog/blog',
       type: "PUT",
       data:data,
       dataType: "json",
       contentType : "application/json;charsetset=UTF-8",//必须
       success: function(data) {
       }
          
   }) 
 });
