<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>疾病问诊</h2>
          <div class="clearfix"></div>
      </div>
      <div align="center"><h3>病人信息</h3></div>
      <div class="x_content1">
        <form class="form-horizontal form-label-left" >
          <input type="hidden" name="id" value="">

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" >姓名 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" value="${register.patientName}"
              type="text" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" >身份证号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" class="form-control col-md-7 col-xs-12" 
              value="${register.patientIdCard}" readonly="readonly">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" >性别 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" 
              	value="${register.patientSexName}" type="text" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" >出生日期 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" readonly="readonly"
              	value="${register.patientBirthday}" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" >家庭住址 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" value="${register.patientAddress}"
              class="form-control col-md-7 col-xs-12" readonly="readonly">
            </div>
          </div>
        </form>
        </div>

        <div class="x_title">
            <div class="clearfix"></div>
        </div>
        <div align="center"><h3>添加医嘱</h3></div>
        <div class="x_content">
            <form class="form-horizontal form-label-left" method="post" action="consultationEnd">
                <input id="registryId" type="hidden" name="registryId" value="${register.id}">
                <input id="userId" type="hidden" name="userId" value="${userSession.id}">

                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >病人主诉 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <textarea id="chiefComplaint" rows="3" cols="100" name="chiefComplaint" required >${medicalAdvice.chiefComplaint}</textarea>
                    </div>
                </div>

                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >诊断结果 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <textarea id="diagnosis" rows="3" cols="100" name="diagnosis" required >${medicalAdvice.diagnosis}</textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-6 col-md-offset-3">
                        <button id="addMedicalAdvice" type="button" class="btn btn-success">添加医嘱</button>
                        <br/><br/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-6 col-md-offset-3">
                        <button  type="submit" class="btn btn-success">问诊结束</button>
                        <button type="button" class="btn btn-primary" id="back">返回</button>
                        <br/><br/>
                    </div>
                </div>
            </form>

        </div>

     <div class="form-group">
        <div class="col-md-6 col-md-offset-3">

        </div>
      </div>
    <div class="clearfix"></div>
    <br/><br/>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/consultationAdd.js"></script>