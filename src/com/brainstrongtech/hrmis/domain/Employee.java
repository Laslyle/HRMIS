/**
 * 
 */
package com.brainstrongtech.hrmis.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 员工类
 * @author joeyang ong
 *
 */
public class Employee extends ValueObject implements Comparable<Employee>{
static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	 /** 员工工号  */
	 private String payrollNo;
	 
	 /** 员工办公电话  */
	 private String telephoneNum;
	 
	 /** 员工名称  */
	 private String lastName; 
	 
	 /** 员工姓氏  */
	 private String firstName;
	 
	 private String initial;
	 
	 /** 员工部门编号  */
	 private Integer deptNo; //能使用类类型尽量使用，语意表达能力更好
	 
	 /** 员工职务  */
	 private String jobTitle;
	 
	 /** 员工入职日期  */
	 private Date hiringDate;

	public String getPayrollNo() {
		return payrollNo;
	}

	public void setPayrollNo(String payrollNo) {
		this.payrollNo = payrollNo;
	}

	public String getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		//链式编程
		sb.append(this.payrollNo).append(":")
		  .append(this.telephoneNum).append(":")
		  .append(this.lastName).append(":")
		  .append(this.firstName).append(":")
		  .append(this.initial).append(":")
		  .append(this.deptNo).append(":")
		  .append(this.jobTitle).append(":")
		  .append(sdf.format(this.hiringDate));
		
		return sb.toString();		  
		
	}
	
	public static Employee parseEmpData(String data){
		//111:02-98781999:Williams:Nick:T:35:Computer Officer:14-10-2000
		Employee emp = new Employee();
		String[] sections = data.split("\\:");
		
		emp.setPayrollNo(sections[0]);
		emp.setTelephoneNum(sections[1]);
		emp.setLastName(sections[2]);
		emp.setFirstName(sections[3]);
		emp.setInitial(sections[4]);
		emp.setDeptNo(Integer.parseInt(sections[5]));
		emp.setJobTitle(sections[6]);
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			emp.setHiringDate(sdf.parse(sections[7]));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
			
	}
	
	/**
	 * 普通输出
	 */
	public void listOut(){
		System.out.println(this);
	}
	
	/**
	 * 普通格式化输出
	 */
	public void formattedListOut(){
		String outStr = String.format("%-20s%-15s%-6s%-9s%-15s%-6s%-21s%-25s", this.lastName,this.firstName,this.initial,this.payrollNo,this.telephoneNum,this.deptNo,this.jobTitle,sdf.format(this.hiringDate));
	    System.out.println(outStr);
	}
	
	
	/**
	 * 短格式输出
	 */
	public void shortListOut(){
		System.out.println(this.lastName+","+this.firstName+","+this.telephoneNum);
	}
	
	public void shortFormattedLister(){
		System.out.println(this.lastName+","+this.firstName+","+this.telephoneNum);
	}

	@Override
	public int compareTo(Employee otherEmp) {
		
		return this.lastName.compareTo(otherEmp.lastName);
	}
	 
	
}
