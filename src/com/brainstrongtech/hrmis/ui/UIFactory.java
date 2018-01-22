/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.exception.UnsupportedUITypeException;

/**
 * 
 * UIģ�鲿������
 * @author joeyang ong
 *
 */
public class UIFactory {
	
	public static BaseUI getUI(UIType type){
		
		BaseUI ui = null;
		
		if(type.equals(UIType.MainMenu))
			ui = new MainMenuUI();
		else if(type.equals(UIType.Lister))
			ui = new EmpListerUI();
		else if(type.equals(UIType.FormattedLister))
			ui = new EmpFormattedListerUI();
		else if(type.equals(UIType.ShortLister))
			ui = new EmpShortListerUI();
		else if(type.equals(UIType.ShortFormattedLister))
			ui=new EmpShortFormattedListerUI();
		
		else
			throw new UnsupportedUITypeException("invalid UI type found!");
		
		return ui;
		
	}

}
