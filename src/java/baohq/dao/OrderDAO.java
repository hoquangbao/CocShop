/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.dao;

import baohq.connection.MyConnection;
import baohq.dto.OrderDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class OrderDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<OrderDTO> showOrder(String orderID) throws Exception{
        List<OrderDTO> result = null;
        String productID = null;
        String quantity = null;
        OrderDTO dto = null;
        try {
            String sql = "SELECT  orderID, productID, quantity "
                    + "FROM tblBill "
                    + "WHERE orderID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                orderID = rs.getString("orderID");
                productID = rs.getString("productID");
                quantity = rs.getString("quantity");
                dto = new OrderDTO(orderID, productID, quantity);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    public List<OrderDTO> showOrderWithUsername() throws Exception{
        List<OrderDTO> result = null;
        String orderID = null;
        String username = null;
        float total = 0;
        OrderDTO dto = null;
        try {
            String sql = "SELECT orderID, username, total "
                    + "FROM tblOrder "
                    + "WHERE isDelete = 'False'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                orderID = rs.getString("orderID");
                username = rs.getString("username");
                total = rs.getFloat("total");
                dto = new OrderDTO(orderID, username, total);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
     
    public List<OrderDTO> searchOrder(String search) throws Exception{
        String orderID = null;
        String username = null;
        float total = 0;
        List<OrderDTO> result = null;
        OrderDTO dto = null;
        try {
            String sql = "SELECT orderID , username, total FROM tblOrder "
                    + "WHERE username LIKE ? AND isDelete = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setBoolean(2, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                orderID = rs.getString("orderID");
                username = rs.getString("username");
                total = rs.getFloat("total");
                dto = new OrderDTO(orderID, username, total);
                result.add(dto);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean insertOrder(OrderDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO tblOrder(orderID, username, total) "
                    + "VALUES(?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getOrderID());
            preStm.setString(2, dto.getUsername());
            preStm.setFloat(3, dto.getTotal());
            check = preStm.executeUpdate() > 0 ;
        } catch(Exception e){
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return check;
    }

    public int generateOrderID() throws Exception {
        int count = 0;
        try {
            String sql = "SELECT COUNT(orderID) AS COUNT FROM tblOrder";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                count = rs.getInt("COUNT");
            }
        } finally {
            closeConnection();
        }
        return count;
    }
    
    public boolean insertBill(String orderID, float total, String[] productName, String[] productID, String[] quantity) throws Exception{
        boolean check = false;
        try {
            String sql = "INSERT INTO tblBill(orderID, total, productName, productID, quantity) "
                    + "VALUES(?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            for(int i = 0; i < productID.length; i++){
                preStm.setString(1, orderID);
                preStm.setFloat(2, total);
                preStm.setString(3, productName[i]);
                preStm.setString(4, productID[i]);
                preStm.setString(5, quantity[i]);
                check = preStm.executeUpdate() > 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            closeConnection();
        } 
        return check;
    }
    
    public boolean deleteOrder(String orderID) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE tblOrder set isDelete = ? "
                    + "WHERE orderID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setString(2, orderID);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
}
