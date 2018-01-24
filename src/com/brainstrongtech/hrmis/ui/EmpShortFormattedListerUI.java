/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.io.IOException;
import java.util.Set;

import com.brainstrongtech.hrmis.dao.EmployeeDao;
import com.brainstrongtech.hrmis.dao.EmployeeDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author joeyang ong
 *
 */
public class EmpShortFormattedListerUI implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render() {
		// TODO Auto-generated method stub
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		Set<Employee> empList = empDao.loadSortedEmps();
		
		for(Employee emp:empList)
		   emp.shortFormattedLister();
		
		SysUtils.pause("\nPress Enter to continue...");		
	}

	@Override
	public void render(Employee e) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
