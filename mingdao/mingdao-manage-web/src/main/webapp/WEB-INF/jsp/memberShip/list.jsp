<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common_css.jsp"%>
<style>
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
				<li class="active">会员卡办理</li>
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
										<th>姓名</th>
										<th>卡号</th>
										<th>车牌号码</th>
										<th>计次套餐</th>
										<th>手机号码</th>
										<th>会员卡种</th>
										<th>赠送积分</th>
										<th>现金</th>
										<th>余额</th>
										<th>剩余次数</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${datas.datas}" var="item">
									<tr>
									    <td>
									    	${item.storeName}
									    </td>
										<td>
											${item.custName}
										</td>
										<td>
											${item.cardNo }
										</td>
										<td>
											${item.platNumber}
										</td>
										<td>
											${item.packageTypeId}
										</td>
										<td>
											${item.custPhone}
										</td>
										<td>
											${item.memberShipCardId}
										</td>
										<td>
											${item.points}
										</td>
										<td>
											${item.crash}
										</td>
										<td>
											${item.remaining }
										</td>
										<td>
											${item.totalRemainCount}
										</td>
										<td>
											${item.memo}
										</td>
										<td>
											<a class="btn btn-xs btn-info" onclick="editProduct(${item.id},this)" id="editProduct"  data-toggle="modal" title="编辑">
												<i class="ace-icon fa fa-pencil bigger-120"></i>
											</a>

											<a class="btn btn-xs btn-danger" onclick="deleteProduct(${item.id})" title="删除">
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
												<a href="#" id="add" target="mainFrame" style="color:#FFF;text-decoration:none;" title="添加会员卡"  class="btn btn-info fa"  data-toggle="modal">+</a>
												<a href="#" id="search" target="mainFrame" style="color:#FFF;text-decoration:none;" title="搜索" class="btn btn-info fa fa-search orange" data-toggle="modal" ></a>
												<a href="<%=request.getContextPath() %>/productBaseSer/product" style="color:#FFF;text-decoration:none;" class="btn btn-info fa fa-refresh" title="刷新列表"></a>
											</td>
											<td style="vertical-align: top;">
												<c:if test="${datas.total > 0}">
														<jsp:include page="/jsp/pager.jsp">
														<jsp:param value="${datas.total }" name="totalRecord"/>
														<jsp:param value="product" name="url"/>
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
	<div class="modal fade" id="searchUser" tabindex="-1" role="dialog" style="width:400px;" aria-labelledby="myModalLabel" aria-hidden="false">
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

									<td class="data"><input type="text" id="search_name" name="search_name" role="textbox"
															class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
									</td>
								</tr>
								<tr>
									<td class="first"></td>
									<td class="columns">
										<label>编码：</label>
									</td>

									<td class="data"><input type="text"  id="search_code" name="search_code" role="textbox"
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
						<span class="ui-jqdialog-title" id="modalTitle" style="float: left;">新增会员卡</span>
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
									<label class="col-sm-3 control-label no-padding-right" for="cardNo"> 卡号: </label>

									<div class="col-sm-9">
										<input id="id" placeholder="id" class="col-xs-10 col-sm-5" type="hidden">
										<input id="cardNo" placeholder="name" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="custName">姓名: </label>

									<div class="col-sm-9">
									    <input id="customerId" type="hidden" />
									    <input id="carInfoId" type="hidden" />
										<input id="custName" placeholder="姓名" class="col-xs-10 col-sm-5" type="text" disabled="true">
										<button data-toggle="modal" class="storebtn" onclick="refCustom(this)">参照客户</button>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="memberShipCardName">会员卡种: </label>

									<div class="col-sm-9">
										<input id="memberShipCardId" class="col-xs-10 col-sm-5" type="hidden">
										<input id="memberShipCard" class="col-xs-10 col-sm-5" type="text" disabled>
										<button  data-toggle="modal" class="storebtn" onclick="refMemberShipCar(this);">参照会员卡</button>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="packageType"> 套餐: </label>

									<div class="col-sm-9">
										<input id="packageTypeId" placeholder="productClassId" class="col-xs-10 col-sm-5" type="hidden">
										<input id="packageType" placeholder="选择套餐" class="col-xs-10 col-sm-5" type="text" disabled>
										<button  data-toggle="modal" class="storebtn" onclick="refpackagetype(this);">参照套餐类型</button>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="crash"> 现金:</label>

									<div class="col-sm-9">
										<input id="crash" placeholder="现金" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="points">赠送积分: </label>

									<div class="col-sm-9">
										<input id="points" placeholder="赠送积分" class="col-xs-10 col-sm-5" type="text" value="0"/>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="remaining">余额: </label>

									<div class="col-sm-9">
										<input id="remaining" placeholder="余额" class="col-xs-10 col-sm-5" type="text" value="0"/>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="totalRemainCount">剩余次数: </label>

									<div class="col-sm-9">
										<input id="totalRemainCount" placeholder="剩余次数" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="memo">备注: </label>

									<div class="col-sm-9">
										<textarea id="memo" placeholder="备注" class="col-xs-10 col-sm-5"></textarea>
									</div>
								</div>
								<%--会员卡参照--%>
								<div class="modal fade" id="vipCardList" tabindex="-1" role="dialog" style="width:700px;height:500px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="vipCard" src="<%=request.getContextPath() %>/memberShipCardBaseSer/refcardtype" width="100%" height="500px" frameborder="0"></iframe>
										</div>
									</div>
								</div>
								<div class="modal fade" id="packageTypeList" tabindex="-1" role="dialog" style="width:700px;height:500px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="packageType" src="<%=request.getContextPath() %>/packageTypeBaseSer/refpackageType" width="100%" height="500px" frameborder="0"></iframe>
										</div>
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
								<div class="modal fade" id="productClassList" tabindex="-1" role="dialog" style="width:700px;height:1000px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="parent" src="<%=request.getContextPath() %>/productClassBaseSer/refproductclass" width="100%" height="500px" frameborder="0"></iframe>
										</div>
									</div>
								</div>
								
								<%--计量照--%>
								<div class="modal fade" id="measdocList" tabindex="-1" role="dialog" style="width:700px;height:1000px;" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<iframe id="parent" src="<%=request.getContextPath() %>/measdocBaseSer/refmeasdoc" width="100%" height="500px" frameborder="0"></iframe>
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
	        var updata = false;

			$("#add").click(function(){
				$(this).attr("data-target","#addUser");
				$("#storeName").val("");
				$("#storeId").val("");
				$("#cardNo").val("");
				$("#id").val();
				$("#custName").val("");
				$("#custId").val("");
				$("#carInfoId").val("");
				$("#memberShipCard").val("");
				$("#memberShipCardId").val("");
				$("#packageType").val("");
				$("#packageTypeId").val("");
				$("#crash").val("0");
				$("#points").val("0");
				$("#remaining").val("0");
				$("#totalRemainCount").val("0");
				$("#memo").val("");
			});

			function editProduct(userId,obj){
				updata = true;
				$(obj).attr("data-target","#addUser");
				$.get("<%=request.getContextPath() %>/memberShipBaseSer/qryMemberShipById",{"id":userId},function(resultStr){
					var result = JSON.parse(resultStr);
					if(result.success){
						var product = result.result;
						$("#storeName").val(product.storeName);
						$("#storeId").val(product.storeId);
						$("#cardNo").val(product.cardNo);
						$("#id").val(product.id);
						$("#custName").val(product.custName);
						$("#custId").val(product.custId);
						$("#carInfoId").val(product.carInfoId);
						$("#memberShipCard").val(product.memberShipCard);
						$("#memberShipCardId").val(product.memberShipCardId);
						$("#packageType").val(product.packageType);
						$("#packageTypeId").val(product.packageTypeId);
						$("#crash").val(product.crash);
						$("#points").val(product.points);
						$("#remaining").val(product.remaining);
						$("#totalRemainCount").val(product.totalRemainCount);
						$("#memo").val(product.memo);
					}else{
						alert(result.resultMsg);
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
				paramsName.name="search_name";
				paramsName.val=$("#search_name").val();

				var paramsCode = new Object();
				paramsCode.name="search_code";
				paramsCode.val=$("#search_code").val();

				var paramsArr = [paramsName,paramsCode];
				submitForm("<%=request.getContextPath() %>/memberShipBaseSer/pageQryMemberShips",paramsArr);
	    	});

		//新增操作
			$("#fbox_grid-table_add").click(function(){
				var postData = {};
				postData.storeName = $("#storeName").val();
				postData.storeId = $("#storeId").val();
				postData.cardNo = $("#cardNo").val();
				postData.id = $("#id").val();
				postData.custName = $("#custName").val();
				postData.custId = $("#custId").val();
				postData.carInfoId = $("#carInfoId").val();
				postData.memberShipCard = $("#memberShipCard").val();
				postData.memberShipCardId = $("#memberShipCardId").val();
				postData.packageType = $("#packageType").val();
				postData.packageTypeId = $("#packageTypeId").val();
				postData.crash = $("#crash").val();
				postData.points = $("#points").val();
				postData.remaining = $("#remaining").val();
				postData.totalRemainCount = $("#totalRemainCount").val();
				$("#memo").val("");
				var url = "<%=request.getContextPath() %>/memberShipBaseSer/addMemberShip";
				if(updata){
					url = "<%=request.getContextPath() %>/memberShipBaseSer/updateMemberShip"
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
							submitForm("<%=request.getContextPath() %>/memberShipBaseSer/member",null);
						}else{
							alert(data.resultMsg);
						}
						
					},
					fail: function (err, status) {
						console.log(err)
					}
				});
			});
		function deleteProduct(id){
			$.get("<%=request.getContextPath() %>/memberShipBaseSer/deleteMemberShipById",{id:id},function(resultStr){
				var result = JSON.parse(resultStr);
				if(result.success){
					alert("删除成功！")
					submitForm("<%=request.getContextPath() %>/memberShipBaseSer/member",null);
				}else{
					alert(result.resultMsg);
				}
			});
		}

		function refMemberShipCar(obj){
			$(obj).attr("data-target", "#vipCardList");
		}
		
		function refpackagetype(obj){
			$(obj).attr("data-target", "#packageTypeList");
		}

		function refStores(obj){
			$(obj).attr("data-target","#storeList");
		}
		
		function refProductClass(obj){
			$(obj).attr("data-target","#productClassList");
		}
		
		function refMeasdoc(obj){
			$(obj).attr("data-target","#measdocList");
		}
	</script>

</body>
</html>