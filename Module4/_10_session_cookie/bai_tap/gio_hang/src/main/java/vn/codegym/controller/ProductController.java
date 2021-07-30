package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Cart;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("carts")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("carts")
    public HashMap<Long, Cart> getShowInfo(){
        return new HashMap<>();
    }

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

    @GetMapping("/buy")
    public String showCart(@SessionAttribute("carts")HashMap<Long, Cart> cartHashMap, Model model){
        model.addAttribute("carts", cartHashMap);
        model.addAttribute("cartNum", cartHashMap.size());
        model.addAttribute("cartMoney", totalPrice(cartHashMap));
        return "cart";
    }

    @GetMapping("/buy/{id}")
    public String addCart(@PathVariable("id") Long id, @SessionAttribute("carts") HashMap<Long, Cart> cartHashMap, Model model){
        if (cartHashMap == null){
            cartHashMap = new HashMap<>();
        }
        Product product = productService.findById(id);
        if (product != null){
            Cart item;
            if (cartHashMap.containsKey(id)){
                item = cartHashMap.get(id);
                item.setQuantity(item.getQuantity() + 1);
                cartHashMap.put(id, item);
            }
            else {
                item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartHashMap.put(id, item);
            }
        }
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("carts", cartHashMap);
        model.addAttribute("cartNum", cartHashMap.size());
        model.addAttribute("cartMoney", totalPrice(cartHashMap));
        return "list";
    }

    @GetMapping("delete/{id}")
    public String deleteCart(@PathVariable Long id, @SessionAttribute("carts") HashMap<Long, Cart> cartHashMap, Model model){
        if (cartHashMap == null){
            cartHashMap = new HashMap<>();
        }
        cartHashMap.remove(id);
        model.addAttribute("carts", cartHashMap);
        model.addAttribute("cartNum", cartHashMap.size());
        model.addAttribute("cartMoney", totalPrice(cartHashMap));
        return "redirect:/buy";
    }

    public double totalPrice(HashMap<Long, Cart> cartHashMap){
        int count = 0;
        for (Map.Entry<Long, Cart> list:cartHashMap.entrySet()){
            count += Double.parseDouble(list.getValue().getProduct().getNewPrice()) * list.getValue().getQuantity();
        }
        return count;
    }

}
