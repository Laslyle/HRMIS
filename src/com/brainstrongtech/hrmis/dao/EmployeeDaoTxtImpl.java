/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.brainstrongtech.hrmis.domain.Employee;

/**
 * @author joeyang ong
 *
 */
public class EmployeeDaoTxtImpl implements EmployeeDao {
	
	private static final String DATA_FILE = "d:\\records.txt";

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.dao.EmployeeDao#loadEmps()
	 */
	@Override
	public List<Employee> loadEmps() {
		
		BufferedReader reader = null;
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(DATA_FILE)));
			String empData = null;
			
			while((empData = reader.readLine())!=null){
			    //System.out.println(empData);
				empList.add(Employee.parseEmpData(empData));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return empList;
	}

	@Override
	public Set<Employee> loadSortedEmps() {
		
		TreeSet<Employee> empSet = new TreeSet<Employee>(this.loadEmps());
		
		return empSet;
	}

}
