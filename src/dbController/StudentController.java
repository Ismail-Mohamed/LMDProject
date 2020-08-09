package dbController;

import model.Student;
import db.DBConnection;

import java.sql.*;

/**
 * @author ismail
 * @project LMD university system
 **/
public class StudentController {



    public static int AddStudent(Student student)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO student  (`identity_number`, `first_name`, `last_name`, `date_of_birth`, `gender`, `grade_id`, `section_id`, `groupe_id`, `department_id`, `phone`, `address`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, student.getIdNum());
        stm.setObject(2, student.getFirstName());
        stm.setObject(3, student.getLastName());
        stm.setObject(4, student.getDOB());
        stm.setObject(5, student.getGender());
        stm.setObject(6, student.getGrade());
        stm.setObject(7, student.getSection());
        stm.setObject(8, student.getGroup());
        stm.setObject(9, student.getDepartment());
        stm.setObject(10, student.getPhone());
        stm.setObject(11, student.getAddress());
        return  stm.executeUpdate();
    }
    public static Student searchStudent(Integer id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM student WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Student s = new Student(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7), rst.getInt(8), rst.getInt(9), rst.getInt(10) , rst.getString(11),rst.getString(12));
            return s;
        }
        return null;
    }


    public static int deleteStudent(Integer id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM student WHERE id = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    public static int updateStudent(Student student) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE student SET identity_number= ?, first_name= ?, last_name= ?, date_of_birth= ?, gender= ?, grade_id= ?, section_id= ?, groupe_id= ?, department_id= ?, phone= ?, address= ? WHERE id= '"+student.getId()+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, student.getIdNum());
        stm.setObject(2, student.getFirstName());
        stm.setObject(3, student.getLastName());
        stm.setObject(4, student.getDOB());
        stm.setObject(5, student.getGender());
        stm.setObject(6, student.getGrade());
        stm.setObject(7, student.getSection());
        stm.setObject(8, student.getGroup());
        stm.setObject(9, student.getDepartment());
        stm.setObject(10, student.getPhone());
        stm.setObject(11, student.getAddress());

        return  stm.executeUpdate();
    }



}
