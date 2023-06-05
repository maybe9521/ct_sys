<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="page-title">
	<div class="title_left">
		<h3>
			欢迎你：${userSession.userName }<strong> | 用户类型：${userSession.userTypeName}</strong>
		</h3>
		<img src="${pageContext.request.contextPath }/statics/images/main.jpg">
	</div>
</div>
<div class="clearfix"></div>
<%@include file="common/footer.jsp"%>
