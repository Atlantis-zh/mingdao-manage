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
                            <input type="text" id="memberShipId" placeholder="请输入会员卡号" class="col-xs-10 col-sm-5" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="carInfoNO">车牌号</label>
                        <div class="col-sm-9">
                            <input type="hidden" id="carInfoId" class="col-xs-10 col-sm-5">
                            <input type="text" id="carInfoNO" placeholder="请输入车牌号" class="col-xs-10 col-sm-5" readonly>
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
                        <label class="col-sm-3 control-label no-padding-right" for="isUserCosumerCard"></label>
                        <div class="col-sm-9">
                            <input type="checkbox" id="isUserCosumerCard"><label style="margin-left:5px;">是否使用消费卡</label>
                        </div>
                    </div>
                    <hr>
                    <div id="prodToolbar">
                        <a href="javascript:void(0);" class="btn btn-primary" id="btn_add_product">新增行</a>
                        <a id="btn_del_product" class="btn btn-danger">删除行</a>
                    </div>
                    <table id="productTable"></table>
                    <hr>
                    <div id="serviceToolbar">
                        <a href="javascript:void(0);" class="btn btn-primary" id="btn_add_service">新增行</a>
                        <a id="btn_del_service" class="btn btn-danger">删除行</a>
                    </div>
                    <table id="serviceTable"></table>
                    <hr>
                    <div id="attachToolbar">
                        <a href="javascript:void(0);" class="btn btn-primary" id="btn_add_attach">新增行</a>
                        <a id="btn_del_attach" class="btn btn-danger">删除行</a>
                    </div>
                    <table id="attachTable"></table>
                    <hr>
                    <div class="pull-right tableTools-container">
                        <div class="dt-buttons btn-overlap btn-group">
                            <a href="#" class="btn btn-success btn-bold" id="btn_save">保存</a>
                            <a href="#" class="btn btn-default btn-bold" id="btn_back">返回</a>
                        </div>
                    </div>                     
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
<div class="modal fade" id="productRefModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="searchhdfbox_grid-table_add"
                    style="cursor: move;">
                <div class="widget-header">
                    <span class="ui-jqdialog-title" id="modalTitle" style="float: left;">选择维修配件</span>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                </div>
            </div>
            <div class="ui-jqdialog-content ui-widget-content" id="searchcntfbox_grid-table_add">
                <div id="fbox_grid-table_add1" class="searchFilter" style="overflow:hidden">
                    <div class="row">
                        <div class="col-xs-12">
                            <table id="productRefTable" class="table table-striped table-bordered table-hover"></table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"></div>
        </div>
    </div>
</div>
<div class="modal fade" id="serviceRefModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="searchhdfbox_grid-table_add"
                    style="cursor: move;">
                <div class="widget-header">
                    <span class="ui-jqdialog-title" id="modalTitle" style="float: left;">选择服务项目</span>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                </div>
            </div>
            <div class="ui-jqdialog-content ui-widget-content" id="searchcntfbox_grid-table_add">
                <div id="fbox_grid-table_add1" class="searchFilter" style="overflow:hidden">
                    <div class="row">
                        <div class="col-xs-12">
                            <table id="serviceRefTable" class="table table-striped table-bordered table-hover"></table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"></div>
        </div>
    </div>
