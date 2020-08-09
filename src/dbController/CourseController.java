package dbController;

import db.DBConnection;
import model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseController {


    public static int addCourse(Course course)throws ClassNotFoundException, SQLException {
        String SQL="INSERT INTO course (code, name, coefficient, credit, unite_id, semester_id, grade_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, course.getCode());
        stm.setObject(2, course.getName());
        stm.setObject(3, course.getCoefficient());
        stm.setObject(4, course.getCredit());
        stm.setObject(5, course.getUnit());
        stm.setObject(6, course.getSemesterID());
        stm.setObject(7, course.getGradeID());

        return  stm.executeUpdate();
    }

    public static Course searchCourse(Integer id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM course WHERE id = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Course c = new Course(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getInt(4), rst.getInt(5), rst.getInt(6), rst.getInt(7), rst.getInt(8));
            return c;
        }
        return null;
    }


    public static int deleteCourse(Integer id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM course WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    public static int updateCourse(Course course) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE course SET code = ?, name = ?, coefficient = ?, credit = ?, unite_id = ?, semester_id = ?, grade_id = ? WHERE id = '"+course.getId()+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, course.getCode());
        stm.setObject(2, course.getName());
        stm.setObject(3, course.getCoefficient());
        stm.setObject(4, course.getCredit());
        stm.setObject(5, course.getUnit());
        stm.setObject(6, course.getSemesterID());
        stm.setObject(7, course.getGradeID());

        return  stm.executeUpdate();
    }
}
