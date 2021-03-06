package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Rafael on 16/06/2016.
 */
@Controller
public class AdminController {

    private Path path;

    @Autowired
    public ProductDao productDao;


    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products=productDao.getAllProducts();
        model.addAttribute("products",products);
        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product=new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");
        model.addAttribute("product",product);
        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct",method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request){
        productDao.addProduct(product);
        MultipartFile productImage=product.getProductImage();
        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
        path= Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");

        if(product.getProductImage()!=null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failded",e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId, Model model, HttpServletRequest request){


        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
        path= Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+productId+".png");

        if(Files.exists(path)){
            try{
                Files.delete(path);
            }catch(IOException e) {
                e.printStackTrace();
            }
        }

        productDao.deleteProduct(productId);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable Integer productId,Model model){
        Product product=productDao.getProductById(productId);
        model.addAttribute("product",product);
        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct",method = RequestMethod.POST)
    public String editProductPost(Integer productId,@ModelAttribute("product")Product product, Model model, HttpServletRequest request){
        product.setProductId(productId);
        MultipartFile productImage=product.getProductImage();
        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
        path=Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");

        if(productImage!=null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
                throw  new RuntimeException("Product image saving failed!",e);
            }
        }

        productDao.editProduct(product);
        return "redirect:/admin/productInventory";
    }
}
