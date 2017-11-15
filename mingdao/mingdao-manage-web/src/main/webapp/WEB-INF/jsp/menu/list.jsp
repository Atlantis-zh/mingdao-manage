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
					<a href="#">菜单管理</a>
				</li>
				<li class="active">菜单信息管理</li>
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
										<th>菜单编码</th>
										<th>菜单名称</th>
										<th>父级节点编码</th>
										<th>状态</th>
										<th>是否叶子节点</th>
										<th>用户操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${datas.datas}" var="userInfo">
									<tr>
										<td>
											<a href="#">${userInfo.code }</a>
										</td>
										<td>${userInfo.name } </td>
										<td>${userInfo.parentCode}</td>
										<td>${userInfo.isLeafMenu}</td>
										<td class="hidden-480">
											<c:if test="${userInfo.status.value eq '0' }">
												<span class="emp">停用</span>
												<a onclick="startMenu(${userInfo.id });"  class="list_op">启用</a>
											</c:if>
											<c:if test="${userInfo.status.value eq '1' }">
												<span>启用</span>
												<a  onclick="stopMenu(${userInfo.id });" class="list_op">停用</a>
											</c:if>
										</td>
										<td>
									
												<c:if test="${userInfo.status.value eq '1' }">
													<button class="btn btn-xs btn-success" title="启用"> 
														<i class="ace-icon fa fa-check-square-o bigger-120"></i>
													</button>
												</c:if>
												<c:if test="${userInfo.status.value eq '0' }">
													<button class="btn btn-xs btn-success" title="停用">
														<i class="ace-icon fa fa-square-o bigger-120"></i>
													</button>
												</c:if>

												<a class="btn btn-xs btn-info" onclick="editMenu(${userInfo.id},this)" id="editUserInfo"  data-toggle="modal" title="编辑">
													<i class="ace-icon fa fa-pencil bigger-120"></i>
												</a>

												<a class="btn btn-xs btn-danger" href="deleteMenu/${userInfo.id }" title="删除">
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
												<a href="#" id="add" target="mainFrame" style="color:#FFF;text-decoration:none;" title="添加用户"  class="btn btn-info fa"  data-toggle="modal">+</a>
												<a href="#" id="search" target="mainFrame" style="color:#FFF;text-decoration:none;" title="搜索" class="btn btn-info fa fa-search orange" data-toggle="modal" ></a>
												<a href="<%=request.getContextPath() %>/menu/menus" style="color:#FFF;text-decoration:none;" class="btn btn-info fa fa-refresh" title="刷新列表"></a>
											</td>
											<td style="vertical-align: top;">
												<c:if test="${datas.total > 0}">
														<jsp:include page="/jsp/pager.jsp">
														<jsp:param value="${datas.total }" name="totalRecord"/>
														<jsp:param value="menus" name="url"/>
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
										<label>编号：</label>
									</td>

									<td class="data"><input type="text"  id="search_Code" name="search_Code" role="textbox"
															class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
									</td>
								</tr>
								<tr>
									<td class="first"></td>
									<td class="columns">
										<label>父级编号：</label>
									</td>

									<td class="data"><input type="text"  id="search_ParentCode" name="search_ParentCode" role="textbox"
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
						<span class="ui-jqdialog-title" id="modalTitle" style="float: left;">新增用户</span>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
					</div>
				</div>
				<div class="ui-jqdialog-content ui-widget-content" id="searchcntfbox_grid-table_add">
					<div id="fbox_grid-table_add1" class="searchFilter" style="overflow:auto">
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="name"> 菜单名称: </label>

									<div class="col-sm-9">
										<input id="id" placeholder="id" class="col-xs-10 col-sm-5" type="hidden">
										<input id="name" placeholder="name" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="code">  菜单编码: </label>

									<div class="col-sm-9">
										<input id="code" placeholder="code" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="parentCode">  父级编码: </label>

									<div class="col-sm-9">
										<input id="parentCode" placeholder="parentCode" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="isLeafMenu">是否叶子节点: </label>
									<div class="col-sm-9">
										<select class="form-control" id="isLeafMenu">
											<option value="0">是</option>
											<option value="1">否</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="status">状态: </label>
									<div class="col-sm-9">
										<select class="form-control" id="status">
											<option value="0">启用</option>
											<option value="1">停用</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="path">  路径: </label>

									<div class="col-sm-9">
										<input id="path" placeholder="path" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="menuLevel"> 菜单级别:</label>

									<div class="col-sm-9">
										<input id="menuLevel" placeholder="menuLevel" class="col-xs-10 col-sm-5" type="text">
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

		function startMenu(userId){
			$.ajax({
				type: 'POST',
				url: "<%=request.getContextPath() %>/menu/addMenu",
				data: {"status1":1,"id":userId },
				dataType: "json",
				success: function (data) {
					alert("启用成功！");
					submitForm("<%=request.getContextPath() %>/menu/menus",null);
				},
				fail: function (err, status) {
					console.log(err)
				}

			});
		}

		function stopMenu(userId){
			$.ajax({
				type: 'POST',
				url: "<%=request.getContextPath() %>/menu/addMenu",
				data: {"status1":0,"id":userId },
				dataType: "json",
				success: function (data) {
					alert("停用成功！");
					submitForm("<%=request.getContextPath() %>/menu/menus",null);
				},
				fail: function (err, status) {
					console.log(err)
				}

			});
		}



			$("#add").click(function(){
				$(this).attr("data-target","#addUser");
				$("#modalTitle").html("新增菜单");
				$("#id").val("");
				$("#code").val("");
				$("#name").val("");
				$("#parentCode").val("");
				$("#isLeafMenu").val("");
				$("#status").val("");
				$("#path").val("");
				$("#menuLevel").val("");

			});

			function editMenu(userId,obj){
				$(obj).attr("data-target","#addUser");
				$("#modalTitle").html("修改菜单");
				$.ajax({
					type: 'POST',
					url: "<%=request.getContextPath() %>/menu/getMenuInfoByID",
					data: { "userId": userId},
					dataType: "json",
					success: function (data) {
						//var data_ =  JSON.parse(data);
						var user = data.result;
						$("#id").val(user.id);
						$("#code").val(user.code);
						$("#name").val(user.name);
						$("#parentCode").val(user.parentCode);
						$("#isLeafMenu").val(user.isLeafMenu);
						$("#status").val(user.status);
						$("#path").val(user.path);
						$("#menuLevel").val(user.menuLevel);
					},
					fail: function (err) {
						console.log(err)
					}

				});
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

				var paramsPCode = new Object();
				paramsPCode.name="search_ParentCode";
				paramsPCode.val=$("#search_ParentCode").val();

				var paramsArr = [paramsName,paramsCode];
				submitForm("<%=request.getContextPath() %>/menu/menus",paramsArr);
	    	});

		//新增操作
			$("#fbox_grid-table_add").click(function(){
				var code = $("#code").val();
				var name = $("#name").val();
				var parentCode = $("#parentCode").val();
				var isLeafMenu = $("#isLeafMenu").val();
				var status =$("#status").val();
				var id =$("#id").val();
				var path = $("#path").val();
				var menuLevel = $("#menuLevel").val();

				$.ajax({
					type: 'POST',
					url: "<%=request.getContextPath() %>/menu/addMenu",
					data: { "code": code, "name": name,"parentCode":parentCode,"isLeafMenu":isLeafMenu,"status1":status,"id":id,"path":path,"menuLevel":menuLevel },
					dataType: "json",
					success: function (data, status) {
						if(id==null||id==""){
							alert("保存成功！！");
						}else{
							alert("修改成功！！");
						}
						submitForm("<%=request.getContextPath() %>/menu/menus",null);
					},
					fail: function (err, status) {
						console.log(err)
					}
				});
			});
	</script>

</body>
</html>