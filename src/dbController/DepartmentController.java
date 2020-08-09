package dbController;

import db.DBConnection;
import model.Department;
import java.sql.*;
import java.util.ArrayList;

public class DepartmentController {
    public static ArrayList<String> getDepartments() throws ClassNotFoundException, SQLException {
        Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst=stm.executeQuery("SELECT department.name FROM department");

        ArrayList<String>departmenstList=new ArrayList<>();
        while(rst.next()){
            departmenstList.add(rst.getString("name"));
        }
        return departmenstList;
    }

    public static int addDepartment(Department department)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO department (code, name, description, admin) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, department.getCode());
        stm.setObject(2, department.getName());
        stm.setObject(3, department.getDescription());
        stm.setObject(4, department.getAdmin());

        return  stm.executeUpdate();
    }

    public static int deleteDepartment(Integer id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM department WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    public static int updateDepartment(Department department)throws ClassNotFoundException,SQLException {
        String SQL="UPDATE department SET code = ?, name = ?, description = ?, admin = ? WHERE id = '"+department.getId()+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, department.getCode());
        stm.setObject(2, department.getName());
        stm.setObject(3, department.getDescription());
        stm.setObject(4, department.getAdmin());

        return  stm.executeUpdate();
    }
}
