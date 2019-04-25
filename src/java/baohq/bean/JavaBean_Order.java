/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.bean;

import baohq.dao.OrderDAO;
import baohq.dto.OrderDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PC
 */
public class JavaBean_Order implements Serializable{
    private String orderID, username;
    private float total;
    private String[] productID, productName;
    private String[] quantity;
    OrderDTO dto ;

    public JavaBean_Order() {
    }

    public String getOrderID() {
        return orderID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String[] getProductName() {
        return productName;
    }

    public void setProductName(String[] productName) {
        this.productName = productName;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getProductID() {
        return productID;
    }

    public void setProductID(String[] productID) {
        this.productID = productID;
    }

    public String[] getQuantity() {
        return quantity;
    }

    public void setQuantity(String[] quantity) {
        this.quantity = quantity;
    }

    public OrderDTO getDto() {
        return dto;
    }

    public void setDto(OrderDTO dto) {
        this.dto = dto;
    }
    
    public List<OrderDTO> showOrder() throws Exception{
        OrderDAO dao = new OrderDAO();
        return dao.showOrder(orderID);
    }
    
    public List<OrderDTO> showOrderWithUsername() throws Exception{
        OrderDAO dao = new OrderDAO();
        return dao.showOrderWithUsername();
    }
    
    public boolean insertOrder() throws Exception{
        OrderDAO dao = new OrderDAO();
        return dao.insertOrder(dto);
    }
    
    public int generateOrderID() throws Exception{
        OrderDAO dao = new OrderDAO();
        return dao.generateOrderID();
    }
    
    public boolean insertBill() throws Exception{
        OrderDAO dao =  new OrderDAO();
        return dao.insertBill(orderID, total, productName, productID, quantity);
    }
    
    public boolean deleteOrder() throws Exception{
        OrderDAO dao  = new OrderDAO();
        return dao.deleteOrder(orderID);
    }
    
    public List<OrderDTO> searchOrder() throws Exception{
        OrderDAO dao  = new OrderDAO();
        return dao.searchOrder(username);
    }
}
