<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增用户信息</h2>
        <div class="clearfix"></div>
      </div>
      <div class="x_content">
           <div class="clearfix"></div>
        <form id="addUserForm" class="form-horizontal form-label-left" action="addUser" method="post" enctype="multipart/form-data">
          <input id="createdUserId" name="createdUserId" type="hidden" value="${userSession.id}"/>

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="account">账号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="account" class="form-control col-md-7 col-xs-12"
               data-validate-length-range="20" data-validate-words="1" name="account"  required="required"
               placeholder="请输入登录账号" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userName">用户名 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="userName" class="form-control col-md-7 col-xs-12"
              	data-validate-length-range="20" data-validate-words="1" name="userName"   required="required"
              	placeholder="请输入用户名" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password">密码 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="password" class="form-control col-md-7 col-xs-12" name="password"
              	data-validate-length-range="20" data-validate-words="1"   required="required"
              	placeholder="请输入密码" type="password">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="pwd">确认密码 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="pwd" class="form-control col-md-7 col-xs-12"
                     data-validate-length-range="20" data-validate-words="1"   required="required"
                     placeholder="请输入密码" type="password">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userType">用户类型 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="userType" id="userType" class="form-control" onchange="userTypeFun()" required="required"> </select>
            </div>
          </div>
          <div class="item form-group" id="departmentIdDiv" style="display: none;">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="departmentId">就诊科室 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="departmentId" id="departmentId" class="form-control" > </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userImg">用户头像 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="file" class="form-control col-md-7 col-xs-12" name="userImg"  required="required" id="userImg"/>
              ${fileUploadError }
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
<script src="${pageContext.request.contextPath }/statics/localjs/userAdd.js"></script>