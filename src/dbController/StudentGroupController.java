package dbController;


import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentGroupController {

    public static int addStudentToGroup(Integer studentID, Integer groupID,Integer gradeID)throws ClassNotFoundException, SQLException {
        String SQL="INSERT INTO student_groupe VALUES(?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, studentID);
        stm.setObject(2, groupID);
        stm.setObject(3, gradeID);

        return  stm.executeUpdate();
    }


    public static int searchStudentGroup(Integer studentID ,Integer gradeID) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM student_groupe WHERE student_id = ? AND grade_id= ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, studentID);
        stm.setObject(2, gradeID);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            int g = rst.getInt(2);
            return g;
        }
        return -1;
    }

    public static int deleteStudentGroup(Integer studentID, Integer gradeID) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM student_groupe WHERE student_id = ? AND grade_id= ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, studentID);
        stm.setObject(2, gradeID);

        return  stm.executeUpdate();
    }

    public static int updateStudentGroup(Integer studentID,Integer groupID,Integer gradeID) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE student_groupe SET student_id= ? ,groupe_id= ? ,grade_id= ? WHERE student_id= '" +studentID+ "' AND grade_id= '" +gradeID+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, studentID);
        stm.setObject(2, groupID);
        stm.setObject(3, gradeID);

        return  stm.executeUpdate();
    }
}

