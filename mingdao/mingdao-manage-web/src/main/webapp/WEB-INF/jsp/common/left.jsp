<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- #section:basics/sidebar -->
			<div id="sidebar" class="sidebar responsive">
				<ul class="nav nav-list">
					<li class="active">
						<a href="#">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text"> 查看首页 </span>
						</a>

						<b class="arrow"></b>
					</li>

					<!--begin_zhangfx5_增加系统设置菜单-->
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								系统设置
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>
									门店管理
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>

								<ul class="submenu">
									<li class="">
										<a href="<%=request.getContextPath() %>/store/stores" target="mainFrame">
											<i class="menu-icon fa fa-caret-right"></i>
											门店管理
										</a>

										<b class="arrow"></b>
									</li>
								</ul>
							</li>

							<li class="">
								<a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>
									服务项目
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>
								<ul class="submenu">
									<li class="">
										<a href="projectType.html">
											<i class="menu-icon fa fa-caret-right"></i>
											服务产品分类
										</a>

										<b class="arrow"></b>
									</li>
									<li class="">
										<a href="project.html">
											<i class="menu-icon fa fa-caret-right"></i>
											服务项目
										</a>

										<b class="arrow"></b>
									</li>
								</ul>
							</li>

							<li class="">
								<a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>
									权限设置
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>
								<ul class="submenu">
									<li class="">
										<a href="<%=request.getContextPath() %>/user/users" target="mainFrame">
											<i class="menu-icon fa fa-caret-right"></i>
											用户管理
										</a>

										<b class="arrow"></b>
									</li>
									<li class="">
										<a href="<%=request.getContextPath() %>/role/roles" target="mainFrame">
											<i class="menu-icon fa fa-caret-right"></i>
											角色管理
										</a>

										<b class="arrow"></b>
									</li>
									<li class="">
										<a href="authinfo.html">
											<a href="<%=request.getContextPath() %>/permission/permissions" target="mainFrame">
											权限管理
										</a>

										<b class="arrow"></b>
									</li>
									<li class="">
										<a href="menuinfo.html">
											<i class="menu-icon fa fa-caret-right"></i>
											菜单管理
										</a>

										<b class="arrow"></b>
									</li>
								</ul>
							</li>

							<li class="">
								<a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>
									微信后台
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>
								<ul class="submenu">
									<li class="">
										<a href="weixinlist.html">
											<i class="menu-icon fa fa-caret-right"></i>
											关注列表
										</a>

										<b class="arrow"></b>
									</li>
								</ul>

							</li>


						</ul>
					</li>
					<!--end_zhangfx5_增加系统设置菜单-->
				</ul><!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>