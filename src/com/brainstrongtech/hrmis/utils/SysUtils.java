/**
 * 
 */
package com.brainstrongtech.hrmis.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.ui.UIFactory;
import com.brainstrongtech.hrmis.ui.UIType;

/**
 * 
 * 系统工具类
 * @author joeyang ong
 *
 */
public final class SysUtils {
	
	
    /**
     * 从控制台上获得一行录入
     * @param blankErrMsg   空输入错误提示
     * @return
     */
	public static String getEntry(String blankErrMsg,boolean allowBlank){
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		
		try {
			entry = reader.readLine();
			if(isEmptyStr(entry) && !allowBlank)
				throw new BlankEntryException(blankErrMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entry;

	}
	
	/**
	 * 暂停（不带提示）
	 */
	public static void pause(){
		getEntry("",true);
	}
	
	/**
	 * 暂停（带提示）
	 */	
	public static void pause(String promptStr){
		System.out.print(promptStr);
		getEntry("", true);
	}
	
	
	/**
	 * 字符串空串检测
	 * @param str
	 * @return
	 */
	public static boolean isEmptyStr(String str){
		
		return str == null || str.trim().length()==0;
		
	}
	
	
	/**
	 * UI模块渲染显示
	 * @param type
	 */
	public static void renderUI(UIType type){
		try {
			UIFactory.getUI(type).render();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void renderUI(UIType type,Employee emp){
		try {
			UIFactory.getUI(type).render(emp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 系统启动前置资源检测
	 */
	public static void checkResource(){
		
		File dataFile = new File("d:/records.txt");
		if(!dataFile.exists())
			throw new HRMISException("Employee information data file not found ! Now exit!");
		
	}
	
	

}
