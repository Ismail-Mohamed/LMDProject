package dbController;

import db.DBConnection;
import model.StaffCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffCourseController {

    public static int addStaffCourse(StaffCourse staffCourse)throws ClassNotFoundException, SQLException {
        String sql="INSERT INTO staff_course VALUES(?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, staffCourse.getStaffID());
        stm.setObject(2, staffCourse.getCourseID());
        stm.setObject(4, staffCourse.getGradeID());
        stm.setObject(3, staffCourse.getSemesterID());

        return  stm.executeUpdate();
    }

    public static int deleteStaffCourse(Integer staffID,Integer courseID,Integer gradeID,Integer semesterID) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM staff_course WHERE staff_id = ?  and course_id = ?  and semester_id = ?  and grade_id = ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, staffID);
        stm.setObject(2, courseID);
        stm.setObject(3, semesterID);
        stm.setObject(4, gradeID);

        return  stm.executeUpdate();
    }

    public static int updateStaffCourse(StaffCourse oldSC,StaffCourse newSC) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE staff_course SET staff_id = ?, course_id = ?, grade_id = ?, semester_id = ? WHERE staff_id = '"+oldSC.getStaffID()+"' and course_id = '"+oldSC.getCourseID()+"' and semester_id = '"+oldSC.getSemesterID()+"' and grade_id = '"+oldSC.getGradeID()+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, newSC.getStaffID());
        stm.setObject(2, newSC.getCourseID());
        stm.setObject(3, newSC.getSemesterID());
        stm.setObject(4, newSC.getGradeID());

        return  stm.executeUpdate();
    }

    public static StaffCourse searchStaffCourse(Integer staffID,Integer courseID,Integer semesterID,Integer gradeID) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM staff_course WHERE staff_id = ?  and course_id = ?  and semester_id = ?  and grade_id = ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, staffID);
        stm.setObject(2, courseID);
        stm.setObject(3, semesterID);
        stm.setObject(4, gradeID);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            StaffCourse sc = new StaffCourse(rst.getInt(1),rst.getInt(2),rst.getInt(3), rst.getInt(4));
            return sc;
        }
        return null;
    }

}
