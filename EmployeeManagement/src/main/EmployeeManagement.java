package main;
import java.util.*;

import dao.Departmentserviceimpl;
public class EmployeeManagement {

	public static void main(String[] args) {
		int option;
		System.out.println("1. display all department details");
		System.out.println("2. display department details by department id");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter option: ");
		option =sc.nextInt();
		switch(option) {
		case 1:
			System.out.println("Department details are: ");
			Departmentserviceimpl obj=new Departmentserviceimpl();
			obj.getAllDepartmentss();
			break;
		case 2:
			Departmentserviceimpl obj1=new Departmentserviceimpl();
			System.out.println("enter id: ");
			int id=sc.nextInt();
			obj1.getDept(id);
			break;
		default:
			System.out.println("invalid option");
		}
	}
}
