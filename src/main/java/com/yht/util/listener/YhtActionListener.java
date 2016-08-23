package com.yht.util.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yht.util.ToLookForActions;

public class YhtActionListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("开始加载action");
		ToLookForActions tlf=new ToLookForActions();
		tlf.onLoadAction();
		System.out.println("加载action结束");
	}

}
