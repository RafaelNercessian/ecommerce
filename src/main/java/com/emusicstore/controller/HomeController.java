package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

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
            products=productDao.getProductList();
        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model){
        Product productSearched=productDao.productId(productId);
        model.addAttribute("product",productSearched);
        return "viewProduct";
    }
}
