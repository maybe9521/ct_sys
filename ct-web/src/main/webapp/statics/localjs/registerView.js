$("#back").on("click",function(){
	let userType = $('#userType').val();
	// 门诊医师
	if(userType == 3){
		window.location.href = projectName + "/api/register/registerInfoList";
	} else {
		window.location.href = projectName + "/api/register/registerList";
	}
	// window.history.go(-1);
});

	
	