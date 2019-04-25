/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.dao;

import baohq.connection.MyConnection;
import baohq.dto.ProductDTO;
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
public class ProductDAO implements Serializable{
    
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
    
    public List<ProductDTO> showProduct() throws Exception{
        String productID = null;
        String productName = null;
        String type = null;
        float price = 0;
        List<ProductDTO> result = null;
        ProductDTO dto = null;
        try {
            String sql = "SELECT productID, productName, type, price FROM tblProduct "
                    + "WHERE isDelete = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                productID = rs.getString("productID");
                productName = rs.getString("productName");
                type = rs.getString("type");
                price = rs.getFloat("price");
                dto = new ProductDTO(productID, productName, type, price);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    public List<ProductDTO> searchProduct(String search) throws Exception{
        List<ProductDTO> result = null;
        String productID = null;
        String productName = null;
        String type = null;
        float price = 0;
        ProductDTO dto = null;
        try {
            String sql = "SELECT productID, productName, type, price FROM tblProduct "
                    + "WHERE productName LIKE ? AND isDelete = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setBoolean(2, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                productID = rs.getString("productID");
                productName = rs.getString("productName");
                type = rs.getString("type");
                price = rs.getFloat("price");
                dto = new ProductDTO(productID, productName, type, price);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    public ProductDTO searchProductLikeByPrimaryKey(String productID) throws Exception{
        ProductDTO result = null;
        try {
            String sql = "SELECT productID, productName, description, type, price FROM tblProduct "
                    + "WHERE productID LIKE ? AND isDelete = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, productID);
            preStm.setBoolean(2, false);
            rs = preStm.executeQuery();
            while(rs.next()){
                productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                String type = rs.getString("type");
                float price = rs.getFloat("price");
                result = new ProductDTO(productID, productName, description, type, price);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean deleteProduct(String productID) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE tblProduct SET isDelete = ? "
                    + "WHERE productID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setString(2, productID);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean updateProduct(ProductDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE tblProduct SET productName = ?, type = ?, price = ?, description = ? "
                    + "WHERE productID = ? AND isDelete = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getProductName());
            preStm.setString(2, dto.getType());
            preStm.setFloat(3, dto.getPrice());
            preStm.setString(4, dto.getDescription());
            preStm.setString(5, dto.getProductID());
            preStm.setBoolean(6, false);
            check = preStm.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean insertProduct(ProductDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "INSERT INTO tblProduct(productID, productName, price,description, type, isDelete) "
                    + "VALUES(?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getProductID());
            preStm.setString(2, dto.getProductName());
            preStm.setFloat(3, dto.getPrice());
            preStm.setString(4, dto.getDescription());
            preStm.setString(5, dto.getType());
            preStm.setBoolean(6, false);
            check = preStm.executeUpdate() >0;
        } finally{
            closeConnection();
        }
        return check;
    }
}
