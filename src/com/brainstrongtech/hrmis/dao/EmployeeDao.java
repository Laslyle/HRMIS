/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;

/**
 * @author joeyang ong
 *
 */
public interface EmployeeDao {
	
	List<Employee> loadEmps();
	Set<Employee> loadSortedEmps();

}
