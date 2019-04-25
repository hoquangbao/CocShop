/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.dao;

import baohq.connection.MyConnection;
import baohq.dto.UserDTO;
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
public class UserDAO implements Serializable{
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
    
    public String checkLogin(String username, String password) throws Exception{
        String role = "failed";
        try{
            String sql = "SELECT role FROM tblUser "
                    + "WHERE username = ? AND password = ? AND isDelete = 'False'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next()){
                role = rs.getString("role");
            }
        } finally{
            closeConnection();
        }
        return role;
    }
    
    public List<UserDTO> showUser() throws Exception{
        String username = null;
        String password = null;
        String email = null;
        String role = null;
        List<UserDTO> result = null;
        UserDTO dto = null;
        try {
            String sql = "SELECT username, password, email, role FROM tblUser "
                    + "WHERE isDelete = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                role = rs.getString("role");
                dto = new UserDTO(username, password, email, role);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    
    public List<UserDTO> searchUser(String search) throws Exception{
        List<UserDTO> result = null;
        String username = null;
        String email = null;
        String role = null;
        UserDTO dto = null;
        try {
            String sql = "SELECT username, email, role FROM tblUser "
                    + "WHERE username LIKE ? AND isDelete = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setBoolean(2, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                username = rs.getString("username");
                email = rs.getString("email");
                role = rs.getString("role");
                dto = new UserDTO(username, email, role);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    public UserDTO searchUserByPrimaryKey(String username) throws Exception{
        String email = null;
        String role = null;
        UserDTO result = null;
        try {
            String sql = "SELECT username, email, role FROM tblUser "
                    + "WHERE username LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            while(rs.next()){
                username = rs.getString("username");
                email = rs.getString("email");
                role = rs.getString("role");
                result = new UserDTO(username, email, role);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean deleteUser(String username) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE tblUser SET isDelete = ? "
                    + "WHERE username LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean updateUser(UserDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE tblUser SET "
                    + "password = ?, email = ?, role = ? "
                    + "WHERE username = ? AND isDelete = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getEmail());
            preStm.setString(3, dto.getRole());
            preStm.setString(4, dto.getUsername());
            preStm.setBoolean(5, false);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean insertUser(UserDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "INSERT INTO tblUser(username, password, email, role, isDelete) "
                    + "VALUES(?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getEmail());
            preStm.setString(4, dto.getRole());
            preStm.setBoolean(5, false);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
}
