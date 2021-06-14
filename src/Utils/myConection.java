/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ray Khum
 */
public class myConection {

    public static Connection makeConnection() {
        Connection cn = null;
        try {
            //b1: nap driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ItemManagement";
            cn = DriverManager.getConnection(url, "sa", "thanhtin123");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cn;
    }

    public static boolean checkLogin(String email, String password) {
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "select userID,password \n"
                        + "from tblUsers\n"
                        + "where userID = ? and password = ?";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if(rs.next())
                {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
