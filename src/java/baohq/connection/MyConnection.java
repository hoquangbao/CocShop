/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class MyConnection implements Serializable{
    public static Connection getMyConnection() throws Exception{
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=CocShop", "sa", "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
