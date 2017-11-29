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
					<a href="#">商品管理</a>
				</li>
				<li class="active">商品信息管理</li>
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
										<th>所属门店</th>
										<th>所属分类</th>
										<th>助记码</th>
										<th>规格型号</th>
										<th>价格</th>
										<th>计量单位</th>
										<th>使用车型</th>
										<th>是否共享</th>
										<th>备注</th>
										<th>状态</th>
										<th>用户操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${datas.datas}" var="product">
									<tr>
										<td>
											<a href="#">${product.code }</a>
										</td>
										<td>${product.name }</td>
										<td>${product.storeName}</td>
										<td>${product.productClassName}</td>
										<td>${product.mncode }</td>
										<td>${product.spec}</td>
										<td>${product.salePrice}</td>
										<td>${product.measdocId }</td>
										<td>${product.adapteCarType}</td>
										<td>
											<c:choose>
												<c:when test="${product.shareToBranch}">
													是
												</c:when>
												<c:otherwise>
													否
												</c:otherwise>
											</c:choose>
										</td>
										<td>${product.memo }</td>
										<td>${product.status}</td>
										<td>
											<a class="btn btn-xs btn-info" onclick="editProduct(${product.id},this)" id="editProduct"  data-toggle="modal" title="编辑">
												<i class="ace-icon fa fa-pencil bigger-120"></i>
											</a>

											<a class="btn btn-xs btn-danger" onclick="deleteProduct(${product.id})" title="删除">
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
												<a href="#" id="add" target="mainFrame" style="color:#FFF;text-decoration:none;" title="添加商品"  class="btn btn-info fa"  data-toggle="modal">+</a>
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
						<span class="ui-jqdialog-title" id="modalTitle" style="float: left;">新增商品</span>
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
									<label class="col-sm-3 control-label no-padding-right" for="name"> 名称: </label>

									<div class="col-sm-9">
										<input id="id" placeholder="id" class="col-xs-10 col-sm-5" type="hidden">
										<input id="name" placeholder="name" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="code">编码: </label>

									<div class="col-sm-9">
										<input id="code" placeholder="code" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="storeId">  所属门店: </label>

									<div class="col-sm-9">
										<input id="storeId" placeholder="storeId" class="col-xs-10 col-sm-5" type="hidden">
										<input id="storeName" placeholder="storeName" class="col-xs-10 col-sm-5" type="text">
										<button  data-toggle="modal" onclick="refStores(this);">参照门店</button>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="productClassId"> 所属分类: </label>

									<div class="col-sm-9">
										<input id="productClassId" placeholder="productClassId" class="col-xs-10 col-sm-5" type="hidden">
										<input id="productClassName" placeholder="productClassName" class="col-xs-10 col-sm-5" type="text">
										<button  data-toggle="modal" onclick="refProductClass(this);">参照所属分类</button>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="measdocId"> 计量单位: </label>

									<div class="col-sm-9">
										<input id="measdocId" placeholder="measdocId" class="col-xs-10 col-sm-5" type="hidden">
										<input id="measdocName" placeholder="measdocName" class="col-xs-10 col-sm-5" type="text">
										<button  data-toggle="modal" onclick="refMeasdoc(this);">计量单位</button>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="mncode">助记码: </label>

									<div class="col-sm-9">
										<input id="mncode" placeholder="mncode" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="spec">规格型号: </label>

									<div class="col-sm-9">
										<input id="spec" placeholder="spec" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="salePrice">销售价格: </label>

									<div class="col-sm-9">
										<input id="salePrice" placeholder="salePrice" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="adapteCarType">适用车型: </label>

									<div class="col-sm-9">
										<input id="adapteCarType" placeholder="adapteCarType" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="shareToBranch"></label>
	
										<div class="col-sm-9">
											<input id="shareToBranch" type="checkbox" style="margin-top:5%;margin-right:5px;">是否共享
										</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="memo">备注: </label>

									<div class="col-sm-9">
										<input id="memo" placeholder="memo" class="col-xs-10 col-sm-5" type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="status">状态: </label>

									<div class="col-sm-9">
										<input id="status" placeholder="status" class="col-xs-10 col-sm-5" type="text">
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

			$("#add").click(function(){
				$(this).attr("data-target","#addUser");
				$("#modalTitle").html("新增产品分类");
				$("#id").val("");
				$("#name").val("");
				$("#code").val("");
				$("#storeId").val("");
				$("#productClassId").val("");
				$("#measdocId").val("");
				$("#mncode").val("");
				$("#spec").val("");
				$("#salePrice").val("");
				$("#adapteCarType").val("");
				$("#memo").val("");
				$("#shareToBranch").prop("checked",false);
				$("#status").val("");
				$("#code").prop("disabled",false);

			});

			function editProduct(userId,obj){
				$(obj).attr("data-target","#addUser");
				$("#modalTitle").html("修改产品分类");
				$.get("<%=request.getContextPath() %>/productBaseSer/qryProductById",{"id":userId},function(resultStr){
					var result = JSON.parse(resultStr);
					if(result.success){
						var product = result.result;
						$("#id").val(product.id);
						$("#name").val(product.name);
						$("#code").val(product.code);
						$("#storeId").val(product.storeId);
						$("#storeName").val(product.storeName);
						$("#productClassId").val(product.parentId);
						$("#productClassName").val(product.productClassName);
						$("#measdocId").val(product.measdocId);
						$("#measdocName").val(product.measdocName);
						$("#mncode").val(product.mncode);
						$("#spec").val(product.spec);
						$("#salePrice").val(product.salePrice);
						$("#adapteCarType").val(product.adapteCarType);
						$("#memo").val(product.memo);
						$("#shareToBranch").prop("checked",product.shareToBranch);
						$("#status").val(product.status);
						$("#code").prop("disabled",true);
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
				submitForm("<%=request.getContextPath() %>/productBaseSer/product",paramsArr);
	    	});

		//新增操作
			$("#fbox_grid-table_add").click(function(){
				var name = $("#name").val();
				var code = $("#code").val();
				var storeId = $("#storeId").val();
				var productClassId = $("#productClassId").val();
				var measdocId = $("#measdocId").val();
				var mncode = $("#mncode").val();
				var spec = $("#spec").val();
				var salePrice = $("#salePrice").val();
				var adapteCarType = $("#adapteCarType").val();
				var memo = $("#memo").val();
				var shareToBranch = $("#shareToBranch").prop("checked");
				var status = $("#status").val();
				var id=$("#id").val();
				var postData={
					name:name,
					code:code,
					storeId:storeId,
					productClassId:productClassId,
					measdocId:measdocId,
					mncode:mncode,
					spec:spec,
					salePrice:salePrice,
					adapteCarType:adapteCarType,
					memo:memo,
					shareToBranch:shareToBranch,
					stauts:status,
					id:id
				}
				var url = "<%=request.getContextPath() %>/productBaseSer/addProduct";
				if(id!=""){
					url = "<%=request.getContextPath() %>/productBaseSer/updateProduct"
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
							submitForm("<%=request.getContextPath() %>/productBaseSer/product",null);
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
			$.get("<%=request.getContextPath() %>/productBaseSer/deleteProductById",{id:id},function(resultStr){
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