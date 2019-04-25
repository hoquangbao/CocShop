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
public class ProductDTO implements Serializable {

    private String productID, productName, description, type;
    private float price;
    private int quantity;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, float price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductDTO(String productID, String productName, String type, float price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductDTO(String productID, String productName, String description, String type, float price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    
    public ProductDTO(String productID, String productName, String description, String type, float price) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public ProductDTO(String productID, String productName, String type, float price) {
        this.productID = productID;
        this.productName = productName;
        this.type = type;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
