/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.util.Set;

import com.brainstrongtech.hrmis.dao.EmployeeDao;
import com.brainstrongtech.hrmis.dao.EmployeeDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author joeyang ong
 *
 */
public class EmpFormattedListerUI implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render() {

		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		Set<Employee> empList = empDao.loadSortedEmps();
		
		for(Employee emp:empList)
		   emp.formattedListOut();
		
		SysUtils.pause("\nPress Enter to continue...");		

	}

}
