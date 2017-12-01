<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common_css.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/plugins/toastr/toastr.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/plugins/bootstrap-table-1.11.1/bootstrap-table.min.css">



</head>
<body class="no-skin">
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
				<div class="pull-right tableTools-container">
					<div class="dt-buttons btn-overlap btn-group">
						<a href="#" class="btn btn-white btn-primary btn-bold" id="btn_add">新增</a>
					</div>
				</div>
				<table id="orderTable" class="table table-striped table-bordered table-hover">
				</table>
			</div>
		</div>
	</div>
</div>

<%@ include file="../common/common_js.jsp"%>
<script src="<%=request.getContextPath() %>/resources/plugins/toastr/toastr.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/plugins/bootstrap-table-1.11.1/bootstrap-table.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/plugins/bootstrap-table-1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript">
var webContext = "/mingdao";
var pageContext = webContext+"/orderFormBaseSer";
var pageUrl = pageContext+"/pageQryOrderFormes";
var addPage = pageContext+"/addOrderForm";
$("#orderTable").bootstrapTable({
    columns: [
        {
            field: "billNo",
            title: "单据号"
        }, {
            field: "customerName",
            title: "顾客姓名"
        },
        {
            field: "storeName",
            title: "所属门店"
        },
        {
            field: "memberShipId",
            title: "会员卡号"
        }, {
            field: "carInfoNO",
            title: "车牌号"
        }, {
            field: "maintenancePsnId",
            title: "维护顾问"
        },{
            field: "totalMount",
            title: "合计金额"
        },{
            field: "isUserCosumerCard",
            title: "是否使用消费卡"
        },{
            formatter: operateFormatter,
            title: "操作",
            events: {
                "click .edit": function (e, value, row, index) {
                    $("#editModal").modal("show");
                    $("#cronexpression").val(row.cronexpression);
                    $("#description").val(row.description);
                    $("#btn_save").off("click").on("click", function () {
                        var postData = {
                            id: row.id,
                            cronexpression: $("#cronexpression").val(),
                            description: $("#description").val()
                        };
                        common.postJson(saveUrl, postData, function (result) {
                            if (result.status == 1) {
                                $("#editModal").modal("hide");
                                refreshTable();
                                toastr.success("保存成功");
                            } else if (result.status == 0) {
                                toastr.error(result.msg);
                            }
                        });
                    });
                }
            }
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
    url: pageUrl,
    queryParamsType: "",
    queryParams: function queryParams(params) {
        return {
            pageNo: params.pageNumber,
            pageSize: params.pageSize,
        };
    }
});

 
function operateFormatter() {
    return [
        "<div class='btn-group'>",
        "<button class='btn-white btn btn-xs edit'>编辑</button>",
        "<button class='btn-white btn btn-xs delete'>删除</button>",
        "</div>"
    ].join("");
}
$("#btn_add").on("click",function(){
	window.location.href=addPage;
});
</script>

</body>
</html>