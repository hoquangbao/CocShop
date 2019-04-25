/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.dto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author PC
 */
public class CartObj extends HashMap implements Serializable{
    private HashMap<String, ProductDTO> cart;

    public HashMap<String, ProductDTO> getCart() {
        return cart;
    }
    
    public CartObj() {
        super();
    }
    

    public void addToCart(ProductDTO dto) throws Exception{
//        if(this.cart.containsKey(dto.getProductID())){
//            int quantity = this.cart.get(dto.getProductID()).getQuantity() + 1;
//            dto.setQuantity(quantity);
//        }
//        this.cart.put(dto.getProductID(), dto);
        String key = dto.getProductID();
        if(this.containsKey(key)){
            int oldQuantity = ((ProductDTO)this.get(key)).getQuantity();
            ((ProductDTO)this.get(key)).setQuantity(oldQuantity + 1);
        }
        else{
            this.put(dto.getProductID(), dto);
        }
    }
    
    public void removeCart(String productID) throws Exception{
        if(this.containsKey(productID)){
            this.remove(productID);
        }
    }
    
//    public float getTotal() throws Exception{
//        float result = 0;
//        for(ProductDTO dto : this.cart.values()){
//            result += dto.getQuantity() * dto.getPrice();
//        }
//        return result;
//    }
}
