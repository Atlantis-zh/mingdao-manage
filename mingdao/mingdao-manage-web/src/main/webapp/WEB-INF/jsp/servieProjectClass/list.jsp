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
				<a href="#">服务项目分类管理</a>
			</li>
			<li class="active">服务项目分类信息管理</li>
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
								<th>编码</th>
								<th>名称</th>
								<th>门店</th>
								<th>上级分类</th>
								<th>工时分类</th>
								<th>用户操作</th>
							</tr>
							</thead>

							<tbody>
							<c:forEach items="${datas.datas}" var="servicetype">
								<tr>
									<td>${servicetype.code }</td>
									<td>${servicetype.name }</td>
									<td>${servicetype.storeName}</td>
									<td>${servicetype.parentName}</td>
									<td>${servicetype.workTimeClassName}</td>
									<td>
										<a class="btn btn-xs btn-info" onclick="editServicetype(${servicetype.id},this)" id="editservicetype"  data-toggle="modal" title="编辑">
											<i class="ace-icon fa fa-pencil bigger-120"></i>
										</a>

										<a class="btn btn-xs btn-danger" onclick="deleteClass(${servicetype.id})" title="删除">
											<i class="ace-icon fa fa-trash-o bigger-120"></i>
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
										<a href="#" id="add" target="mainFrame" style="color:#FFF;text-decoration:none;" title="添加角色"  class="btn btn-info fa"  data-toggle="modal">+</a>
										<a href="#" id="search" target="mainFrame" style="color:#FFF;text-decoration:none;" title="搜索" class="btn btn-info fa fa-search orange" data-toggle="modal" ></a>
										<a href="<%=request.getContextPath() %>/serProdClassBaseSer/serviceProjectClasss" style="color:#FFF;text-decoration:none;" class="btn btn-info fa fa-refresh" title="刷新列表"></a>
									</td>
									<td style="vertical-align: top;">
										<c:if test="${datas.total > 0}">
											<jsp:include page="/jsp/pager.jsp">
												<jsp:param value="${datas.total }" name="totalRecord"/>
												<jsp:param value="serviceProjectClasss" name="url"/>
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
									<label>名称：</label>
								</td>

								<td class="data"><input type="text" id="search_Name" name="search_Name" role="textbox"
														class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
								</td>
							</tr>
							<tr>
								<td class="first"></td>
								<td class="columns">
									<label>编码：</label>
								</td>

								<td class="data"><input type="text"  id="search_Code" name="search_Code" role="textbox"
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
		</div>
	</div>
</div>


<%--  新增框--%>
<div class="modal fade" id="addUser" tabindex="-1" role="dialog" style="width:600px;" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="searchhdfbox_grid-table_add"
				 style="cursor: move;">
				<div class="widget-header">
					<span class="ui-jqdialog-title" id="modalTitle" style="float: left;">新增</span>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
				</div>
			</div>
			<div class="ui-jqdialog-content ui-widget-content" id="searchcntfbox_grid-table_add">
				<div id="fbox_grid-table_add1" class="searchFilter" style="overflow:hidden">
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="code">编码: </label>

								<div class="col-sm-9">
									<input id="id" placeholder="id" class="col-xs-10 col-sm-5" type="hidden">
									<input id="code" placeholder="code" class="col-xs-10 col-sm-5" type="text">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="name">名称: </label>

								<div class="col-sm-9">
									<input id="name" placeholder="name" class="col-xs-10 col-sm-5" type="text">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="storeId">门店: </label>

								<div class="col-sm-9">
									<input id="storeId" placeholder="storeId" class="col-xs-10 col-sm-5" type="hidden">
									<input id="storeName" placeholder="storeName" class="col-xs-10 col-sm-5" type="text">
									<button  data-toggle="modal" onclick="refStores(this);">参照门店</button>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="parentId">上级分类: </label>

								<div class="col-sm-9">
									<input id="serProdClassId" placeholder="serProdClassId" class="col-xs-10 col-sm-5" type="hidden">
									<input id="serProdClassName" placeholder="serProdClassName" class="col-xs-10 col-sm-5" type="text">
									<button  data-toggle="modal" onclick="refSerProdClass(this);">参照上级分类</button>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="workTimeClassId">工时分类: </label>

								<div class="col-sm-9">
									<input id="workTimeClassId" placeholder="workTimeClassId" class="col-xs-10 col-sm-5" type="hidden">
									<input id="workTimeClassName" placeholder="workTimeClassName" class="col-xs-10 col-sm-5" type="text">
									<button  data-toggle="modal" onclick="refWorktimeClass(this);">参照工时分类</button>
								</div>
							</div>
							
							<%--门店参照--%>
							<div class="modal fade" id="storeList" tabindex="-1" role="dialog" style="width:700px;height:500px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="stores" src="<%=request.getContextPath() %>/storeBaseSer/refStores" width="100%" height="500px" frameborder="0"></iframe>
										</div>
									</div>
							</div>
								
							<%--上级分类参照--%>
							<div class="modal fade" id="serProdClassList" tabindex="-1" role="dialog" style="width:700px;height:1000px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="parent" src="<%=request.getContextPath() %>/serProdClassBaseSer/refserviceProjectClasss" width="100%" height="500px" frameborder="0"></iframe>
										</div>
									</div>
						    </div>
						    
						    <%--工时分类参照--%>
							<div class="modal fade" id="workTimeClassList" tabindex="-1" role="dialog" style="width:700px;height:1000px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="workTimeClassId" src="<%=request.getContextPath() %>/wktBaseSer/refworkTimeClasss" width="100%" height="500px" frameborder="0"></iframe>
										</div>
									</div>
						    </div>
						</div>
					</div>
					<table class="EditTable" style="border:0px none;margin-top:5px;width:600px;" id="fbox_grid-table_btn">
						<tbody>
						<tr>
							<td colspan="2">
								<hr class="ui-widget-content" style="margin:1px">
							</td>
						</tr>
						<tr>
							<td class="EditButton" style="text-align:left"><a id="fbox_grid-table_reset_add"
																			  class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-reset btn btn-sm btn-info"><span
									class="ace-icon fa fa-retweet"></span>重置</a></td>
							<td class="EditButton"><a id="fbox_grid-table_add"
													  class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-search btn btn-sm btn-purple"><span
									class="ace-icon fa fa-search"></span>添加</a></td>
						</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"></div>
		</div>
	</div>
