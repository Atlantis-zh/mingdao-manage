<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common_css.jsp"%>



</head>
<body class="no-skin">
	<div class="main-content-inner">
		<!-- #section:basics/content.breadcrumbs -->
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="#">用户管理</a>
				</li>
				<li class="active">用户信息管理</li>
			</ul><!-- /.breadcrumb -->			
		</div>
		<div class="page-content">


			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>用户编码</th>
										<th>用户名称</th>
										<th>用户状态</th>
										<th>所属门店</th>
										<th>手机</th>
										<th>用户邮箱<i class="icon-envelope"/></th>
										<th>用户操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${datas.datas}" var="userInfo">
									<tr>
										<td>
											<a href="#">${userInfo.id }</a>
										</td>
										<td><a href="${userInfo.id }" class="list_link">${userInfo.userName }</a></td>
										<td class="hidden-480">
											<c:if test="${userInfo.status eq '0' }">
												<span class="emp">停用</span>
												<a href="updateStatus/${userInfo.id }" class="list_op">启用</a>
											</c:if>
											<c:if test="${userInfo.status eq '1' }">
												<span>启用</span>
												<a href="updateStatus/${userInfo.id }" class="list_op">停用</a>
											</c:if>
										</td>
										<td>${userInfo.shopId}</td>
										<td>${userInfo.phone}</td>
										<td class="hidden-480">
											<a href="mailto:${userInfo.email }" class="list_link">${userInfo.email }</a><i class="icon-envelope"/>
										</td>

										<td>
									
												<c:if test="${userInfo.status eq '1' }">
													<button class="btn btn-xs btn-success" title="启用"> 
														<i class="ace-icon fa fa-check-square-o bigger-120"></i>
													</button>
												</c:if>
												<c:if test="${userInfo.status eq '0' }">
													<button class="btn btn-xs btn-success" title="停用">
														<i class="ace-icon fa fa-square-o bigger-120"></i>
													</button>
												</c:if>

												<a class="btn btn-xs btn-info" href="update/${userInfo.id }" title="编辑">
													<i class="ace-icon fa fa-pencil bigger-120"></i>
												</a>

												<a class="btn btn-xs btn-danger" href="delete/${userInfo.id }" title="删除">
													<i class="ace-icon fa fa-trash-o bigger-120"></i>
												</a>

												<a class="btn btn-xs btn-success" title="查询管理栏目" href="<%=request.getContextPath() %>/admin/user/listChannels/${userInfo.id }">
													<i class="ace-icon fa fa-eye bigger-120"></i>
												</a>
									
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<div class="page-header position-relative">
								<table style="width: 100%;">
									<tbody>
										<tr>
											<td style="vertical-align: top;">
												<a href="<%=request.getContextPath() %>/user/addUser" target="mainFrame" style="color:#FFF;text-decoration:none;" title="添加用户" class="btn btn-info fa">+</a>
												<a href="#" target="mainFrame" style="color:#FFF;text-decoration:none;" title="搜索" onclick="searchUser(this);" class="btn btn-info fa fa-search orange" data-toggle="modal" ></a>
												<a href="<%=request.getContextPath() %>/user/users" style="color:#FFF;text-decoration:none;" class="btn btn-info fa fa-refresh" title="刷新列表"></a>
											</td>
											<td style="vertical-align: top;">
												<c:if test="${datas.total > 0}">
														<jsp:include page="/jsp/pager.jsp">
														<jsp:param value="${datas.total }" name="totalRecord"/>
														<jsp:param value="users" name="url"/>
													</jsp:include>
												</c:if>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div><!-- /.span -->
					</div><!-- /.row -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div>

	</div>

	<%--begin_zhangfx--%>
	<div class="modal fade" id="searchUser" tabindex="-1" role="dialog" style="width:400px;" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
					<div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="searchhdfbox_grid-table"
						 style="cursor: move;">
							<div class="widget-header">
								<span class="ui-jqdialog-title" style="float: left;">查询条件</span>
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
							</div>

					</div>
					<div class="ui-jqdialog-content ui-widget-content" id="searchcntfbox_grid-table">
						<div>
							<div id="fbox_grid-table" class="searchFilter" style="overflow:auto">
								<table class="group ui-widget ui-widget-content ui-search-table" style="border:0px none;">
									<tbody>
									<tr class="error" style="display:none;">
										<th colspan="3" class="ui-state-error" align="left"></th>
									</tr>

									<tr>
										<td class="first"></td>
										<td class="columns">
											<label>姓名：</label>
										</td>

										<td class="data"><input type="text" id="jqg1" name="myac" role="textbox"
																class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
										</td>
									</tr>
									<tr>
										<td class="first"></td>
										<td class="columns">
											<label>编号：</label>
										</td>

										<td class="data"><input type="text" id="jqg1" name="myac" role="textbox"
																class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
										</td>
									</tr>
									</tbody>
								</table>
							</div>
							<table class="EditTable" style="border:0px none;margin-top:5px;width:400px;" id="fbox_grid-table_2">
								<tbody>
								<tr>
									<td colspan="2">
										<hr class="ui-widget-content" style="margin:1px">
									</td>
								</tr>
								<tr>
									<td class="EditButton" style="text-align:left"><a id="fbox_grid-table_reset"
																					  class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-reset btn btn-sm btn-info"><span
											class="ace-icon fa fa-retweet"></span>重置</a></td>
									<td class="EditButton"><a id="fbox_grid-table_search"
															  class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-search btn btn-sm btn-purple"><span
											class="ace-icon fa fa-search"></span>查询</a></td>
								</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"></div>


			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	<%--//end_zhangfx--%>



<%@ include file="../common/common_js.jsp"%>

<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.bootstrap.js"></script>


	<script type="text/javascript">
			function searchUser(obj){
				$(obj).attr("data-target","#searchUser");
			}

			function closeSearch(){
				$("#searchmodfbox_grid-table").hide();
			}


	</script>

</body>
</html>