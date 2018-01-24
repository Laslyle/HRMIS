/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.io.IOException;
import java.util.List;

import com.brainstrongtech.hrmis.dao.EmployeeDao;
import com.brainstrongtech.hrmis.dao.EmployeeDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author joeyang ong
 *
 */
public class EmpShortListerUI implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render() {

		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		
		for(Employee emp:empList)
		   emp.shortListOut();
		
		SysUtils.pause("\nPress Enter to continue...");		

	}

	@Override
	public void render(Employee e) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
