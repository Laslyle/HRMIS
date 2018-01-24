/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.brainstrongtech.hrmis.dao.EmployeeDao;
import com.brainstrongtech.hrmis.dao.EmployeeDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
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
	public void render() throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Employee em=new Employee();
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		String entry = null;
         System.out.println("倓堊訧捅 每 Employee Record:\r\n====================================\r\nEmployee Record Addition:\r\n");
         System.out.println("Enter the following details of the new employee:\r\nEmployee 3 digit payroll number\r\nPhone Number\r\nLast Name\r\nFirst Name\r\nMiddle Init\r\nDept #\r\nJob Title\r\nDate Hir\r\n\r\n");
         
		while (true) {
			System.out.println("Enter employee 3 digit payroll number");
			try{
			entry = SysUtils.getEntry("No payroll number entered 每 try again", false);
			}catch(BlankEntryException e){
				  SysUtils.pause(e.getMessage());
				  continue;
				}
			int flag = 0;
			for (Employee s : empList) {
				if (s.getPayrollNo().equals(entry)) {
					System.out.println("Repeate!");
					flag = 1;
				}
			}
			if (entry.matches("[\\D]{1,}"))
				System.out.println("Payroll number can contain only numerical characte");
			else if (entry.matches("^[\\d]{3}$") && flag == 0) {
				em.setPayrollNo(entry);
				break;
			}
		}
		
		while(true){
		System.out.println("Enter Phone Number (02-12345678)");
		try{
		entry = SysUtils.getEntry("No phone number entered 每 try again", false);
		}catch(BlankEntryException e){
			  SysUtils.pause(e.getMessage());
			  continue;
			}
          if(entry.matches("^0[2-8]{1}-[1-9]{1}[0-9]{7}$")){
		em.setTelephoneNum(entry);;
		break;}
		else
			System.out.println("Invalid phone number 每 try again");
		}
		
		while(true){
			System.out.println("Enter Last Name");
			try{
			entry = SysUtils.getEntry("No last name entered 每 try again", false);
			}catch(BlankEntryException e){
				  SysUtils.pause(e.getMessage());
				  continue;
				}
		    if(entry.matches("[a-zA-Z]*\\s*")){
				em.setLastName(entry);
			break;}
			else
				System.out.println("Last name can contain only alphabetical characters and spaces");
			}
		
		while(true){
			System.out.println("Enter First Name");
			try{
			entry = SysUtils.getEntry("No First name entered 每 try again", false);
			}catch(BlankEntryException e){
				  SysUtils.pause(e.getMessage());
				  continue;
				}
		 if(entry.matches("[a-zA-Z]*\\s*")){
				em.setFirstName(entry);
			break;}
			else
				System.out.println("First name can contain only alphabetical characters and spaces ");
			}
		
		while(true){
			System.out.println("Enter Middle Init");
			try{
			entry = SysUtils.getEntry("No Middle Init entered 每 try again", false);
			}catch(BlankEntryException e){
				  SysUtils.pause(e.getMessage());
				  continue;
				}
			if(entry.matches("[a-zA-Z]*\\s*")){
				em.setInitial(entry);
			break;}
			else
				System.out.println("Middle Initcan contain only alphabetical characters and spaces");
			}
		
		while(true){
			System.out.println("Enter Dept #");
			try{
			entry = SysUtils.getEntry("No Dept # entered 每 try again", false);
		}catch(BlankEntryException e){
			  SysUtils.pause(e.getMessage());
			  continue;
			}
			 if(entry.matches("^[\\d]{1,}$")){
				em.setDeptNo(Integer.parseInt(entry));
			break;}
			else
				System.out.println(" Dept # can contain only digits with no spaces");
			}
		
		while(true){
			System.out.println("Enter Job Title");
			try{
			entry = SysUtils.getEntry("No Job title entered 每 try again", false);
			}catch(BlankEntryException e){
				  SysUtils.pause(e.getMessage());
				  continue;
				}
		   if(entry.matches("[a-zA-Z]*\\s*")){
				em.setJobTitle(entry);
			break;}
			else
				System.out.println("Job title can contain only alphabetical characters and spaces");
			}
		
		while(true){
			System.out.println("Enter Date Hired (dd-mm-yyyy)");
			try{
			entry = SysUtils.getEntry("No date hired entered 每 try again", false);
			}catch(BlankEntryException e){
				  SysUtils.pause(e.getMessage());
				  continue;
				}
				System.out.println("No date hired entered 每 try again");
			if(entry.matches("(((0[1-9]|[12][0-9]|3[01])-((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)-(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])-(02))-([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))|(29/02/(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))")){
				try {
					em.setHiringDate(sdf.parse(entry));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;}
			else
				System.out.println("Invalid Date Hired");
			}
		empList.add(em);
	 final String DATA_FILE = "d:\\records.txt";
		FileWriter fw;
	
			fw = new FileWriter(DATA_FILE, false);
		
		for(Employee s:empList){
				try {
					//fw.write(s.getPayrollNo()+":"+s.getTelephoneNum()+":"+s.getLastName()+":"+s.getFirstName()+":"+s.getInitial()+":"+s.getDeptNo()+":"+s.getJobTitle()+":"+s.getHiringDate()+"\r\n");
				fw.write(s.toString()+"\r\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		try {
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Record Saved ");
		SysUtils.pause("\nPress Enter to continue...");
         
         
	}
}
