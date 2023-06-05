<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>创建就诊卡</h2>
        <div class="clearfix"></div>
      </div>
      <div class="x_content">
       <div class="clearfix"></div>
        <form id="addPatientForm" class="form-horizontal form-label-left" action="createVisitCard" method="post">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">病人姓名 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="name" class="form-control col-md-7 col-xs-12"
               data-validate-length-range="20" data-validate-words="1" name="name"  required="required"
               placeholder="请输入病人姓名" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">手机号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="phone" class="form-control col-md-7 col-xs-12"
              	data-validate-length-range="20" data-validate-words="1" name="phone"   required="required"
              	placeholder="请输入手机号" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">家庭住址 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="address" class="form-control col-md-7 col-xs-12" name="address"
              	data-validate-length-range="20" data-validate-words="1"   required="required"
              	placeholder="请输入家庭住址" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="idMedicare">医保卡号 <span class="required"></span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="idMedicare" class="form-control col-md-7 col-xs-12" name="idMedicare"
                     data-validate-length-range="20" data-validate-words="1"
                     placeholder="请输入医保卡号" type="text"><span id="idMedicareSpan" style="color: red"></span>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="idCard">身份证号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12" >
              <input id="idCard" class="form-control col-md-7 col-xs-12" name="idCard"
                     data-validate-length-range="20" data-validate-words="1"   required="required"
                     placeholder="请输入身份证号" type="text" onblur=""><span id="idCardSpan" style="color: red"></span>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="relatives_birthday">出生日期 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" name="birthday" id="relatives_birthday"
                     class="form-control col-md-7 col-xs-12" data-validate-length-range="20" data-validate-words="1" >
              <input type="text" class="form-control" id="relatives_birthdayShow" disabled="disabled">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="relatives_genderSelect">性别 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" name="sex" id="relatives_gender"
                     class="form-control col-md-7 col-xs-12" data-validate-length-range="20" data-validate-words="1"  />
              <select id="relatives_genderSelect" class="form-control" disabled="disabled">
                <option value=""></option>
                <option value="1">女</option>
                <option value="2">男</option>
              </select>
            </div>
          </div>

          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/patientAdd.js"></script>