package com.yht.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yht.util.Action;
import com.yht.util.ActionMethod;

@Action("loginAction")
public class LoginAction {
	@ActionMethod("login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		System.out.println("=================");
		return "/test1/a1.yht";
	}
}
