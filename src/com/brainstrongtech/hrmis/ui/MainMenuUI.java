/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.io.IOException;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author joeyang ong
 *
 */
public class MainMenuUI implements BaseUI {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render() {
		
		boolean isContinuted = true;

		while(isContinuted){
			
			System.out.println("\n倓堊訧捅 - Employee Info Employee Info rmation - Main Menu");
			System.out.println("======================================================\n");
			System.out.println("1 - Print All Current Records");
			System.out.println("2 每 Print All Current Records (formatted)");
			System.out.println("3 每 Print Names and Phone Numbers");
			System.out.println("4 每 Print Names and Phone Numbers (formatted)");
			System.out.println("5 - Search for specific Record(s)");
			System.out.println("6 - Add New Records");
			System.out.println("7 每 Delete Records\n");
			System.out.println("Q - Quit\n");
			System.out.print("Your Selection:");
			
			String entry = null;
			
			try{
			  entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			  char choice = entry.toUpperCase().charAt(0);
			  
			  switch(choice){
			     case '1':
			    	 SysUtils.renderUI(UIType.Lister);
			    	 break;
			     case '2':
			    	 SysUtils.renderUI(UIType.FormattedLister);
			    	 break;
			     case '3':
			    	 SysUtils.renderUI(UIType.ShortLister);
			    	 break;	
			     case '4':
			    	 SysUtils.renderUI(UIType.ShortFormattedLister);
			    	 break;
			     case '5':
			         SysUtils.renderUI(UIType.EmpSelectorUI);
			         break;
			     case '6':
			         SysUtils.renderUI(UIType.EmpAddUI);
			         break;	
			     case '7':
			         SysUtils.renderUI(UIType.EmpDelete);
			         break;	
			     case 'Q':
			    	 isContinuted=false;
			    	 break;	
			     default:
			    	 SysUtils.pause("Invalid code Invalid code! Press Enter to continue＃ ");
			    	 break;
			  }
			  
			  
			}catch(BlankEntryException e){
			  SysUtils.pause(e.getMessage());
			  continue;
			}
		}
		
		System.out.println("\nThank you for using HRMIS V1.0,bye!");

	}

	@Override
	public void render(Employee e) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
