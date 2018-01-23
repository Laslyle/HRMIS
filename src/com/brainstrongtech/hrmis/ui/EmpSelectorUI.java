/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.util.List;

import com.brainstrongtech.hrmis.dao.EmployeeDao;
import com.brainstrongtech.hrmis.dao.EmployeeDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author Hong
 *
 */
public class EmpSelectorUI implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render() {
		// TODO Auto-generated method stub
      System.out.println("Enter keyword:");
      String entry = null;
      entry = SysUtils.getEntry("No keyword entered ¨C try again",false);
      EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		
		for(Employee emp:empList)
		{
			if(entry.equalsIgnoreCase(emp.getLastName())){
		   emp.listOut();
			break;
			}
		}
		SysUtils.pause("\nPress Enter to continue...");
	}

}
