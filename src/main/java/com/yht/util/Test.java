package com.yht.util;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Action("test1")
public class Test {
	@ActionMethod("a1")
	public String a(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("123123");
		return "/test.jsp";
	}
	public static void main(String[] args) {
		ToLookForActions tlf=new ToLookForActions();
		tlf.onLoadAction();
		System.out.println(ToLookForActions.allActionMap);
	}

}