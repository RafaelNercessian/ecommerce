package com.emusicstore.dao;

import com.emusicstore.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 11/06/2016.
 */
@Component
public class ProductDao {

    private List<Product> productList=new ArrayList<Product>();

    public List<Product> getProductList(){
        Product product1=new Product();
        product1.setProductName("Guitar");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("Fender strat guitar");
        product1.setProductPrice(1200);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setUnitInStock(11);
        product1.setProductManufacturer("Fender");
        productList.add(product1);
        return productList;
    }
}
