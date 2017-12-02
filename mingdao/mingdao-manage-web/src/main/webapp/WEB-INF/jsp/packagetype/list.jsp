<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common_css.jsp"%>
<link href="https://cdn.bootcss.com/x-editable/1.5.1/bootstrap-editable/css/bootstrap-editable.css" rel="stylesheet">

<style>
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
	#serviceProjectTab{
	  width: 98%;
	  overflow-y: auto;
	}
	#serviceProjectTab th,#serviceProjectTab td {
	  width: 25%;
	  height: 32px;
	  text-align: center;
	  border: 1px solid #dedede;
	}
	
	.tabOper{
		color: #ff0000;
		cursor: pointer;
	}
	.btn-group{
		margin-top: 3%;
	}
	#servicePro-add{
		color: #6fb3e0;
		cursor: pointer;
		border: 0;
		background-color: #fff;
		outline: none;
	}
	.serviceName{
		color: #bf63e0;
		cursor: pointer;
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
				<li class="active">设置套餐类型</li>
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
										<th>套餐名称</th>
										<th>套餐售价</th>
										<th>套餐次数</th>
										<th>有效期</th>
										<th>共享到分店</th>
										<th>来源</th>
										<th>状态</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${datas.datas}" var="item">
									<tr>
									    <td>${item.storeName}</td>
										<td>
											<a href="#">${item.name }</a>
										</td>
										<td>${item.salePrice }</td>
										<td>${item.totalCount}</td>

										<td>
										  <c:if test="${item.timeUnit==1}">
										    <span>年</span>
										  </c:if>
										  <c:if test="${item.timeUnit=='2'}">
										    <span>月</span>
										  </c:if>
										  <c:if test="${item.timeUnit=='3'}">
										    <span>日</span>
										  </c:if>
										</td>
										<td>
										  <c:if test="${item.shareToBranch eq '0'}">否</c:if>
										  <c:if test="${item.shareToBranch eq '1'}">是</c:if>
										</td>
										<td>
										  <c:if test="${item.shareToBranch eq '0'}">总店共享</c:if>
										  <c:if test="${item.shareToBranch eq '1'}">本店</c:if>
										</td>
										<td>
										  <c:if test="${item.status eq '0'}">
										    停用
										  </c:if>
										  <c:if test="${item.status eq '1'}">
										  	正常
										  </c:if>
										</td>
										<td>${item.memo}</td>
										<td>
											<a class="btn btn-xs btn-info" onclick="editProduct(${item.id},this)" id="editProduct"  data-toggle="modal" title="修改">
												修改
											</a>

											<a class="btn btn-xs btn-danger" onclick="deleteProduct(${item.id})" title="停用">
												停用
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
												<a href="#" id="add" target="mainFrame" style="color:#FFF;text-decoration:none;" title="添加套餐"  class="btn btn-info fa"  data-toggle="modal">+</a>
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
	<div class="modal fade" id="searchUser" tabindex="-1" role="dialog" style="width:700px;" aria-labelledby="myModalLabel" aria-hidden="false">
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
										<label>状态：</label>
									</td>

									<td class="data">
									  <input type="radio" name="status" value="0" />停用
									  <input type="radio" name="status" value="1" />正常
									</td>
								</tr>
								<tr>
									<td class="first"></td>
									<td class="columns">
										<label>来源：</label>
									</td>

									<td class="data">
									  <input type="radio" name="source" value="0" />总店共享
									  <input type="radio" name="source" value="1" />本店
									</td>
								</tr>
								</tbody>
							</table>
						</div>
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
						<span class="ui-jqdialog-title" id="modalTitle" style="float: left;">新增套餐类型</span>
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
									<label class="col-sm-3 control-label no-padding-right" for="name"> 套餐名称: </label>

									<div class="col-sm-9">
										<input id="name" placeholder="套餐名称" class="col-xs-10 col-sm-5" type="text">
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="salePrice">套餐售价: </label>

									<div class="col-sm-9">
										<input id="salePrice" placeholder="套餐售价" class="col-xs-10 col-sm-5" type="text">
									</div>
									<div class="clear"></div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="totalCount">套餐次数: </label>

									<div class="col-sm-9">
										<input id="totalCount" placeholder="套餐次数" class="col-xs-10 col-sm-5" type="number">
									</div>
									<div class="clear"></div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="storeId">  所属门店: </label>

									<div class="col-sm-9">
										<input id="storeId" placeholder="storeId" class="col-xs-10 col-sm-5" type="hidden">
										<input id="storeName" placeholder="所属门店" class="col-xs-10 col-sm-5" type="text">
										<button class="storebtn" data-toggle="modal" onclick="refStores(this);">参照门店</button>
									</div>
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
									<label class="col-sm-3 control-label no-padding-right" for="cost">成本: </label>

									<div class="col-sm-9">
										<input id="cost" placeholder="成本" class="col-xs-10 col-sm-5" type="text">
									</div>
									<div class="clear"></div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="status">状态: </label>

									<div class="col-sm-9 setradio">
										<input type="radio" name="status" value="0" />停用
										<input type="radio" name="status" value="1" />正常
									</div>
									<div class="clear"></div>
								</div>							
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="memo">备注: </label>

									<div class="col-sm-9">
										<textarea id="memo" placeholder="备注" class="col-xs-10 col-sm-5"></textarea>
									</div>
									<div class="clear"></div>
								</div>
								<div class="form-group service-group">
								    <label class="col-sm-3 control-label no-padding-right">
								    	服务项目:
								    </label>
									<%--<iframe src="<%=request.getContextPath() %>/serProductBaseSer/refserviceProjects" width="100%" height="auto" frameborder="0" name="serverProject"></iframe>--%>
									<div id="tab-toolbar" class="btn-group">
										<button id="servicePro-add" title="添加">
        									<i class="glyphicon glyphicon-plus"></i> 
        									添加
    									</button>
									</div>
 									<table id="serviceProjectTab">
 										<thead>
 										  <tr>
 											<th>服务名称</th>
 											<th>数量</th>
											<th>单价</th>
											<th>操作</th>
 										  </tr>
 										</thead>
 										<tbody>
 											
 										</tbody>										
 									</table>
 									<div class="modal-backdrop serviceModal" style="background-color:rgba(0,0,0,0.5);display:none;z-index:10" id="serviceList">
 											<iframe src="<%=request.getContextPath() %>/serProductBaseSer/refserviceProjects" width="100%" height="500px" frameborder="0" name="serverProject"
 											id="serverProject"></iframe>
 										</div>
									<div class="clear">	
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
								<%--服务项目的参照--%>
								
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
								<td class="EditButton" style="text-align:left">
								   <a id="fbox_grid-table_reset_add" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-reset btn btn-sm btn-info">
								     <span class="ace-icon fa fa-retweet"></span>重置
								   </a>
								</td>
								<td class="EditButton">
								   <a id="fbox_grid-table_add" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-search btn btn-sm btn-purple">
								     <span class="ace-icon fa fa-search"></span>添加
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

<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>

<!-- Latest compiled and minified Locales -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/x-editable/bootstrap-editable.js"></script>
	<script type="text/javascript">
	  		var curIndex = 0;
	  		var updata = false;
			$("#add").click(function(){
				$(this).attr("data-target","#addUser");
				$("#storeName").val("");
				$("#storeId").val("");
				$("#name").val("");
				$("#salePrice").val("");
				$("#storeId").val("");
				$("#totalCount").val("");
				$("#expire").val("");
				$("#cost").val("");
				$("#spec").val("");
				$("#salePrice").val("");
				$("#adapteCarType").val("");
				$("#memo").val("");
				$("#memo").val("");
				$("#serviceProjectTab tbody").html("");
			});
			function setChecked(dom,val){
			  $.each(dom, function(){
			  	if($(this).val() == val){
			  		$(this).attr('checked', true);
			  	}
			  })
			}
		// 设置表格
		    
			function editProduct(userId,obj){
				$(obj).attr("data-target","#addUser");
				updata = true;
				$("#modalTitle").html("修改产品分类");
				$.get("<%=request.getContextPath() %>/packageTypeBaseSer/qryPackageTypeById",{"id":userId},function(resultStr){
					var result = JSON.parse(resultStr);
					if(result.success){
						var product = result.result;
						$("#name").val(product.name);
			            $("#salePrice").val(product.salePrice);
			            $("#totalCount").val(product.totalCount);
			            $("#storeId").val(product.storeId);
			            $("#expire").val(product.expire);
			            $("#timeUnit").val(product.timeUnit);
			            $("#cost").val(product.cost);
			            setChecked($("input[name='shareToBranch']"), product.shareToBranch);
			            setChecked($("input[name='source']"), product.source);
			            setChecked($("input[name='status']"), product.status);
			            $("#memo").val(product.memo);
					}else{
						alert(result.resultMsg);
					}
				});
			}

			$("#search").click(function(){
				$(this).attr("data-target","#searchUser");
			});

            $('#servicePro-add').click(function(){
            	curIndex++;
            	var tr = $('<tr>').addClass('serviceTr'+curIndex).attr('data-index', curIndex).appendTo('#serviceProjectTab tbody');
            	$('<td>').addClass('serviceName serviceName'+curIndex).text('添加服务').appendTo(tr);
            	var numtd = $('<td>');
            	$('<a>').attr({
            		'id': 'num'+curIndex,
            		'href': '#',
            		'data-type': 'text',
            		'data-title': '数量'
            	}).appendTo(numtd);
            	numtd.appendTo(tr);
            	var prictd = $('<td>');
            	$('<a>').attr({
            		'id': 'price'+curIndex,
            		'href': '#',
            		'data-type': 'text',
            		'data-title': '单价'
            	}).appendTo(prictd);
            	prictd.appendTo(tr);
            	$('#num'+curIndex).editable();
            	$('#price'+curIndex).editable();
            	$('<td>').text('删除').addClass('tabOper').attr({
            	  'data-index': curIndex
            	}).appendTo(tr);
            	$('.tabOper').click(function(){
            		var deleteIndex = $(this).attr('data-index');
            		$('.serviceTr'+deleteIndex).remove();
            	});
            	$('.serviceName').click(function(){
            		$('.serviceModal').show();
            		$('.serviceName').removeAttr('id');
            		$(this).attr('id', 'serviceName');
            	});
            })
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
				var params = new Object();
				params.storeId=$("#storeId").val();
				params.status=$("input[name='status']:checked").val();
				params.source=$("input[name='source']:checked").val();

				var paramsCode = new Object();
				paramsCode.name="search_code";
				paramsCode.val=$("#search_code").val();

				var paramsArr = [paramsName,paramsCode];
				submitForm("<%=request.getContextPath() %>/packageTypeBaseSer/packagetype",paramsArr);
	    	});

		//新增操作
			$("#fbox_grid-table_add").click(function(){
				var postData = {};
				var projectArr = [];
				$.each($("#serviceProjectTab tbody tr"), function(){
					var obj = {};
					var index = $(this).attr('data-index');
					obj.id = $('.serviceName'+ index).attr('data-code');
					obj.num = $('#num'+index).text();
					obj.price = $('#price'+index).text();
					projectArr.push(obj);
				})
				console.log(projectArr);
				debugger;
				postData.name = $("#name").val();
			    postData.salePrice = $("#salePrice").val();
			    postData.totalCount = $("#totalCount").val();
			    postData.storeId = $("#storeId").val();
			    postData.expire = $("#expire").val();
			    postData.timeUnit = $("#timeUnit").val();
			    postData.cost = $("#cost").val();
			    postData.shareToBranch = $("input[name='shareToBranch']:checked").val();
			    postData.source = $("input[name='source']:checked").val();
			    postData.memo = $("#memo").val();
			    postData.status = $("input[name='status']:checked").val();
			    postData.serviceProject = projectArr;			
				var url = "<%=request.getContextPath() %>/packageTypeBaseSer/addPackageType";
				if (updata){
					url = "<%=request.getContextPath() %>/packageTypeBaseSer/updatePackageType";
				}
				$.ajax({
					type: 'POST',
					url: url,
					data: JSON.stringify(postData),
					dataType: "json",
					contentType: "application/json;charest=UTF-8",
					success: function (data, status) {
						if(data.success){
							submitForm("<%=request.getContextPath() %>/packageTypeBaseSer/packagetype",null);
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
			$.get("<%=request.getContextPath() %>/packageTypeBaseSer/deletePackageTypeById",{id:id},function(resultStr){
				var result = JSON.parse(resultStr);
				if(result.success){
					alert("删除成功！")
					submitForm("<%=request.getContextPath() %>/productBaseSer/product",null);
				}else{
					alert(result.resultMsg);
				}
			});
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