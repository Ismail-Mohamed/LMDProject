package dbController;
import db.DBConnection;
import model.Group;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GroupController {

    public static HashMap<String, String> getGroups() throws ClassNotFoundException, SQLException {
        Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst=stm.executeQuery("SELECT * FROM groupe_list");

        HashMap<String, String> groupList =new HashMap<String, String>();
        while(rst.next()){
            groupList.put("groupe : " + rst.getString("group"),"\tgrade : " + rst.getString("grade"));
        }
        return groupList;
    }

    public static int addGroup(Group group)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO groupe (name, grade_id) VALUES (?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, group.getName());
        stm.setObject(2, group.getGradeID());

        return  stm.executeUpdate();
    }

    public static int deleteGroup(Integer id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM groupe WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }
    public static int updateGoup(Group group) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE groupe SET name = ?, grade_id = ? WHERE id = '"+group.getId()+"'";
                ;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, group.getName());
        stm.setObject(2, group.getGradeID());

        return  stm.executeUpdate();
    }
}
