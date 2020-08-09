package dbController;

import db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SemesterController {
    public static ArrayList<String> getSemesters() throws ClassNotFoundException, SQLException {
        Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("SELECT semester.name FROM semester");

        ArrayList<String>semesterList=new ArrayList<>();
        while(rst.next()){
            semesterList.add(rst.getString("name"));
        }
        return semesterList;
    }
}
