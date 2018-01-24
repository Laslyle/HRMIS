/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import com.brainstrongtech.hrmis.dao.EmployeeDao;
import com.brainstrongtech.hrmis.dao.EmployeeDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.utils.SysUtils;


/**
 * @author Hong
 *
 */
public class EmpDelete implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render() throws IOException {
		// TODO Auto-generated method stub
		final String DATA_FILE = "d:\\records.txt";
		FileWriter fw;
			
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		String entry = null;
		int flag=0;
		System.out.println("ÐË°î×ÊÑ¶ ¨C Employee Records:\r\n====================================");
	    while(true){
		System.out.println("Enter employee¡¯s 3 digit payroll number to enable record deletion");
		try{
		entry = SysUtils.getEntry("No payroll number entered ¨C try again", false);
		}catch(BlankEntryException e){
			  SysUtils.pause(e.getMessage());
			  continue;
			}
		 if(entry.matches("^[\\d]{3}$")){
			 break;}
		 else
			 SysUtils.pause("Payroll number can contain only numerical characte");
	    }
		
		 
			 for (int i = 0; i < empList.size(); i++) {
		            if (empList.get(i).getPayrollNo().equals(entry)) {
		            	System.out.println("Confirm record deletion, (y)es or (n)o, ");
		            	entry = SysUtils.getEntry("", true);
		            	if(entry.equalsIgnoreCase("y")){
		            	   empList.remove(i);
		            	 flag=1;  
		            	}
		            	else 
		            	{
		            		flag=2;
		            		break;
		            	}
		            }
		        }
			 
			 if(flag==0)
         		{
				 System.out.println("Employee record for "+entry+" not found");
	            	SysUtils.pause("Press Enter to continue");
         		}
			 else if(flag==1){
				 fw = new FileWriter(DATA_FILE, false);
				for(Employee s:empList){
					//fw.write(s.getEmpPayNumber()+":"+s.getTelNumber()+":"+s.getLastName()+":"+s.getFirstName()+":"+s.getInitName()+":"+s.getDepNumber()+":"+s.getJobTitle()+":"+s.getDate()+"\r\n");
					fw.write(s.toString()+"\r\n");
			}
				
			fw.flush();
	        fw.close();
	        System.out.println("Record deleted");}
			 else
				 SysUtils.renderUI(UIType.MainMenu);
				 
			 
			 System.out.println("Delete another? (y)es or (n)o");
			 entry=SysUtils.getEntry("", true);
			 if(entry.equals("y"))
				 SysUtils.renderUI(UIType.EmpDelete);
			 else
				 SysUtils.renderUI(UIType.MainMenu);
	}

	@Override
	public void render(Employee e) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
