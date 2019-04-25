/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.bean;

import baohq.dao.ProductDAO;
import baohq.dto.ProductDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PC
 */
public class JavaBean_Product implements Serializable{
    private String productID;
    ProductDTO dto;

    public JavaBean_Product() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public ProductDTO getDto() {
        return dto;
    }

    public void setDto(ProductDTO dto) {
        this.dto = dto;
    }
    
    public List<ProductDTO> showProduct() throws Exception{
        ProductDAO dao = new ProductDAO();
        return dao.showProduct();
    }
    
    public List<ProductDTO> searchProduct() throws Exception{
        ProductDAO dao = new ProductDAO();
        return dao.searchProduct(productID);
    }
    
    public ProductDTO searchProductByPrimaryKey() throws Exception{
        ProductDAO dao = new ProductDAO();
        return dao.searchProductLikeByPrimaryKey(productID);
    }
    
    public boolean deleteProduct()throws Exception{
        ProductDAO dao = new ProductDAO();
        return dao.deleteProduct(productID);
    }
    
    public boolean updateProduct() throws Exception{
        ProductDAO dao = new ProductDAO();
        return dao.updateProduct(dto);
    }
    
    public boolean insertProduct() throws Exception{
        ProductDAO dao = new ProductDAO();
        return dao.insertProduct(dto);
    }
}
