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
				<a href="#">已经处理订单管理</a>
			</li>
			<li class="active">已经处理订单信息管理</li>
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
								<th>所属门店</th>
								<th>服务项目</th>
								<th>预约时间</th>
								<th>车牌号</th>
								<th>预约联系人</th>
							</tr>
							</thead>

							<tbody>
							<c:forEach items="${datas.datas}" var="role">
								<tr>
									<td>${role.storeId}</td>
									<td>${role.serviceName }</td>
									<td>${role.orderTime}</td>
									<td>${role.carNo}</td>
									<td>${role.customerName}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div class="page-header position-relative">
							<table style="width: 100%;">
								<tbody>
								<tr>
									<td style="vertical-align: top;">
										<a href="#" id="add" target="mainFrame" style="color:#FFF;text-decoration:none;" title="添加角色"  class="btn btn-info fa"  data-toggle="modal">+</a>
										<a href="#" id="search" target="mainFrame" style="color:#FFF;text-decoration:none;" title="搜索" class="btn btn-info fa fa-search orange" data-toggle="modal" ></a>
										<a href="<%=request.getContextPath() %>/finishOrderProject/orderProjects" style="color:#FFF;text-decoration:none;" class="btn btn-info fa fa-refresh" title="刷新列表"></a>
									</td>
									<td style="vertical-align: top;">
										<c:if test="${datas.total > 0}">
											<jsp:include page="/jsp/pager.jsp">
												<jsp:param value="${datas.total }" name="totalRecord"/>
												<jsp:param value="orderProjects" name="url"/>
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


<%--begin_zhangfx_查询框--%>
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
									<label>所属门店：</label>
								</td>

								<td class="data">
									<div class="col-sm-9">
										<input id="storeId" placeholder="storeId" class="col-xs-10 col-sm-5" type="hidden">
										<input id="storeName" placeholder="storeName" class="col-xs-10 col-sm-5" type="text">
										<button  data-toggle="modal" onclick="refStores(this);">参照门店</button>
									</div>
									<%--门店参照--%>
									<div class="modal fade" id="storeList" tabindex="-1" role="dialog" style="width:700px;height:500px;" aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<iframe id="stores" src="<%=request.getContextPath() %>/storeBaseSer/refStores" width="100%" height="500px" frameborder="0"></iframe>
											</div>
										</div>
									</div>
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
		</div>
	</div>
</div>



<%@ include file="../common/common_js.jsp"%>

<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.bootstrap.js"></script>


<script type="text/javascript">

	$("#search").click(function(){
		$(this).attr("data-target","#searchUser");
	});

	function submitForm(action, params) {
		var form = $("<form></form>");
		form.attr('action', action);
		form.attr('method', 'post');
		form.attr('target', '_self');
		if(params!=null){
			for(var i=0 ; i < params.length;i ++){
				var input1 = $("<input type='hidden' name='"+params[i].name+"' />");
				input1.attr('value', params[i].val);
				form.append(input1);
			}
		}

		form.appendTo("body");
		form.css('display', 'none');
		form.submit();
	}

	//查询所有
	$("#fbox_grid-table_search").click(function(){
		var paramsName = new Object();
		paramsName.name="search_storeId";
		paramsName.val=$("#search_storeId").val();


		var paramsArr = [paramsName,paramsCode];
		submitForm("<%=request.getContextPath() %>/finishOrderProject/orderProjects",paramsArr);
	});


	function refStores(obj){
		$(obj).attr("data-target","#storeList");
	}

</script>

</body>
</html>