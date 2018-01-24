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
public class EmpModify implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#render()
	 */
	@Override
	public void render(Employee emp) throws IOException {
		// TODO Auto-generated method stub
		boolean isContinuted = true;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		final String DATA_FILE = "d:\\records.txt";
		FileWriter fw;
		while(isContinuted){
			
			System.out.println("\n倓堊訧捅 - Employee Info Employee Info rmation - Modify Menu");
			System.out.println("======================================================\n");
			System.out.println("1 - Modify employee payroll numb");
			System.out.println("2 每 Modify telephone number");
			System.out.println("3 每 Modify last name");
			System.out.println("4 每 Modify first name");
			System.out.println("5 - Modify initial");
			System.out.println("6 - Modify department number");
			System.out.println("7 每 Modify job title");
			System.out.println("7 每 Modify date of hiring");
			System.out.println("Q - Quit\n");
			System.out.print("Your Selection:");
			
			String entry = null;
			
			try{
			  entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			  char choice = entry.toUpperCase().charAt(0);
			  
			  switch(choice){
			     case '1':
			    	 System.out.println("Enter new payroll NO:");
			    	 entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			    	 for(Employee emps:empList){
			    		 if(emp.getPayrollNo().equals(emps.getPayrollNo())){
			    	 emps.setPayrollNo(entry);
			    	 System.out.println("its");
			    		 }
			    		 }
			    	 fw = new FileWriter(DATA_FILE, false);
						for(Employee s:empList){
							fw.write(s.toString()+"\r\n");
					}
					fw.flush();
			        fw.close();
			        System.out.println("Modifcation! new payroll No is "+entry);
			        
			    	 
			    	 break;
			     case '2':
			    	
			    	 System.out.println("Enter new telephone number:");
			    	 entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			    	 for(Employee emps:empList){
			    		 if(emp.getPayrollNo().equals(emps.getPayrollNo())){
			    	 emps.setTelephoneNum(entry);
			    		 }
			    		 }
			    	 fw = new FileWriter(DATA_FILE, false);
						for(Employee s:empList){
							fw.write(s.toString()+"\r\n");
					}
					fw.flush();
			        fw.close();
			        System.out.println("Modifcation! new telephone number is "+entry);
			    	 
			    	 
			    	 break;
			     case '3':
			    	 System.out.println("Enter new last name:");
			    	 entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			    	 for(Employee emps:empList){
			    		 if(emp.getPayrollNo().equals(emps.getPayrollNo())){
			    	 emps.setLastName(entry);
			    		 }
			    		 }
			    	 fw = new FileWriter(DATA_FILE, false);
						for(Employee s:empList){
							fw.write(s.toString()+"\r\n");
					}
					fw.flush();
			        fw.close();
			        System.out.println("Modifcation! new last namer is "+entry);
			    	 break;	
			     case '4':
			    	 System.out.println("Enter new first name:");
			    	 entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			    	 for(Employee emps:empList){
			    		 if(emp.getPayrollNo().equals(emps.getPayrollNo())){
			    	 emps.setFirstName(entry);
			    		 }
			    		 }
			    	 fw = new FileWriter(DATA_FILE, false);
						for(Employee s:empList){
							fw.write(s.toString()+"\r\n");
					}
					fw.flush();
			        fw.close();
			        System.out.println("Modifcation! new first name is "+entry);
			    	 break;
			     case '5':
			    	 System.out.println("Enter new initial:");
			    	 entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			    	 for(Employee emps:empList){
			    		 if(emp.getPayrollNo().equals(emps.getPayrollNo())){
			    	 emps.setInitial(entry);
			    		 }
			    		 }
			    	 fw = new FileWriter(DATA_FILE, false);
						for(Employee s:empList){
							fw.write(s.toString()+"\r\n");
					}
					fw.flush();
			        fw.close();
			        System.out.println("Modifcation! new initial is "+entry);
			         break;
			     case '6':
			    	 System.out.println("Enter new department number:");
			    	 entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			    	 for(Employee emps:empList){
			    		 if(emp.getPayrollNo().equals(emps.getPayrollNo())){
			    	 emps.setDeptNo(Integer.parseInt(entry));
			    		 }
			    		 }
			    	 fw = new FileWriter(DATA_FILE, false);
						for(Employee s:empList){
							fw.write(s.toString()+"\r\n");
					}
					fw.flush();
			        fw.close();
			        System.out.println("Modifcation! new department number is "+entry);
			         break;	
			     case '7':
			    	 System.out.println("Enter new job title:");
			    	 entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			    	 for(Employee emps:empList){
			    		 if(emp.getPayrollNo().equals(emps.getPayrollNo())){
			    	 emps.setJobTitle(entry);;
			    		 }
			    		 }
			    	 fw = new FileWriter(DATA_FILE, false);
						for(Employee s:empList){
							fw.write(s.toString()+"\r\n");
					}
					fw.flush();
			        fw.close();
			        System.out.println("Modifcation! new job title is "+entry);
			         break;	
			     case '8':
			    	 System.out.println("Enter new date of hiring:");
			    	 entry = SysUtils.getEntry("No selection entered. Press Enter to continue＃",false);
			    	 for(Employee emps:empList){
			    		 if(emp.getPayrollNo().equals(emps.getPayrollNo())){
			    	 try {
						emps.setHiringDate(sdf.parse(entry));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    		 }
			    		 }
			    	 fw = new FileWriter(DATA_FILE, false);
						for(Employee s:empList){
							fw.write(s.toString()+"\r\n");
					}
					fw.flush();
			        fw.close();
			        System.out.println("Modifcation! new department number is "+entry);
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
	public void render() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
