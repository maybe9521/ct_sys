$(function(){

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

				// 回显查询条件就诊科室
				var queryDepartmentId = $("#queryDepartmentId").val();
				$("#departmentId ").val(queryDepartmentId);
				// console.log(queryDepartmentId);

				if(queryDepartmentId != 0){
					$.ajax({
						type: "POST",//请求类型
						url: projectName + "/api/users/getDoctorList.json",//请求的url
						data:{departmentId:queryDepartmentId},
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
								// console.log(queryDoctorId);
								$("#doctorId ").val(queryDoctorId);
							} else {
								alert("就诊医生查询失败");
							}
						},
						error:function(){//当访问时候，404，500 等非200的错误状态码
							alert("就诊医生查询失败");
						}
					});
				}
			}
		},
		error:function(){//当访问时候，404，500 等非200的错误状态码
			alert("加载用户类型失败！");
		}
	});

});
// 根据就诊科室查询就诊医生列表
function departmentFun() {
	var departmentId = $('select option:selected').val();

	if(departmentId != 0){
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
				} else {
					alert("就诊医生查询失败");
				}
			},
			error:function(){//当访问时候，404，500 等非200的错误状态码
				alert("就诊医生查询失败");
			}
		});
	}
}

// 查看详情按钮事件
$('.viewRegister').on("click", function () {
	let id = $(this).data('down');
	window.location.href= projectName + "/api/register/registerView/"+ id;
})