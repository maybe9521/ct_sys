let pathname = window.location.pathname;
let projectName = pathname.substring(0, pathname.substr(1).indexOf('/') + 1);
if(projectName == "/api"){
    projectName = "";
}
$(function () {
    var userId = $("#div_userId").text();
    $.ajax({
        type:"GET",//请求类型
        url: projectName + "/api/auth/getMenuList.json",//请求的url
        data:{userId:userId},
        async: false,
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            if(data.code == 200){
                // var menuHtml = "<li><a><i class='fa fa-home'></i> 菜单管理 <span class='fa fa-chevron-down'></span></a><ul class='nav child_menu'><li><a href='javascript:;'>菜单1</a></li><li><a href='javascript:;'>菜单2</a></li></ul></li>";

                var menuList = data.data;
                var menuHtml = "";
                for(var i in menuList){
                    // 拼接父菜单
                    menuHtml += "<li><a><i class=\"fa fa-home\"></i>" + menuList[i].menuName + "<span class=\"fa fa-chevron-down\"></span></a>";
                    // console.log(menuList[i].subMenus);
                    // 拼接子菜单subMenuUrl
                    if(menuList[i].subMenus.length != 0){
                        menuHtml += "\t<ul class=\"nav child_menu\">";
                        for(var j in menuList[i].subMenus){
                            // console.log(menuList[i].subMenus[j].subMenuName);
                            menuHtml += "\t\t<li><a href=\"" + projectName + menuList[i].subMenus[j].subMenuUrl + "\">" + menuList[i].subMenus[j].subMenuName + "</a></li>";
                        }
                        menuHtml += "\t\t</ul>";
                    }
                    menuHtml += "</li>";
                }
                // console.log(menuHtml);
                $("#menus_ul").append(menuHtml);
            } else {
                alert("菜单列表加载失败！");
            }
        },
        error:function(data){//当访问时候，404，500 等非200的错误状态码
            alert("菜单列表加载失败！");
        }
    });

})
