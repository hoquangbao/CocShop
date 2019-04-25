/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.bean;

import baohq.dao.UserDAO;
import baohq.dto.UserDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PC
 */
public class JavaBean_User implements Serializable{
    private String username, password;
    private UserDTO dto ;

    public JavaBean_User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDTO getDto() {
        return dto;
    }

    public void setDto(UserDTO dto) {
        this.dto = dto;
    }
    
    public String checkLogin() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.checkLogin(username, password);
    }
    
    public List<UserDTO> showUser() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.showUser();
    }
    
    public List<UserDTO> searchUser() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.searchUser(username);
    }

    public UserDTO searchUserByPrimaryKey() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.searchUserByPrimaryKey(username);
    }
    
    public boolean deleteUser() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.deleteUser(username);
    }
    
    public boolean updateUser() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.updateUser(dto);
    }
    
    public boolean insertUser() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.insertUser(dto);
    }
}
