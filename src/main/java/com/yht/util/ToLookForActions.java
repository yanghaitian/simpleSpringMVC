package com.yht.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ToLookForActions {
	public static Map<String,String> allActionMap=new HashMap();
	public void onLoadAction(){
		ToAllClasses tac=new ToAllClasses();
		String actionpackagename=tac.readProperties();
		AllClasses c=new AllClasses();
		//读取配置文件取得所有的class对象
		Set<Class<?>> classs=c.getClasses(tac.readProperties());
		//遍历class对象
		for(Class<?> cc:classs){
			//如果class对象上面有@action的注释
			if(cc.isAnnotationPresent(Action.class));
			{
				//取得注释对象 用来获取@action注释的内容
				Action action=cc.getAnnotation(Action.class);
//				allActionMap.put(cc.getName(), action.value());
				//根据class对象取得他的方法对象
				Method[] methods=cc.getDeclaredMethods();
				//遍历方法对象
				for(Method method:methods)
				{
					//判断方法对象上面有没有@ActionMetod注释
					if(method.isAnnotationPresent(ActionMethod.class))
					{
						//取得注释对象，用来获取@ActionMetod注释内容
						ActionMethod actionMetod=method.getAnnotation(ActionMethod.class);
						//拼接成map集合   是   url对应类的方法  如   loginAction/login  对应 com.yht.loginAction.login
						allActionMap.put(action.value()+"/"+actionMetod.value(), cc.getName()+"."+method.getName());
					}
				}
			}
		}
	}
}