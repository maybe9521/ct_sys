$(function(){
	let departmentId = $("#departmentId").val();

	// 动态加载就诊医生列表
	$.ajax({
		type: "POST",//请求类型
		url: projectName + "/api/users/getDoctorList.json",//请求的url
		data:{departmentId:departmentId},
		dataType: "json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data.code == 200){
				data = data.data;
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					options += "<option value=\""+data[i].id+"\" >"+data[i].userName+"</option>";
				}
				$("#doctorId").html(options);

				// 回显查询条件就诊医师
				var queryDoctorId = $("#queryDoctorId").val();
				$("#doctorId").val(queryDoctorId);
			} else {
				alert("就诊医生查询失败");
			}
		},
		error:function(){//当访问时候，404，500 等非200的错误状态码
			alert("就诊医生查询失败");
		}
	});
});

// 查看详情按钮事件
$('.viewRegister').on("click", function () {
	let id = $(this).data('down');
	window.location.href= projectName + "/api/register/registerView/"+ id;
})

// 开始问诊按钮事件
$('.consultationAdd').on("click", function () {
	let id = $(this).data('down');
	window.location.href= projectName + "/api/consultation/consultationAdd?id=" + id;
})