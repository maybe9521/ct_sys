// 添加医嘱按钮事件
$("#addMedicalAdvice").on("click",function () {
	let chiefComplaint = $("#chiefComplaint").val();
	let diagnosis = $("#diagnosis").val();
	let registryId = $("#registryId").val();
	let userId = $("#userId").val();
	// console.log("chiefComplaint" + chiefComplaint);
	// console.log("diagnosis" + diagnosis);
	// console.log("registryId" + registryId);

	$.ajax({
		type: "POST",//请求类型
		url: projectName + "/api/consultation/medicalAdviceAdd.json",//请求的url
		data:{registryId:registryId, userId:userId, chiefComplaint:chiefComplaint, diagnosis:diagnosis},
		dataType: "json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data.code == 200){
				alert("添加医嘱成功");
				data = data.data;
				$("#chiefComplaint").val(data.chiefComplaint);
				$("#diagnosis").val(data.diagnosis);
			} else {
				alert("添加医嘱失败");
			}
		},
		error:function(){//当访问时候，404，500 等非200的错误状态码
			alert("添加医嘱失败");
		}
	});
});

$("#back").on("click",function(){
	window.location.href = projectName + "/api/register/registerInfoList";
});

	
	