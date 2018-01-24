/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.exception.UnsupportedUITypeException;

/**
 * 
 * UI模块部件工厂
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
		else if(type.equals(UIType.EmpSelectorUI))
			ui=new EmpSelectorUI();
		else if(type.equals(UIType.EmpAddUI))
			ui=new EmpAddUI();
		else if(type.equals(UIType.EmpDelete))
			ui=new EmpDelete();
		else if(type.equals(UIType.EmpModify))
			ui=new EmpModify();
		else
			throw new UnsupportedUITypeException("invalid UI type found!");
		
		return ui;
		
	}

}
