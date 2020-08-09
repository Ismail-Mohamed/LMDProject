package dbController;

import db.DBConnection;
import model.Unit;
import java.sql.*;
import java.util.ArrayList;

public class UnitController {

    public static ArrayList<String> getUnits() throws ClassNotFoundException, SQLException {
        Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst=stm.executeQuery("SELECT unite.name FROM unite");

        ArrayList<String>unitsList=new ArrayList<>();
        while(rst.next()){
            unitsList.add(rst.getString("grade"));
        }
        return unitsList;
    }

    public static int addUnit(Unit unit)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO unite (code, name, coefficient, credit, semester_id) VALUES (?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, unit.getCode());
        stm.setObject(2, unit.getName());
        stm.setObject(3, unit.getCoefficient());
        stm.setObject(4, unit.getCredit());
        stm.setObject(5, unit.getSemesterId());

        return  stm.executeUpdate();
    }

    public static Unit searchUnit(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM unite WHERE id = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Unit unit = new Unit(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5),rst.getInt(6));
            return unit;
        }
        return null;
    }

    public static int updateUnit(Unit unit) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE unite SET code = ?, name = ?, coefficient = ?, credit = ?, semester_id = ? WHERE id = '"+unit.getId()+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, unit.getCode());
        stm.setObject(2, unit.getName());
        stm.setObject(3, unit.getCoefficient());
        stm.setObject(4, unit.getCredit());
        stm.setObject(5, unit.getSemesterId());

        return  stm.executeUpdate();
    }


    public static int deleteUnit(Integer id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM unite WHERE id = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }
}
