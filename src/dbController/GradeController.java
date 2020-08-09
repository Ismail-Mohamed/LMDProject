package dbController;

import com.mysql.jdbc.PreparedStatement;
import db.DBConnection;
import model.Grade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * @author ismail 2020
 * @project LMD university system
 **/
public class GradeController {

    public static ArrayList<String> getGrades() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select grade.code From grade");

        ArrayList<String>gradeList=new ArrayList<>();
        while(rst.next()){
            gradeList.add(rst.getString("code"));
        }
        return gradeList;
    }

}
