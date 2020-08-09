package dbController;

import db.DBConnection;
import model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ismail 2020
 * @project LMD university system
 **/
public class StaffController {

    public static int AddStaff(Staff staff)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO staff (`identity_number`, `first_name`, `last_name`, `date_of_birth`, `gender`, `education_grade`, `department_id`, `phone`, `address`) VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, staff.getIdNum());
        stm.setObject(2, staff.getFirstName());
        stm.setObject(3, staff.getLastName());
        stm.setObject(4, staff.getDOB());
        stm.setObject(5, staff.getGender());
        stm.setObject(6, staff.getEducationGrade());
        stm.setObject(7, staff.getDepartmentID());
        stm.setObject(8, staff.getPhone());
        stm.setObject(9, staff.getAddress());

        return  stm.executeUpdate();
    }

    public static Staff searchStaff(Integer id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM staff WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Staff staff = new Staff(rst.getInt(1),rst.getInt(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7),rst.getInt(8),rst.getString(9),rst.getString(10));
            return staff;
        }
        return null;
    }

/*    public static Staff searchStaffByName(String firstName) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM staff WHERE first_name LIKE '%"+firstName+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Staff staff = new Staff(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));
            return staff;
        }
        return null;
    }
*/


    public static int deleteStaff(Integer id) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM staff WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    public static int updateStaff(Staff staff) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE staff SET identity_number = ?, first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, education_grade = ?, department_id = ?, phone = ?, address = ? WHERE id = '"+staff.getId()+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, staff.getIdNum());
        stm.setObject(2, staff.getFirstName());
        stm.setObject(3, staff.getLastName());
        stm.setObject(4, staff.getDOB());
        stm.setObject(5, staff.getGender());
        stm.setObject(6, staff.getEducationGrade());
        stm.setObject(7, staff.getDepartmentID());
        stm.setObject(8, staff.getPhone());
        stm.setObject(9, staff.getAddress());

        return  stm.executeUpdate();
    }

}
