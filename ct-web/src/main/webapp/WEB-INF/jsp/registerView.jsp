<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>查看挂号信息</h2>
          <div class="clearfix"></div>
      </div>
      <div align="center"><h3>病人信息</h3></div>
      <div class="x_content1">
        <form class="form-horizontal form-label-left" >
          <input type="hidden" id="userType" value="${userSession.userType}">

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
        <div align="center"><h3>挂号信息</h3></div>

        <div class="x_content">
            <form class="form-horizontal form-label-left" >

                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >挂号单编号 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input class="form-control col-md-7 col-xs-12" value="${register.id}"
                               type="text" readonly="readonly">
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >就诊科室 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" class="form-control col-md-7 col-xs-12"
                               value="${register.departmentName}" readonly="readonly">
                    </div>
                </div>

                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >就诊房间 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input class="form-control col-md-7 col-xs-12"
                               value="${register.roomName}" type="text" readonly="readonly">
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >挂号医师 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input class="form-control col-md-7 col-xs-12" readonly="readonly"
                               value="${register.doctorName}" type="text">
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >就诊时间 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" value="${register.consultationTime}"
                               class="form-control col-md-7 col-xs-12" readonly="readonly">
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >挂号时间 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" value="${register.registryTime}"
                               class="form-control col-md-7 col-xs-12" readonly="readonly">
                    </div>
                </div>
            </form>
        </div>

        <div class="x_title">
            <div class="clearfix"></div>
        </div>
        <div align="center"><h3>医嘱信息</h3></div>
        <div class="x_content">
            <form class="form-horizontal form-label-left" >
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >病人主诉 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <textarea rows="3" cols="20" readonly="readonly">${medicalAdvice.chiefComplaint}</textarea>
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >诊断结果 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <textarea rows="3" cols="20" readonly="readonly">${medicalAdvice.diagnosis}</textarea>
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >就诊医师 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" value="${medicalAdvice.doctorName}"
                               class="form-control col-md-7 col-xs-12" readonly="readonly">
                    </div>
                </div>
            </form>
        </div>

     <div class="form-group">
        <div class="col-md-6 col-md-offset-3">
          <button type="button" class="btn btn-primary" id="back">返回</button>
        </div>
      </div>
    <div class="clearfix"></div>
    <br/><br/>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/registerView.js"></script>