</div>
<%--//end_zhangfx--%>



<%@ include file="../common/common_js.jsp"%>

<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.bootstrap.js"></script>


<script type="text/javascript">



	$("#add").click(function(){
		$(this).attr("data-target","#addUser");
		$("#modalTitle").html("新增服务项目分类");
		$("#id").val("");
		$("#code").val("");
		$("#name").val("");
		$("#storeId").val("");
		$("#workTimeClassId").val("");
		$("#parentId").val("");
	});

	function editServicetype(userId,obj){
		$(obj).attr("data-target","#addUser");
		$("#modalTitle").html("修改服务项目分类");
		$.get("<%=request.getContextPath() %>/serProdClassBaseSer/qryServiceProductClassById",{ "id": userId},function(resultStr){
			var result = JSON.parse(resultStr);
			if(result.success){
				var user = result.result;
				$("#id").val(user.id);
				$("#code").val(user.code);
				$("#name").val(user.name);
				$("#storeId").val(user.storeId);
				$("#storeName").val(user.storeName);
				$("#workTimeClassId").val(user.workTimeClassId);
				$("#workTimeClassName").val(user.workTimeClassName);
				$("#serProdClassId").val(user.parentId);
				$("#serProdClassName").val(user.parentName);
			}else{
				alert(result.resultMsg);
			}
		})
	}

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
		paramsName.name="search_Name";
		paramsName.val=$("#search_Name").val();

		var paramsCode = new Object();
		paramsCode.name="search_Code";
		paramsCode.val=$("#search_Code").val();

		var paramsArr = [paramsName,paramsCode];
		submitForm("<%=request.getContextPath() %>/serProdClassBaseSer/serviceProjectClasss",paramsArr);
	});

	//新增操作
	$("#fbox_grid-table_add").click(function(){
		var code = $("#code").val();
		var name = $("#name").val();
		var storeId =$("#storeId").val();
		var workTimeClassId = $("#workTimeClassId").val();
		var id = $("#id").val();
		var parentId = $("#serProdClassName").val();
		var postData = {
			code:code,
			name:name,
			storeId:storeId,
			id:id,
			workTimeClassId:workTimeClassId,
			parentId:parentId
		}
		var url = "<%=request.getContextPath() %>/serProdClassBaseSer/updateServiceProductClass";
		if(id==null||id==""){
			url="<%=request.getContextPath() %>/serProdClassBaseSer/addServiceProductClass";
		}
		$.ajax({
			type: 'POST',
			url: url,
			data: JSON.stringify(postData),
			dataType: "json",
			contentType: "application/json;charest=UTF-8",
			success: function (data, status) {
				if(data.success){
					if(id==null||id==""){
						alert("保存成功！！");
					}else{
						alert("修改成功！！");
					}
					submitForm("<%=request.getContextPath() %>/serProdClassBaseSer/serviceProjectClasss",null);
				}else{
					alert(data.resultMsg);
				}				
			},
			fail: function (err, status) {
				console.log(err)
			}

		});
	});

	function deleteClass(id){
		$.get("<%=request.getContextPath() %>/serProdClassBaseSer/deleteServiceProductClassById",{id:id},function(resultStr){
			var result = JSON.parse(resultStr);
			if(result.success){
				alert("删除成功！")
				submitForm("<%=request.getContextPath() %>/serProdClassBaseSer/serviceProjectClasss",null);
			}else{
				alert(result.resultMsg);
			}
		});
	}
	
	function refStores(obj){
		$(obj).attr("data-target","#storeList");
	}
	
	function refSerProdClass(obj){
		$(obj).attr("data-target","#serProdClassList");
	}
	
	function refWorktimeClass(obj){
		$(obj).attr("data-target","#workTimeClassList");
	}

</script>

</body>
</html>