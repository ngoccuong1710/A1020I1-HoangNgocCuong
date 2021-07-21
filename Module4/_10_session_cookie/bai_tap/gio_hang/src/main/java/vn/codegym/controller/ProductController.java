package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Cart;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import java.util.HashMap;
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

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model, @ModelAttribute("carts")HashMap<Long, Cart> cartHashMap){
        Product product = productService.findById(id);
        model.addAttribute("carts", cartHashMap);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        productService.remove(product);
        return "redirect:/";
    }
}
