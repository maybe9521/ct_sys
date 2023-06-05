<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>挂号信息管理</h2>
				<div class="clearfix"></div>
			</div>

			<div class="x_content">
				<form method="post" action="registerInfoList">
					<input type="hidden" name="pageNo" value="1" />
					<input type="hidden" id="queryDoctorId" value="${queryDoctorId}">
					<input type="hidden" id="departmentId" name="departmentId" value="${userSession.departmentId}">

			    <ul>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">身份证号</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input name="idCard" type="text" class="form-control col-md-7 col-xs-12" value="${queryIdCard}">
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">挂号医师</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="doctorId" name="userId" class="form-control">
									<option value="">--请选择--</option>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">挂号单状态</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="status" name="status" class="form-control" required>
									<option <c:if test="${queryStatus == 0 }">selected="selected"</c:if> value="0">--请选择--</option>
									<option <c:if test="${queryStatus == 1 }">selected="selected"</c:if> value="1">已挂号，未问诊</option>
									<option <c:if test="${queryStatus == 2 }">selected="selected"</c:if> value="2">正在问诊</option>
									<option <c:if test="${queryStatus == 3 }">selected="selected"</c:if> value="3">问诊结束</option>
        						</select>
							</div>
						</div>
					</li>
					<li><button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button></li>
				</ul>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_content">
				<p class="text-muted font-13 m-b-30"></p>
				<div id="datatable-responsive_wrapper"
					 class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row">
						<div class="col-sm-12">
							<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
								   cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
								<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="First name: activate to sort column descending"
										aria-sort="ascending">挂号单编号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										病人姓名</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										性别</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										身份证号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										就诊科室</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										挂号医师</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										挂号时间</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										创建时间</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										挂号单状态</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 124px;"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach var="registry" items="${registryList }" varStatus="status">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${registry.id}</td>
										<td>${registry.patientName }</td>
										<td>${registry.patientSexName }</td>
										<td>${registry.patientIdCard }</td>
										<td>${registry.departmentName }</td>
										<td>${registry.doctorName }</td>
										<td>${registry.registryTime }</td>
										<td>${registry.createdTime }</td>
										<td>${registry.statusName }</td>
										<td>
											<div class="btn-group">
												<c:choose>
													<c:when test="${registry.status == 1 || registry.status == 2}">
														<button data-down="${registry.id}" type="button" class="consultationAdd">开始问诊</button>
													</c:when>
												</c:choose>
												<button data-down="${registry.id}" type="button" class="viewRegister">查看详情</button>
											</div>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5">
							<div class="dataTables_info" id="datatable-responsive_info"
								 role="status" aria-live="polite">共${pages.total }条记录
								${pages.pageNo }/${pages.pages }页</div>
						</div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								 id="datatable-responsive_paginate">
								<ul class="pagination">
									<c:if test="${pages.pageNo > 1}">
										<li class="paginate_button previous"><a
												href="javascript:page_nav(document.forms[0],1);"
												aria-controls="datatable-responsive" data-dt-idx="0"
												tabindex="0">首页</a>
										</li>
										<li class="paginate_button "><a
												href="javascript:page_nav(document.forms[0],${pages.pageNo-1});"
												aria-controls="datatable-responsive" data-dt-idx="1"
												tabindex="0">上一页</a>
										</li>
									</c:if>
									<c:if test="${pages.pageNo < pages.pages }">
										<li class="paginate_button "><a
												href="javascript:page_nav(document.forms[0],${pages.pageNo+1 });"
												aria-controls="datatable-responsive" data-dt-idx="1"
												tabindex="0">下一页</a>
										</li>
										<li class="paginate_button next"><a
												href="javascript:page_nav(document.forms[0],${pages.pages });"
												aria-controls="datatable-responsive" data-dt-idx="7"
												tabindex="0">最后一页</a>
										</li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/registerInfoList.js"></script>