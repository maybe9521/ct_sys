$(function(){
    // 验证密码是否一致
    $("#pwd").on("blur",function () {
        if($("#password").val() != $("#pwd").val()){
            alert("两次输入的密码不一致");
        }
    });

    // 验证用户名是否重复
    $("#account").bind("blur",function () {
        $.ajax({
            type:"GET",
            url: projectName + "/api/users/accountExist.json",
            data:{account:$("#account").val()},
            dataType:"json",
            success:function (data) {
                if(data.code != null && data.code != 200){
                    alert("该用户账号已存在，不能使用！");
                }
            }
        })
    });

    //动态加载用户类型列表
    $.ajax({
        type:"GET",//请求类型
        url: projectName + "/api/auth/getRoleList.json",//请求的url
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            if(data.code == 200){
                data = data.data;
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
                }
                $("#userType").html(options);
            }
        },
        error:function(){//当访问时候，404，500 等非200的错误状态码
            alert("加载用户类型失败！");
        }
    });

    // 返回按钮事件
    $("#back").on("click",function(){
        window.location.href = "list";
    });

});

// 添加用户为门诊医师时，显示就诊科室列表
function userTypeFun() {
    var vs = $('select option:selected').val();
    // 若value为3(3:门诊医师)时
    if(vs == 3){
        // 显示div
        // $("#departmentIdDiv").attr("style","display:block;");
        $("#departmentIdDiv").show();

        //动态加载就诊科室列表json
        $.ajax({
            type:"GET",//请求类型
            url: projectName + "/api/department/getDepartmentList.json",//请求的url
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                if(data.code == 200){
                    data = data.data;
                    var options = "<option value=\"\">--请选择--</option>";
                    for(var i = 0; i < data.length; i++){
                        options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
                    }
                    $("#departmentId").html(options);
                }
            },
            error:function(){//当访问时候，404，500 等非200的错误状态码
                alert("加载用户类型失败！");
            }
        });

    } else {
        // 隐藏div
        // $("#departmentIdDiv").attr("style","display:none;");
        $("#departmentIdDiv").hide();
    }
}