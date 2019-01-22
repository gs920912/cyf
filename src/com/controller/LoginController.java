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
			System.out.println("�û����������");
			url = "index";
			msg = "�û����������";
			session.setAttribute("msg", msg);
		}else{
			session.setAttribute("cu", cu);
			url = "main";
		}
		return url;
	}
	/**
	 * ���˵�
	 * @return
	 *//*
	@RequestMapping("/left")
	public String loginLeft(){
		return "left";
	}
	*//**
	 * �Ҳ�ҳ��
	 * @return
	 *//*
	@RequestMapping("/rmain")
	public String loginRight(){
		return "rmain";
	}
	*//**
	 * �˳���¼
	 * @return
	 *//*
	@RequestMapping("/out")
	public String loginOut(HttpSession session){
		session.removeAttribute("cu");
		return "index";
	}*/
}
