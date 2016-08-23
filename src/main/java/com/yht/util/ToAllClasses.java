package com.yht.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//读取配置文件取得需要的包名
public class ToAllClasses {
	public String readProperties(){
		Properties property = new Properties();
		String value=null;
		try {
			property.load(this.getClass().getResourceAsStream("/util.properties"));
			value= property.getProperty("actionpackage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}