/**
 * 
 */
package com.brainstrongtech.hrmis;

import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.ui.UIType;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author joeyang ong
 *
 */
public class SysLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			SysUtils.checkResource();
			SysUtils.renderUI(UIType.MainMenu);
		} catch (HRMISException e) {
			System.out.println(e.getMessage());
		}

	}

}
