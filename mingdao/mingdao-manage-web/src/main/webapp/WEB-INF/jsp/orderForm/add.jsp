<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common_css.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/plugins/toastr/toastr.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/ace/assets/css/bootstrap-editable.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/plugins/bootstrap-table-1.11.1/bootstrap-table.min.css">
<style>
.form-group>label[class*=col-] {
    margin-bottom: 4px;
}
button,input,optgroup,select,textarea {
    color: inherit;
    font: inherit;
    margin: 0!important;
}
.form-group > label[class*="col-"] {
    margin-top: 1%;
}
</style>


</head>
<body class="no-skin">
<div class="main-content">
<div class="main-content-inner">
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-home home-icon"></i>
				<a href="#">维护订单</a>
			</li>
			<li class="active">维护订单管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<div class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="billNo">单据号</label>
                        <div class="col-sm-9">
                            <input type="text" id="billNo" placeholder="请输入单据号" class="col-xs-10 col-sm-5">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="customerName">顾客姓名</label>
                        <div class="col-sm-9">
                            <input type="hidden" id="customerId" class="col-xs-10 col-sm-5">
                            <input type="text" id="customerName" placeholder="请输入顾客姓名" class="col-xs-10 col-sm-5">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="memberShipId">会员卡号</label>
                        <div class="col-sm-9">
                            <input type="text" id="memberShipId" placeholder="请输入会员卡号" class="col-xs-10 col-sm-5">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="carInfoNO">车牌号</label>
                        <div class="col-sm-9">
                            <input type="text" id="carInfoNO" placeholder="请输入车牌号" class="col-xs-10 col-sm-5">
                        </div>
                    </div>  
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="maintenancePsnId">维护顾问</label>
                        <div class="col-sm-9">
                            <input type="text" id="maintenancePsnId" placeholder="请输入维护顾问" class="col-xs-10 col-sm-5">
                        </div>
                    </div>  
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="totalMount">合计金额</label>
                        <div class="col-sm-9">
                            <input type="text" id="totalMount" placeholder="请输入合计金额" class="col-xs-10 col-sm-5">
                        </div>
                    </div>  
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="isUserCosumerCard">是否使用消费卡</label>
                        <div class="col-sm-9">
                            <input type="text" id="isUserCosumerCard" placeholder="是否使用消费卡" class="col-xs-10 col-sm-5">
                        </div>
                    </div>
                    <hr>
                    <div id="prodToolbar">
                        <a href="javascript:void(0);" class="btn btn-primary" id="btn_add_product">新增行</a>
                        <a id="btn_delrow" class="btn btn-danger">删除行</a>
                    </div>
                    <table id="productTable"></table>
                    <hr>
                    <table id="serviceTable"></table>
                    <hr>
                    <table id="attachTable"></table>                        
                </div>
			</div>
		</div>
	</div>
</div>
</div>

<div class="modal fade" id="custRefModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="searchhdfbox_grid-table_add"
                    style="cursor: move;">
                <div class="widget-header">
                    <span class="ui-jqdialog-title" id="modalTitle" style="float: left;">选择客户</span>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                </div>
            </div>
            <div class="ui-jqdialog-content ui-widget-content" id="searchcntfbox_grid-table_add">
                <div id="fbox_grid-table_add1" class="searchFilter" style="overflow:hidden">
                    <div class="row">
                        <div class="col-xs-12">
                            <table id="customTable" class="table table-striped table-bordered table-hover"></table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"></div>
        </div>
    </div>
</div>

<%@ include file="../common/common_js.jsp"%>
<script src="<%=request.getContextPath() %>/resources/plugins/toastr/toastr.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/dist/js/x-editable/bootstrap-editable.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/plugins/bootstrap-table-1.11.1/bootstrap-table.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/plugins/bootstrap-table-1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/plugins/bootstrap-table-1.11.1/extensions/editable/bootstrap-table-editable.min.js"></script>

<script type="text/javascript">
var webContext = "/mingdao";
var pageContext = webContext+"/orderFormBaseSer";
var pageUrl = pageContext+"/pageQryOrderFormes";
var addPage = pageContext+"/addOrderForm";
var getCustomerUrl = webContext+"/customerBaseSer/pageQryCustomers";
var custTableInit = false;
$("#productTable").bootstrapTable({
    columns: [
        {
            checkbox: true
		},
        {
            field: "productId",
            title: "维修配件",
            editable: {
                type: "text"
            }
        }, {
            field: "rowno",
            title: "行号",
            editable: {
                type: "text"
            }
        },
        {
            field: "num",
            title: "数量",
            editable: {
                type: "text"
            }
        }, {
            field: "price",
            title: "单价",
            editable: {
                type: "text"
            }
        }, {
            field: "discount",
            title: "折扣",
            editable: {
                type: "text"
            }
        }, {
            field: "cost",
            title: "金额",
            editable: {
                type: "text"
            }
        }, {
            field: "memo",
            title: "备注",
            editable: {
                type: "text"
            }
        }],
        data: [],
        idField: "productIdid",
		uniqueId: "productId",
        editable: true,
        toolbar: "prodToolbar"
});

$("#btn_add_product").on("click",function(){
    var len = $('#productTable').bootstrapTable('getData').length;
    $('#productTable').bootstrapTable('insertRow', {
        index: len,
        row: {
            productId: "",
            rowno: len+1,
            num: "",
            price: "",
            discount: "",
            cost: "",
            memo: "",
        }
    });
});
$("#customerName").on("click",function(){
    if(!custTableInit){
        initCustomerTable();
    }
    $("#custRefModal").modal("show");
});
function initCustomerTable(){
    $("#customTable").bootstrapTable({
        columns: [
            {
                field: "code",
                title: "编码"
            },
            {
                field: "name",
                title: "姓名"
            },
            {
                field: "wxNickName",
                title: "微信昵称"
            }, {
                field: "phone",
                title: "手机"
            }],
        pagination: true,
        sidePagination: "server",
        pageSize: 10,
        pageList: "[5, 10, 20, 50, 100, 200]",
        responseHandler: function (res) {
            var result = res;
            if (result.success) {
                var data = {
                    total: res.result.totalCount,
                    rows: res.result.datas
                };
            } else {
                var data = {
                    total: 0,
                    rows: []
                };
                toastr.success("请稍后再试", "请求失败");
            }
            return data;
        },
        url: getCustomerUrl,
        queryParamsType: "",
        queryParams: function queryParams(params) {
            return {
                pageNo: params.pageNumber,
                pageSize: params.pageSize,
            };
        },
        onClickRow:function(row){
            $("#customerId").val(row.id);
            $("#customerName").val(row.name);
            $("#custRefModal").modal("hide");
        }
    });
}
</script>

</body>
</html>