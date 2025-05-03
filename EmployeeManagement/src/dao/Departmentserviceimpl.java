package dao;
import java.sql.*;
import java.util.*;

import exception.DeptNotFoundException;
import model.Department;
import util.DBconn;
import java.io.*;
public class Departmentserviceimpl implements Departmentservice {

	@Override
	public List<Department> getAllDepartmentss() {
		List<Department> list =new ArrayList<>();//object created
		String query="Select * from Department";
		try(Connection con=DBconn.getConnection();
			PreparedStatement ps=con.prepareStatement(query))
		{
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				//list.add(new Department(rs.getInt("deptid"),rs.getString("deptname")));
			int departmentID = rs.getInt("deptid");
            String departmentName = rs.getString("deptname");
            System.out.println("ID: " + departmentID + ", Name: " + departmentName);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	@Override
	public Department getDept(int deptid) {
 
			String sql = "SELECT * FROM Department WHERE deptid = ?";
			Department dept = null;
	        try(Connection conn = DBconn.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, deptid);
	            ResultSet rs = stmt.executeQuery();
	            int departmentID=0;
	            if(rs!=null)
	            {
	            while(rs.next())
 
				{
					//list.add(new Department(rs.getInt("deptid"),rs.getString("deptname")));
 
	            departmentID = rs.getInt("deptid");
	            String departmentName = rs.getString("deptname");
	            System.out.println("ID: " + departmentID + ", Name: " + departmentName);
 
				}
 
	            }
	            if(departmentID != deptid)
		            throw new DeptNotFoundException("Department with depid: " + deptid + " not found");
		            return dept;
	        }
	        catch (DeptNotFoundException e) {
	        	System.out.println(e.getMessage());
	        }
	        catch (Exception e) {
	            System.out.println("Error Occurred : " + e.getMessage());
 
	        }
	           /* if(departmentID != deptid)
	            throw new Exception("Department with depid: " + deptid + " not found");
	            return dept;
	        } catch (SQLException e) {
	            System.out.println("Error Occurred 2: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error Occurred : " + e.getMessage());
	
	        }*/
	        return null;
 
		
	}
 
	
}
 
	
