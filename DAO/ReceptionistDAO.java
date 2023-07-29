
package sanjeevaniapp.dao;

import Sanjeevaniapp.pojo.ReceptionistPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapp.dbutil.DBConnection;
//import sanjeevaniapp.pojo.ReceptionistPojo;

public class ReceptionistDAO {
     public static void updateName(String currName,String newName)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update receptionists set receptionist_name=? where receptionist_name=?");
     ps.setString(1, newName);
     ps.setString(2, currName);
     ps.executeUpdate();
}
public static String getNewRecId()throws  SQLException{
   Connection conn=DBConnection.getConnection();
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("Select max(receptionist_id) from receptionists");
   rs.next();
   int recId=101;
   String id=rs.getString(1);
   if(id!=null){
       String num=id.substring(3);
       recId=Integer.parseInt(num)+1;
    }
   return "REC"+recId;
}      
  public static boolean addReceptionist(ReceptionistPojo rec)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Insert into receptionists values(?,?,?)");
     ps.setString(1,rec.getReceptionistId());
     ps.setString(2,rec.getReceptionistName());
     ps.setString(3,rec.getGender());
     
     return ps.executeUpdate()==1;
}
  public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException{
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select * from receptionists order by receptionist_id");
    List<ReceptionistPojo>recList=new ArrayList<>();
    while(rs.next()){
    ReceptionistPojo recep=new ReceptionistPojo();
    recep.setReceptionistId(rs.getString(1));
    recep.setReceptionistName(rs.getString(2));
    recep.setGender(rs.getString(3));
    recList.add(recep);
    
    }
    return recList;
} 
  public static List<String> getAllReceptionistId()throws SQLException
{
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select receptionist_id from receptionists");
    List<String>RecList=new ArrayList<>();
    while(rs.next())
    {
        RecList.add(rs.getString(1));
    }
    return RecList;
}
  public static boolean deleteReceptionistById(String RecId)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Select receptionist_name from receptionists where receptionist_id=?");
     ps.setString(1, RecId);
     ResultSet rs=ps.executeQuery();
     rs.next();
     String RecName=rs.getString(1);
     UserDAO.deleteUserByName(RecName);
     ps=conn.prepareStatement("Delete from  receptionists where receptionist_id=?");
     ps.setString(1, RecId);
     return ps.executeUpdate()==1;
}
  public static boolean deleteReceptionistByName(String Recname)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("delete  from receptionists where receptionist_name=?");
     ps.setString(1, Recname);
    return ps.executeUpdate()==1;
}
    public static ReceptionistPojo getRecepDetailsbyId(String recepId)throws SQLException{
          ReceptionistPojo recep=new ReceptionistPojo();
          Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("select * from receptionists where receptionist_id=?");
         ps.setString(1,recepId); 
         ResultSet rs=ps.executeQuery();
         rs.next();
       //  recep.setRecepName(rs.getString(2));
        // recep.setRecepId(rs.getString(1));
        recep.setReceptionistId(rs.getString(1));
        recep.setReceptionistName(rs.getString(2));
         recep.setGender(rs.getString(3));
         return recep;
      }
    public static boolean updateReceptionistbyId(ReceptionistPojo rec)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("update receptionists set receptionist_name=?,gender=? where receptionist_id=?");
     ps.setString(3,rec.getReceptionistId());
     ps.setString(1,rec.getReceptionistName());
     ps.setString(2,rec.getGender());
     
     return ps.executeUpdate()==1;
}
}
