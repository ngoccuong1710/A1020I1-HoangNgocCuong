package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/product"})
    public String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/";
    }
}
