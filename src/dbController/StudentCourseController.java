package dbController;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCourseController {

    public static int addStudentNote(Integer studentID,Integer courseID,Float Note)throws ClassNotFoundException, SQLException {
        String SQL="INSERT INTO student_course VALUES (?, ?, ?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, studentID);
        stm.setObject(2, courseID);
        stm.setObject(3, Note);

        return  stm.executeUpdate();
    }

    public static float searchStudentNote(Integer studentID ,Integer courseID) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM student_course WHERE student_id = ? AND course_id= ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, studentID);
        stm.setObject(2, courseID);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            float note = rst.getFloat(3);
            return note;
        }
        return -1;
    }


    public static int deleteStudentNote(Integer studentID, Integer courseID) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM student_course WHERE student_id = ? AND course_id= ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, studentID);
        stm.setObject(2, courseID);

        return  stm.executeUpdate();
    }

    public static int updateStudentNote(Integer studentID,Integer courseID,Float Note) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE student_course SET student_id= ? ,course_id= ? ,note ? WHERE student_id= '" +studentID+ "' AND course_id= '" +courseID+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, studentID);
        stm.setObject(2, courseID);
        stm.setObject(3, Note);

        return  stm.executeUpdate();
    }

}
