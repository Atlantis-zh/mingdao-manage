<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common_css.jsp"%>



</head>
<body class="no-skin">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="#">微信用户</a>
				</li>
				<li class="active">微信关注列表</li>
			</ul>
		</div>
		<div class="page-content">


			<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>头像</th>
										<th>用户昵称</th>
										<th>状态</th>
										<th>性别</th>
										<th>城市</th>
										<th>省份</th>
										<th>国家</th>
										<th>关注时间</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${datas.datas}" var="userInfo">
									<tr>
										<td><img src="${userInfo.headimgurl}" style="width:40px;height:40px;"/></td>
										<td>
											${userInfo.nickname}
										</td>
										<td>
											<c:if test="${userInfo.subscribe eq '0' }">
												无效
											</c:if>
											<c:if test="${userInfo.subscribe eq '1' }">
												有效
											</c:if>
										</td>
										<td>
											<c:if test="${userInfo.sex eq '0' }">
												女
											</c:if>
											<c:if test="${userInfo.sex eq '1' }">
												男
											</c:if>
										</td>
										<td>${userInfo.city}</td>
										<td>${userInfo.province}</td>
										<td>${userInfo.country }</td>

										<td>${userInfo.subscribe_time }</td>


									</tr>
								</c:forEach>
								</tbody>
							</table>
							<div class="page-header position-relative">
								<table style="width: 100%;">
									<tbody>
									<tr>
										<td style="vertical-align: top;">
											<c:if test="${datas.total > 0}">
												<jsp:include page="/jsp/pager.jsp">
													<jsp:param value="${datas.total }" name="totalRecord"/>
													<jsp:param value="careLists" name="url"/>
												</jsp:include>
											</c:if>
										</td>
									</tr>
									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>






<%@ include file="../common/common_js.jsp"%>

<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.bootstrap.js"></script>


</body>
</html>