</div>
<div class="modal fade" id="attachRefModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="searchhdfbox_grid-table_add"
                    style="cursor: move;">
                <div class="widget-header">
                    <span class="ui-jqdialog-title" id="modalTitle" style="float: left;">选择附加项目</span>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                </div>
            </div>
            <div class="ui-jqdialog-content ui-widget-content" id="searchcntfbox_grid-table_add">
                <div id="fbox_grid-table_add1" class="searchFilter" style="overflow:hidden">
                    <div class="row">
                        <div class="col-xs-12">
                            <table id="attachRefTable" class="table table-striped table-bordered table-hover"></table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"></div>
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
var getCustomerUrl = webContext+"/memberShipBaseSer/refmembervos";
var getProductRefUrl = webContext+"/productBaseSer/pageQryProductes";
var getServiceRefUrl = webContext+"/serProductBaseSer/pageQryServiceProjects";
var getAttachRefUrl = webContext+"/attachProject/pageQryAttachProjects";
var custTableInit = false;
var serviceRefTableInit = false;
var attachRefTableInit = false;
initProductRefTable();
initServiceRefTable();
initAttachRefTable();
$("#productTable").bootstrapTable({
    columns: [
        {
            checkbox: true
		},        
        {
            field: "rowid",
            title: "表格ID",
            visible:false
        },
        {
            field: "productId",
            title: "商品ID",
            visible:false
        },
        {
            field: "productName",
            title: "维修配件",
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
        idField: "rowid",
		uniqueId: "rowid",
        editable: true,
        toolbar: "prodToolbar"
});
$("#serviceTable").bootstrapTable({
    columns: [
        {
            checkbox: true
		},
        {
            field: "rowid",
            title: "表格ID",
            visible:false
        },
        {
            field: "serviceProjectId",
            title: "服务项目ID",
            visible:false
        },
        {
            field: "serviceProjectName",
            title: "服务项目"
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
        idField: "rowid",
		uniqueId: "rowid",
        editable: true,
        toolbar: "serviceToolbar"
});
$("#attachTable").bootstrapTable({
    columns: [
        {
            checkbox: true
		},
        {
            field: "rowid",
            title: "表格ID",
            visible:false
        },
        {
            field: "attachProjectId",
            title: "附加项目ID",
            visible:false
        },
        {
            field: "attachProjectName",
            title: "附加费用",
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
        idField: "rowid",
		uniqueId: "rowid",
        editable: true,
        toolbar: "attachToolbar"
});

$("#btn_add_product").on("click",function(){
    $("#productRefModal").modal("show");
});
$("#btn_add_service").on("click",function(){
    $("#serviceRefModal").modal("show");
});
$("#btn_add_attach").on("click",function(){
    $("#attachRefModal").modal("show");
});
$("#btn_del_product").on("click", function () {
    deleteRow("productTable");
});
$("#btn_del_service").on("click", function () {
    deleteRow("serviceTable");
});
$("#btn_del_attach").on("click", function () {
    deleteRow("attachTable");
});
function deleteRow(table){
    var rows = $('#'+table).bootstrapTable('getSelections');
    if (rows.length > 0) {
        $.each(rows, function (i, value) {
            $('#'+table).bootstrapTable('removeByUniqueId', value.rowid);
        });
    }
}
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
                field: "custName",
                title: "姓名"
            },{
                field:"custPhone",
                title: "手机号"
            },
            {
                field: "platNumber",
                title: "车牌号"
            }, {
                field: "cardNo",
                title: "会员卡号"
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
            $("#customerId").val(row.customerId);
            $("#customerName").val(row.custName);
            $("#memberShipId").val(row.cardNo);
            $("#carInfoId").val(row.carInfoId);
            $("#carInfoNO").val(row.platNumber);
            $("#custRefModal").modal("hide");
        }
    });
}

function initProductRefTable(){
    $("#productRefTable").bootstrapTable({
        columns: [
            {
                field: "code",
                title: "编码"
            },
            {
                field: "name",
                title: "名称"
            },
            {
                field: "spec",
                title: "规格型号"
            }, {
                field: "salePrice",
                title: "销售价格"
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
        url: getProductRefUrl,
        queryParamsType: "",
        queryParams: function queryParams(params) {
            return {
                pageNo: params.pageNumber,
                pageSize: params.pageSize,
            };
        },
        onClickRow:function(row){
            var len = $('#productTable').bootstrapTable('getData').length;
            $('#productTable').bootstrapTable('insertRow', {
                index: len,
                row: {
                    rowid:len,
                    productId:row.id,
                    productName: row.name,
                    num: "",
                    price: "",
                    discount: "",
                    cost: "",
                    memo: "",
                }
            });
            $("#productRefModal").modal("hide");
        }
    });
}
function initServiceRefTable(){
    $("#serviceRefTable").bootstrapTable({
        columns: [
            {
                field: "code",
                title: "编码"
            },
            {
                field: "name",
                title: "名称"
            },
            {
                field: "spec",
                title: "规格"
            }, {
                field: "salePrice",
                title: "销售价格"
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
        url: getServiceRefUrl,
        queryParamsType: "",
        queryParams: function queryParams(params) {
            return {
                pageNo: params.pageNumber,
                pageSize: params.pageSize,
            };
        },
        onClickRow:function(row){
            var len = $('#serviceTable').bootstrapTable('getData').length;
            $('#serviceTable').bootstrapTable('insertRow', {
                index: len,
                row: {
                    rowid:len,
                    serviceProjectId:row.id,
                    serviceProjectName: row.name,
                    num: "",
                    price: "",
                    discount: "",
                    cost: "",
                    memo: "",
                }
            });
            $("#serviceRefModal").modal("hide");
        }
    });
}
function initAttachRefTable(){
    $("#attachRefTable").bootstrapTable({
        columns: [
            {
                field: "code",
                title: "编码"
            },
            {
                field: "name",
                title: "名称"
            },
            {
                field: "spec",
                title: "规格型号"
            }, {
                field: "salePrice",
                title: "销售价格"
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
        url: getAttachRefUrl,
        queryParamsType: "",
        queryParams: function queryParams(params) {
            return {
                pageNo: params.pageNumber,
                pageSize: params.pageSize,
            };
        },
        onClickRow:function(row){
            var len = $('#attachTable').bootstrapTable('getData').length;
            $('#attachTable').bootstrapTable('insertRow', {
                index: len,
                row: {
                    rowid:len,
                    attachProjectId:row.id,
                    attachProjectName: row.name,
                    num: "",
                    price: "",
                    discount: "",
                    cost: "",
                    memo: "",
                }
            });
            $("#attachRefModal").modal("hide");
        }
    });
}
$("#btn_save").on("click",function(){
    var billNo = $("#billNo").val();
    var customerId = $("#customerId").val();
    var memberShipId = $("#memberShipId").val();
    var carInfoId = $("#carInfoId").val();
    var maintenancePsnId = $("#maintenancePsnId").val();
    var totalMount = $("#totalMount").val();
    var isUserCosumerCard = $("#isUserCosumerCard").prop("checked");
    var product = $('#productTable').bootstrapTable('getData');
    var service = $('#serviceTable').bootstrapTable('getData');
    var attach = $('#attachTable').bootstrapTable('getData');
    $.each(product,function(index,value){
        delete value.rowid;
        delete value.productName;
    });
    $.each(service,function(index,value){
        delete value.rowid;
        delete value.serviceProjectName;
    });
    $.each(attach,function(index,value){
        delete value.rowid;
        delete value.attachProjectName;
    });
    var postData = {
        billNo:billNo,
        customerId:customerId,
        //memberShipId:memberShipId,
        carInfoId:carInfoId,
        maintenancePsnId:maintenancePsnId,
        totalMount:totalMount,
        isUserCosumerCard:isUserCosumerCard,
        product:product,
        service:service,
        attach:attach,
    }
    $.ajax({
        type: 'POST',
        url: "<%=request.getContextPath() %>/storeBaseSer/addStore",
        data: JSON.stringify(postData),
        dataType: "json",
        contentType: "application/json;charest=UTF-8",
        success: function (data, status) {
            if(data.success){
                toastr.success("保存成功！");
                setTimeout(() => {
                    window.location.href = "<%=request.getContextPath() %>/orderFormBaseSer/orderForm"
                }, 3000);
            }else{
                toastr.error(data.resultMsg,"保存失败");
            }
            
        },
        fail: function (err, status) {
            console.log(err)
        }
    });
})
</script>

</body>
</html>