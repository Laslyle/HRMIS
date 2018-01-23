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
public class EmpAddUI implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Employee em=new Employee();
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		String entry = null;
         System.out.println("ÐË°î×ÊÑ¶ ¨C Employee Record:\r\n====================================\r\nEmployee Record Addition:\r\n");
         System.out.println("Enter the following details of the new employee:\r\nEmployee 3 digit payroll number\r\nPhone Number\r\nLast Name\r\nFirst Name\r\nMiddle Init\r\nDept #\r\nJob Title\r\nDate Hir\r\n\r\n");
         while(true){
         System.out.println("Enter employee 3 digit payroll number");
			  entry = SysUtils.getEntry("No payroll number entered ¨C try again",false);
				int flag=0;
				for(Employee s:empList){
					if(s.getPayrollNo().equals(entry)){
						System.out.println("Repeate!");
						flag=1;
					}
				}
		
			 if (entry.matches("[\\D]{1,}"))
					System.out.println("Payroll number can contain only numerical characte");
				else if(entry.matches("^[\\d]{3}$")&&flag==0){
				em.setPayrollNo(entry);
			break;
			  
         }	  
			  
	}
	}
}
