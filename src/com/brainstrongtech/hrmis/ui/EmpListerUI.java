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
 * @author joeyang ong
 *
 */
public class EmpListerUI implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render() {
		
//		System.out.println("Emp Lister UI here!");
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		
		for(Employee emp:empList)
		   emp.listOut();
		
		SysUtils.pause("\nPress Enter to continue...");
		
	}

}
