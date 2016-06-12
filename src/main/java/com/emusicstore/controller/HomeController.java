package com.emusicstore.controller;

import com.emusicstore.model.Product;
import com.emusicstore.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rafael on 11/06/2016.
 */

@Controller
public class HomeController {

    @Autowired
    private ProductDao productDao;
    private List<Product> products;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        if(products==null)
            products=productDao.getAllProducts();
        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException{
        Product productSearched=productDao.getProductById(productId);
        model.addAttribute("product",productSearched);
        return "viewProduct";
    }
}
