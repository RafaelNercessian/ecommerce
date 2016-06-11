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
        product1.setProductName("Guitar1");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("Fender strat guitar");
        product1.setProductPrice(1200);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setUnitInStock(11);
        product1.setProductManufacturer("Fender");
        productList.add(product1);

        Product product2=new Product();
        product2.setProductName("Record1");
        product2.setProductCategory("Record");
        product2.setProductDescription("Awesome mix");
        product2.setProductPrice(25);
        product2.setProductCondition("new");
        product2.setProductStatus("Active");
        product2.setUnitInStock(11);
        product2.setProductManufacturer("EMI");
        productList.add(product2);

        Product product3=new Product();
        product3.setProductName("Speaker");
        product3.setProductCategory("Speaker");
        product3.setProductDescription("Shelf speaker");
        product3.setProductPrice(355);
        product3.setProductCondition("new");
        product3.setProductStatus("Active");
        product3.setUnitInStock(9);
        product3.setProductManufacturer("EMI");
        productList.add(product3);
        return productList;
    }
}
