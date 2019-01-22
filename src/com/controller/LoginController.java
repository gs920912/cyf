package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.CUserInfo;
import com.service.UserService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/loginSystem", method=RequestMethod.POST)
	public String loginSystem(CUserInfo cu,HttpSession session){
		String url = "index";
		String msg = "";
		CUserInfo cuInfo = userService.checkUser(cu);
		if(cuInfo==null||cuInfo.equals(null)){
			System.out.println("用户名密码错误！");
			url = "index";
			msg = "用户名密码错误！";
			session.setAttribute("msg", msg);
		}else{
			session.setAttribute("cu", cu);
			url = "main";
		}
		return url;
	}
	/**
	 * 左侧菜单
	 * @return
	 *//*
	@RequestMapping("/left")
	public String loginLeft(){
		return "left";
	}
	*//**
	 * 右侧页面
	 * @return
	 *//*
	@RequestMapping("/rmain")
	public String loginRight(){
		return "rmain";
	}
	*//**
	 * 退出登录
	 * @return
	 *//*
	@RequestMapping("/out")
	public String loginOut(HttpSession session){
		session.removeAttribute("cu");
		return "index";
	}*/
}
