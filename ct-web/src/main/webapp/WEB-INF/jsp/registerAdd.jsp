<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>挂号</h2>
        <div class="clearfix"></div>
      </div>
      <div class="x_content">
       <div class="clearfix"></div>
        <form id="addRegisterForm" class="form-horizontal form-label-left" action="register" method="post" >
          <input id="patientId" name="patientId" type="hidden"/>
          <input id="scheduleId" name="scheduleId" type="hidden"/>
          <input id="roomId" name="roomId" type="hidden"/>
          <input id="isMedicare" name="isMedicare" type="hidden"/>


          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="idCard">身份证号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12" >
              <input id="idCard" class="form-control col-md-7 col-xs-12" name="idCard"
                     data-validate-length-range="20" data-validate-words="1"   required="required"
                     placeholder="请输入身份证号" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">病人姓名 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="name" class="form-control col-md-7 col-xs-12"
               data-validate-length-range="20" data-validate-words="1" name="name" type="text" disabled>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">手机号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="phone" class="form-control col-md-7 col-xs-12"
              	data-validate-length-range="20" data-validate-words="1" name="phone" type="text" disabled>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="relatives_birthday">出生日期 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" class="form-control" id="relatives_birthday" disabled>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="relatives_gender">性别 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" name="sex" id="relatives_gender"
                     class="form-control col-md-7 col-xs-12" data-validate-length-range="20" data-validate-words="1" disabled>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">家庭住址 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="address" class="form-control col-md-7 col-xs-12" name="address"
              	data-validate-length-range="20" data-validate-words="1" type="text" disabled>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="departmentId">就诊科室 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="departmentId" id="departmentId" class="form-control" onchange="departmentIdFun()" required> </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="sign">时间段 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select id="sign" name="sign" class="form-control" onchange="signFun()" required>
                <option value="">--请选择--</option>
                <option value="1">上午</option>
                <option value="2">下午</option>
              </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="doctorId">就诊医师 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="userId" id="doctorId" class="form-control" onchange="doctorFun()" required >
                <option value="">--请先选择就诊科室和时间段--</option>
              </select>
            </div>
          </div>
          <div class="item form-group" id="roomNameDiv" style="display: none;">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="roomName">就诊房间 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="roomName" class="form-control col-md-7 col-xs-12"
                     data-validate-length-range="20" data-validate-words="1" type="text" disabled>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="isMedicares">是否使用医保 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-md-offset-3" >
              <button id="isMedicares" type="button" class="btn btn-success" onclick="isMedicareFun()">是</button>
              <button id="noMedicares" type="button" class="btn btn-success" onclick="noMedicareFun()">否</button>
            </div>
          </div>

          <div class="item form-group" id="idMedicareDiv" style="display: none;">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="idMedicare">医保卡号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="idMedicare" class="form-control col-md-7 col-xs-12" name="idMedicare"
                     data-validate-length-range="20" data-validate-words="1"
                     placeholder="请输入医保卡号" type="text" required><span id="idMedicareSpan" style="color: red"></span>
            </div>
          </div>

          <div class="item form-group" id="feeDiv" style="display: none;">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="fee">挂号总金额 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="fee" class="form-control col-md-7 col-xs-12"
                     data-validate-length-range="20" data-validate-words="1" name="fee" type="text" readonly>
            </div>
          </div>
          <div class="item form-group" id="medicareFeeDiv" style="display: none;">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="medicareFee">医保报销额 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="medicareFee" class="form-control col-md-7 col-xs-12"
                     data-validate-length-range="20" data-validate-words="1" name="medicareFee" type="text" readonly>
            </div>
          </div>
          <div class="item form-group" id="payFeeDiv" style="display: none;">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="payFee">实际应支付 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="payFee" class="form-control col-md-7 col-xs-12"
                     data-validate-length-range="20" data-validate-words="1" name="payFee" type="text" readonly>
            </div>
          </div>

          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <button id="send" type="submit" class="btn btn-success" style="visibility: hidden">保存</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/registerAdd.js"></script>