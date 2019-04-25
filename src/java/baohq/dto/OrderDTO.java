/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.dto;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class OrderDTO implements Serializable{
    private String orderID, username, productID, productName, quantity;
    private float total;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String username, float total) {
        this.orderID = orderID;
        this.username = username;
        this.total = total;
    }

    public OrderDTO(String username) {
        this.username = username;
    }

    public OrderDTO(String orderID, String productID, String quantity) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    
}
