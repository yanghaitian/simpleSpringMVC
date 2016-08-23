package com.yht.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yht.util.ToLookForActions;

public class YhtServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url=request.getRequestURI();//取得 /shuju/.../a.yht
		url=url.replace(request.getContextPath(), "");//取得    /.../a.yht
		url=url.substring(1);//取得 .../a.yht
		url=url.substring(0,url.lastIndexOf("."));//取得 .../a
		Map<String,String> m=ToLookForActions.allActionMap;
		String value=m.get(url);
		if(value!=null&&!value.equals(""))
		{
			
			String valueclass=value.substring(0, value.lastIndexOf("."));//取得类型字符串 com.yht.action.haha
			String valuemethod=value.substring(value.lastIndexOf(".")+1);//取得方法名     
			try {
				Class clazz=Class.forName(valueclass);
				Method method=clazz.getMethod(valuemethod, HttpServletRequest.class,HttpServletResponse.class);
				Object o=clazz.newInstance();//根据类型和方法名字符串进行调用
				Object obj=method.invoke(o, request,response);
				if(obj!=null)
				{
					request.getRequestDispatcher((String)obj).forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
