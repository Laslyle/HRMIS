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
 * ϵͳ������
 * @author joeyang ong
 *
 */
public final class SysUtils {
	
	
    /**
     * �ӿ���̨�ϻ��һ��¼��
     * @param blankErrMsg   �����������ʾ
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
	 * ��ͣ��������ʾ��
	 */
	public static void pause(){
		getEntry("",true);
	}
	
	/**
	 * ��ͣ������ʾ��
	 */	
	public static void pause(String promptStr){
		System.out.print(promptStr);
		getEntry("", true);
	}
	
	
	/**
	 * �ַ����մ����
	 * @param str
	 * @return
	 */
	public static boolean isEmptyStr(String str){
		
		return str == null || str.trim().length()==0;
		
	}
	
	
	/**
	 * UIģ����Ⱦ��ʾ
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
	 * ϵͳ����ǰ����Դ���
	 */
	public static void checkResource(){
		
		File dataFile = new File("d:/records.txt");
		if(!dataFile.exists())
			throw new HRMISException("Employee information data file not found ! Now exit!");
		
	}
	
	

}
