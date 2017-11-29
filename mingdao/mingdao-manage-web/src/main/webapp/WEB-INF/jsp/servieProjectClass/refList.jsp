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
		<div class="page-content">

			<div class="ui-jqdialog-content ui-widget-content" id="searchcntfbox_grid-table">
				<div>
					<div id="fbox_grid-table" class="searchFilter" style="overflow:auto">
						<table class="group ui-widget ui-widget-content ui-search-table" style="border:0px none;">
							<tbody>
							<tr>
								<td class="first"></td>
								<td class="columns"><label>名称：</label></td>
								<td class="data">
									<input type="text" id="search_code" name="search_name" role="textbox"
														class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
								</td>

								<td class="first"></td>
								<td class="columns"><label>编码：</label></td>
								<td class="data"><input type="text"  id="search_code" name="search_code" role="textbox"
														class="input-elm ui-widget-content ui-corner-all" style="width: 96%;">
								</td>
								<td class="first"></td>
								<td class="EditButton"><a id="fbox_grid-table_search"
														  class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-search btn btn-sm btn-purple"><span
										class="ace-icon fa fa-search"></span>查询</a></td>
							</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>编码</th>
										<th>名称</th>
										<th>选择</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${datas.datas}" var="vo">
									<tr>
										<td>${vo.code }</td>
										<td>${vo.name }</td>
										<td><input name="checked" type="radio" value="${vo.id},${vo.name}" /></td>
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
														<jsp:param value="refserviceclass" name="url"/>
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
			<div class="modal-footer">
				<a href="#" class="btn" onclick="getSelecOption()" data-dismiss="modal">确定</a>
			</div>

		</div>

	</div>



<%@ include file="../common/common_js.jsp"%>

<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.bootstrap.js"></script>


	<script type="text/javascript">
		    function getSelecOption(){
				var value = $('input:radio:checked').val();
				var array =value.split(",");
				parent.document.getElementById("serProdClassId").value = array[0];
				parent.document.getElementById("serProdClassName").value = array[1];
				parent.document.getElementById("serProdClassList").style.display="none";
			}

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
				submitForm("<%=request.getContextPath() %>/serProdClassBaseSer/refserviceProjectClasss",paramsArr);
	    	});
	</script>

</body>
</html>