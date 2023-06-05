// 身份证号验证标识
let idCardRes = false;
// 医保卡号验证标识
let idMedicareRes = true;
$(function(){
    // 返回按钮事件
    $("#back").on("click",function(){
        window.location.href = projectName + "/api/users/index";
    });
});

// 提交表单校验
$("#addPatientForm").submit(function () {
    if(!idCardRes || !idMedicareRes){
        return false;
    }
});


// 医保卡号重复校验
$("#idMedicare").on("change",function () {
    let idMedicare = $("#idMedicare").val();
    if(idMedicare != null && idMedicare != ''){
        $.ajax({
            type: "POST",//请求类型
            url: projectName + "/api/patient/getPatientByIdMedicare.json",//请求的url
            data: {idMedicare: idMedicare},
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.code == 200) {
                    var data = data.data;
                    if(data != null){
                        idMedicareRes = false;
                        $("#idMedicareSpan").show();
                        $("#idMedicareSpan").text("该医保卡号已存在，请重新输入...");
                    }
                } else {
                    idMedicareRes = true;
                    $("#idMedicareSpan").hide();
                }
            },
            error:function(){
                alert("就诊卡信息查询失败");
            }
        });
    }
});


// 身份证号重复校验
$('#idCard').on("change",function () {
    var idCard = $("#idCard").val();
    $.ajax({
        type: "POST",//请求类型
        url: projectName + "/api/patient/getPatientByIdCard.json",//请求的url
        data: {idCard: idCard},
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            if (data.code == 200) {
                var data = data.data;
                if(data != null){
                    idCardRes = false;
                    $("#idCardSpan").show();
                    $("#idCardSpan").text("该身份证号已创建就诊卡，请重新输入...");

                }
            } else {
                idCardRes = true;
                $("#idCardSpan").hide();
            }
        },
        error:function(){
            alert("就诊卡信息查询失败");
        }
    });

    // 根据身份证号获取出生日期和性别
    paddingBirthdayAndGender('idCard', 'relatives_birthdayShow', 'relatives_birthday',
        'relatives_gender', 'relatives_genderSelect');
});

// 根据身份证号获取出生日期和性别
function paddingBirthdayAndGender(id_number,id_birthdayShow,id_birthday,id_gender,id_genderSelect){
    $("#"+id_number).blur(function(){
        var IDNo = $(this).val();
        var birthday = "";
        var gender = 2;
        if (IDNo.length == 18) {
            birthday = IDNo.substr(6, 8);
            birthday = dateFormat(birthday);
            // console.log("birthday1:" + birthday);
            if (parseInt(IDNo.substr(16, 1)) % 2 == 0) {
                gender = 1;
            }
        } else if (IDNo.length == 15) {
            birthday = "19" + IDNo.substr(6, 6);
            birthday = dateFormat(birthday);
            // console.log("birthday2:" + birthday);
            if (parseInt(IDNo.substr(14, 1)) % 2 == 0) {
                gender = 1;
            }
        }
        $("#"+id_birthdayShow).val(birthday);
        $("#"+id_birthday).val(birthday);
        $("#"+id_gender).val(gender);
        $("#"+id_genderSelect).val(gender);
    });
}
// 格式化时间  19990825 --> 1999-08-25
function dateFormat(date) {
    // console.log("date:" + date);
    var birthday = "";
    var year = date.substr(0,4);
    var month = date.substr(4,2);
    var day = date.substr(6,2);
    birthday = year + "-" + month + "-" + day;
    // console.log("bir :" + birthday);
    return birthday;
}