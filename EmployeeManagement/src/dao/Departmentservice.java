package dao;

import java.util.List;

import model.Department;

public interface Departmentservice {
	//get all details from department table
	//we need list-->collection
	public List<Department> getAllDepartmentss();//get all details
	public Department getDept(int deptid);//get details by their id
}
