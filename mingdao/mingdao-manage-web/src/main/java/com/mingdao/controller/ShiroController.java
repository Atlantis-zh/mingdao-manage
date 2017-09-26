package com.mingdao.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mingdao.domain.UserInfo;

/**
 *
 * <code>ShiroController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午6:44:23
 * @author libinf
 */

@Controller
public class ShiroController {
	private static final Logger logger = Logger.getLogger(ShiroController.class);

	/**
	 * 
	 * <p>
	 * 说明：退出登录
	 * <li></li>
	 * </p>
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @date 2017年9月26日 下午6:54:34
	 * @since
	 */
	@RequestMapping(value = "/logout.html")
	public String doLogout(HttpServletRequest request, Model model) {
		SecurityUtils.getSubject().logout();
		return "redirect:login.html";
	}

	@RequestMapping(value = "/doLogin.html", method = RequestMethod.POST)
	public String doLogin(UserInfo user, HttpServletRequest request, Model model) {
		String msg;
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserCode(), user.getPassWord());
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				request.getSession().setAttribute("user", user);
				SavedRequest savedRequest = WebUtils.getSavedRequest(request);
				if (savedRequest == null || savedRequest.getRequestUrl() == null) {
					return "admin/home";
				} else {
					return "forward:" + savedRequest.getRequestUrl();
				}
			} else {
				return "login";
			}
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
			model.addAttribute("message", msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			model.addAttribute("message", msg);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			model.addAttribute("message", msg);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
			model.addAttribute("message", msg);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			model.addAttribute("message", msg);
		} catch (UnknownAccountException e) {
			msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
			model.addAttribute("message", msg);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！" + e.getMessage();
			model.addAttribute("message", msg);
		}
		return "login";
	}

}
