<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common_css.jsp"%>
<style type="text/css" media="screen">
	.select{
		height:34px !important;
		margin-top: 4px;
		line-height: 34px !important;
	}
	.clear{
		content: '';
		height: 0;
		clear: both;
	}
	.form-group{
		margin-bottom: 0px !important;
	}
	.setradio{
		margin-top: 18px;
	}
	.storebtn{
		height: 34px;
    	margin-top: 4px;
    	background-color: #6fb3e0;
    	border: 0;
    	color: #fff;
    	outline: none;
	}
</style>


</head>
<body class="no-skin">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="#">会员中心</a>
				</li>
				<li class="active">设置卡类型</li>
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
										<th>卡名称</th>
										<th>卡编码</th>
										<th>开卡充值</th>
										<th>开卡赠送</th>
										<th>有效期</th>
										<th>会员卡图片</th>
										<th>共享到分店</th>
										<th>来源</th>
										<th>卡状态</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${datas.datas}" var="MemberShip">
									<tr>
										<td>
											${MemberShip.name}
										</td>
										<td>${MemberShip.code} </td>
										<td >
											${MemberShip.cardRecharge}
										</td>
										<td>${MemberShip.cardDonate}</td>
										<td>${MemberShip.expire + MemberShip.timeUnit}</td>
										<td><a href="#">${cardPicture}</a></td>
										<td>
											<c:if test="${shareToBranch}">
											  <span>是</span>
											</c:if>
											<c:if test="!${shareToBranch}">
											  <span>否</span>
											</c:if>
										</td>
										<td>
										  <c:if test="${MemberShip.source eq '0'}">
										  	总店共享
										  </c:if>
										  <c:if test="${MemberShip.source eq '1'}">
										  	本店
										  </c:if>
										</td>
										<td>
											<c:if test="${MemberShip.status eq '1'}">
												<span style="color: blue">正常</span>
											</c:if>
											<c:if test="${MemberShip.status eq '0'}">
												<span style="color: red">不正常</span>
											</c:if>
										</td>
										<td>
										    <a class="btn btn-xs btn-info" onclick="editUser(${MemberShip.id},this)" id="editInfo"  data-toggle="modal" title="修改">修改</a>
											<a class="btn btn-xs btn-danger" href="deleteUser/${userInfo.id }" title="停用">停用</a>
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
										<label>卡名称：</label>
									</td>

									<td class="data"><input type="text" id="search_userName" name="search_userName" role="textbox" class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
									</td>
								</tr>
								<tr>
									<td class="first"></td>
									<td class="columns">
										<label>卡编码：</label>
									</td>

									<td class="data"><input type="text"  id="search_userCode" name="search_userCode" role="textbox" class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
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
								<td class="EditButton" style="text-align:left"><a id="fbox_grid-table_reset" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-reset btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>重置</a></td>
								<td class="EditButton"><a id="fbox_grid-table_search" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-search btn btn-sm btn-purple"><span class="ace-icon fa fa-search"></span>查询</a></td>
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
						<span class="ui-jqdialog-title" id="modalTitle" style="float: left;">新增会员</span>
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
									<label class="col-sm-3 control-label no-padding-right" for="storeName"> 所属门店: </label>

									<div class="col-sm-9">
										<input id="storeId" class="col-xs-10 col-sm-5" type="hidden">
										<input id="storeName" placeholder="所属门店" class="col-xs-10 col-sm-5" type="text" disabled>
										<button data-toggle="modal" class="storebtn" onclick="refStores(this)">参照门店</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="name"> 卡名称: </label>

									<div class="col-sm-9">
										<input id="id" placeholder="id" class="col-xs-10 col-sm-5" type="hidden" >
										<input id="name" placeholder="卡名称" class="col-xs-10 col-sm-5" type="text">
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="code">卡编码: </label>

									<div class="col-sm-9">
										<input id="code" placeholder="卡编码" class="col-xs-10 col-sm-5" type="text">
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="cardRecharge"> 开卡充值: </label>

									<div class="col-sm-9">
										<input id="cardRecharge" placeholder="开卡充值" class="col-xs-10 col-sm-5" type="text">
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="cardDonate">  开卡赠送: </label>

									<div class="col-sm-9">
										<input id="cardDonate" placeholder="开卡赠送" class="col-xs-10 col-sm-5" type="text">
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="expire">  有效期: </label>

									<div class="col-sm-9">
										<input id="expire" placeholder="有效期" class="col-xs-6 col-sm-5" type="text">
										<select id="timeUnit" class="select">
										  <option value="1" selected>年</option>
										  <option value="2">月</option>
										  <option value="3">日</option>
										</select>
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="shareToBranch"> 共享到分店:</label>

									<div class="col-sm-9 setradio">
										<input type="radio" name="shareToBranch" value="0" />否
										<input type="radio" name="shareToBranch" value="1" />是
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="source"> 来源:  </label>

									<div class="col-sm-9 setradio">
										<input name="source" value="0" type="radio" />总店共享
										<input name="source" value="1" type="radio" />本店
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="status">状态: </label>

									<div class="col-sm-9 setradio">
										<input name="status" value="1" type="radio" checked />正常
										<input name="status" value="0" type="radio" checked />不正常
									</div>
									<div class="clear"></div>
								</div>
								<div class="modal fade" id="storeList" tabindex="-1" role="dialog" style="width:700px;height:500px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="stores" src="<%=request.getContextPath() %>/storeBaseSer/refStores" width="100%" height="500px" frameborder="0"></iframe>
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
								<td class="EditButton" style="text-align:left">
									<a id="fbox_grid-table_reset_add" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-reset btn btn-sm btn-info">
									   <span class="ace-icon fa fa-retweet"></span>
									   重置
									</a>
								</td>
								<td class="EditButton">
								   <a id="fbox_grid-table_add" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-search btn btn-sm btn-purple">
								      <span class="ace-icon fa fa-search"></span>
								      添加
								    </a>
								</td>
							</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"></div>
			</div>
		</div>
	</div>
	<%--修改框--%>
	<div class="modal fade" id="changeInfor" tabindex="-1" role="dialog" style="width:600px;" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="searchhdfbox_grid-table_add"
					 style="cursor: move;">
					<div class="widget-header">
						<span class="ui-jqdialog-title" id="modalTitle" style="float: left;">修改信息</span>
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
									<label class="col-sm-3 control-label no-padding-right" for="changName"> 卡名称: </label>

									<div class="col-sm-9">
										<input id="changename" placeholder="卡名称" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="changecardRecharge"> 开卡充值: </label>

									<div class="col-sm-9">
										<input id="changecardRecharge" placeholder="开卡充值" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="changecardDonate">  开卡赠送: </label>

									<div class="col-sm-9">
										<input id="changecardDonate" placeholder="开卡赠送" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="changeexpire">  有效期: </label>

									<div class="col-sm-9">
										<input id="changeexpire" placeholder="有效期" class="col-xs-6 col-sm-5" type="text">
										<select id="changetimeUnit" class="select">
										  <option value="1" selected>年</option>
										  <option value="2">月</option>
										  <option value="3">日</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="changeshareToBranch"> 共享到分店:</label>

									<div class="col-sm-9 setradio">
										<input type="radio" name="changeshareToBranch" value="0" />否
										<input type="radio" name="changeshareToBranch" value="1" />是
									</div>
								</div>
								<div class="modal fade" id="storeList" tabindex="-1" role="dialog" style="width:700px;height:500px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="stores" src="<%=request.getContextPath() %>/storeBaseSer/refStores" width="100%" height="500px" frameborder="0"></iframe>
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
								<td class="EditButton" style="text-align:left">
									<a id="fbox_grid-table_reset_add" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-reset btn btn-sm btn-info">
									   <span class="ace-icon fa fa-retweet"></span>
									   确定
									</a>
								</td>
								<td class="EditButton">
								   <a id="fbox_grid-table_add" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-search btn btn-sm btn-purple">
								      <span class="ace-icon fa fa-search"></span>
								      返回
								    </a>
								</td>
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
		var updata = false;
		function startUser(userId){
			$.ajax({
				type: 'POST',
				url: "<%=request.getContextPath() %>/user/addUser",
				data: {"status":1,"id":userId },
				dataType: "json",
				success: function (data) {
					alert("启用成功！");
					submitForm("<%=request.getContextPath() %>/user/users",null);
				},
				fail: function (err, status) {
					console.log(err)
				}

			});
		}

		function stopUser(userId){
			$.ajax({
				type: 'POST',
				url: "<%=request.getContextPath() %>/user/addUser",
				data: {"status":0,"id":userId },
				dataType: "json",
				success: function (data) {
					alert("停用成功！");
					submitForm("<%=request.getContextPath() %>/user/users",null);
				},
				fail: function (err, status) {
					console.log(err)
				}

			});
		}



			$("#add").click(function(){
				$(this).attr("data-target","#addUser");
				$("#modalTitle").html("新增会员");
				$("#name").val("");
				$("#code").val("");
				$("#cardRecharge").val("");
				$("#cardDonate").val("");
				$("#expire").val("");
			});

			function editUser(userId,obj){
				$(obj).attr("data-target","#changeInfor");
				debugger;
				$.ajax({
					type: 'GET',
					url: "<%=request.getContextPath() %>/memberShipCardBaseSer/qryMemberShipCardById",
					data: { "id": userId},
					dataType: "json",
					success: function (data) {
						//var data_ =  JSON.parse(data);
						var user = data.result;
						$("#changename").val(user.name);
						$("#changecardRecharge").val(user.cardRecharge);
						$("#changecardDonate").val(user.cardDonate);
						$("#changeexpire").val(user.expire);
						$("#changetimeUnit").val(user.changetimeUnit);
						$("input[name='changeshareToBranch']:checked").val(user.shareToBranch)
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
				paramsName.name="search_userName";
				paramsName.val=$("#search_userName").val();

				var paramsCode = new Object();
				paramsCode.name="search_userCode";
				paramsCode.val=$("#search_userCode").val();

				var paramsArr = [paramsName,paramsCode];
				submitForm("<%=request.getContextPath() %>/memberShipCardBaseSer/membership",paramsArr);
	    	});

		//新增操作
			$("#fbox_grid-table_add").click(function(){
				var obj = {};
				obj.storeId = $("#storeId").val();
				obj.name = $("#name").val();
				obj.code = $("#code").val();
				obj.cardRecharge = $("#cardRecharge").val();
				obj.cardDonate = $("#cardDonate").val();
				obj.expire =$("#expire").val();
				obj.id =$("#id").val();
				obj.timeUnit = $("#timeUnit").val();
				obj.shareToBranch = $("input[name='shareToBranch']:checked").val();
				obj.source = $("input[name='source']:checked").val();
				obj.status = $("input[name='status']:checked").val();
				$.ajax({
					type: 'POST',
					url: "<%=request.getContextPath() %>/memberShipCardBaseSer/addMemberShipCard",
					data: JSON.stringify(obj),
					dataType: "json",
					contentType: "application/json",
					success: function (data, status) {
						if(!updata){
							alert("保存成功！！");
						}else{
							alert("修改成功！！");
						}
						submitForm("<%=request.getContextPath() %>/memberShipCardBaseSer/refcardtype",null);
					},
					fail: function (err, status) {
						console.log(err)
					}
				});
			});
			function refStores(obj){
				$(obj).attr("data-target","#storeList");
			}
	</script>

</body>
</html>