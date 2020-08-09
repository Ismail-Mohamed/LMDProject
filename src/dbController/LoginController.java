package dbController;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ismail 2020
 * @project LMD university system
 **/
public class LoginController {

    public static boolean Login(String username, String password) throws SQLException, ClassNotFoundException {

        String SQL = "SELECT * FROM users WHERE username=? AND password=?";

        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, username);
        stm.setObject(2, password);
        ResultSet rst = stm.executeQuery();

        if (rst.next()) {
            if(!username.equals(rst.getString(1))){
                return false;
        }

        if (password.equals(rst.getString(2))) {
            return true;
        }
    }
        return false;
  }
}
