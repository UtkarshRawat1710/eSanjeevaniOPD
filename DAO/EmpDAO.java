
package sanjeevaniapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.EmpPojo;

public class EmpDAO {
public static String getNextEmpId()throws SQLException{
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select max(emp_id) from employees");
    rs.next();
    String str=rs.getString(1);
    int empId=101;
    if(str!=null){
        String id=str.substring(1);
        empId=Integer.parseInt(id);
        empId++;
    }
    String newId="E"+empId;
    return newId;
}
public static boolean addEmp(EmpPojo emp)throws SQLException{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Insert into employees values(?,?,?,?)");
    ps.setString(1, emp.getEmpId());
    ps.setString(2, emp.getEmpName());
    ps.setString(3, emp.getEmpDept());
    ps.setDouble(4,emp.getEmpSal());
    return ps.executeUpdate()==1;
}
public static List<String> getAllemployeeId()throws SQLException{
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select emp_id from employees");
    List<String> empIdList=new ArrayList<>();
    while(rs.next()){
        empIdList.add(rs.getString(1));
    }
    return empIdList;
}       
 public static EmpPojo getEmployeeDetails(String empId)throws SQLException{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select * from employees where emp_id=?");
    ps.setString(1,empId);
    ResultSet rs=ps.executeQuery();
    rs.next();
    EmpPojo emp=new EmpPojo();
    emp.setEmpId(rs.getString(1));
    emp.setEmpName(rs.getString(2));
    emp.setEmpDept(rs.getString(3));
    emp.setEmpSal(rs.getDouble(4));
    return emp;
    
 } 
 public static boolean updateEmployee(EmpPojo emp)throws SQLException{
     updateName(emp);
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update employees set emp_name=?,emp_salary=? where emp_id=?");
     ps.setString(1, emp.getEmpName());
     ps.setDouble(2, emp.getEmpSal());
     ps.setString(3, emp.getEmpId());
     return ps.executeUpdate()==1;
 }
 public static void updateName(EmpPojo emp)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Select emp_name from employees where emp_id=?");
     ps.setString(1, emp.getEmpId());
     ResultSet rs=ps.executeQuery();
     rs.next();
     String currName=rs.getString(1);
     String newName=emp.getEmpName();
     UserDAO.updateName(currName,newName);
     if(emp.getEmpDept().equalsIgnoreCase("Receptionist"))
         ReceptionistDAO.updateName(currName,newName);
     else if(emp.getEmpDept().equalsIgnoreCase("Doctor"))
         DoctorsDAO.updateName(currName,newName);
     
 }
 public static List<EmpPojo> getAllEmployeeDetails()throws SQLException{
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select * from employees order by emp_id");
    List<EmpPojo>empList=new ArrayList<>();
    while(rs.next()){
    EmpPojo emp=new EmpPojo();
    emp.setEmpId(rs.getString(1));
    emp.setEmpName(rs.getString(2));
    emp.setEmpDept(rs.getString(3));
    emp.setEmpSal(rs.getDouble(4));
    empList.add(emp);
    }
    return empList;
    
 } 
 public static Map<String,String> getUnRegisteredDoctors()throws SQLException{
   Connection conn=DBConnection.getConnection();
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("Select emp_id,emp_name from employees where emp_department='DOCTOR' and emp_name not in (select user_name from users where user_type='DOCTOR')order by emp_id");
   Map<String,String> unRegDocList=new HashMap<>();
   while(rs.next()){
       String id=rs.getString(1);
       String name=rs.getString(2);
       unRegDocList.put(id, name);
   }
   return unRegDocList;
 }
 public static Map<String,String> getUnRegisteredReceptionists()throws SQLException{
   Connection conn=DBConnection.getConnection();
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("Select emp_id,emp_name from employees where emp_department='RECEPTIONIST' and emp_name not in (select user_name from users where user_type='RECEPTIONIST')order by emp_id");
   Map<String,String> unRegRecepList=new HashMap<>();
   while(rs.next()){
       String id=rs.getString(1);
       String name=rs.getString(2);
       unRegRecepList.put(id, name);
   }
   return unRegRecepList;
 }
 public static boolean deleteEmployeebyId(String empId)throws SQLException{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select emp_department,emp_name from employees where emp_id=?");
   ps.setString(1, empId);
     ResultSet rs=ps.executeQuery();
     rs.next();
     String empdepartment=rs.getString(1);
     String empname=rs.getString(2);
       UserDAO.deleteUserByName(empname);
       
    if( empdepartment.equalsIgnoreCase("Receptionist"))
    {
        ReceptionistDAO.deleteReceptionistByName(empname);
            
       
    }
        
     else if( empdepartment.equalsIgnoreCase("Doctor"))
     {
        DoctorsDAO.deletedoctorByName(empname);
          
        
     }
      ps=conn.prepareStatement("Delete from employees where emp_id=?");
     ps.setString(1, empId);
     return ps.executeUpdate()==1; 
    
 
    
 } 
 public static boolean updateEmployeebyrecname(String oldname,String newname)throws SQLException{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("update employees set emp_name=? where emp_name=? and emp_department='RECEPTIONIST'");
   ps.setString(1, newname);
      ps.setString(2, oldname);

     
     return ps.executeUpdate()==1; 
    
 
    
 } 
}
