package kr.ac.mjc.product.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.product.domain.Product;
import kr.ac.mjc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductViewController {

    @Autowired
    ProductService productService;

    private long id;

    @GetMapping("/main")
    public String showMainPage() {
        return "main";
    }

    @GetMapping("/products")
    public ModelAndView getProducts(){
        ModelAndView mav=new ModelAndView();
        List<Product> products = productService.findAll();
        mav.addObject("products",products);
        mav.setViewName("productList");
        return mav;
    }

    @GetMapping("/products/{id}")
    public ModelAndView getProduct(@PathVariable long id){
        ModelAndView mav = new ModelAndView();
        Product product = productService.findOne(id);
        mav.addObject("product",product);
        mav.setViewName("product");
        return mav;
    }

    @GetMapping("/buy/{id}")
    public ModelAndView getBuy(@PathVariable long id){
        ModelAndView mav = new ModelAndView();
        Product product = productService.findOne(id);
        mav.addObject("product",product);
        mav.setViewName("buy");
        return mav;
    }
}
