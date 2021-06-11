package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CurrencyController {

    @GetMapping("/")
    public String viewIndex(){
        return "index";
    }

    @RequestMapping(value = "/current", method = RequestMethod.POST)
    public String currencyMoney(@RequestParam("usd") double usd, Model model){
        double vnd = usd * 22000;
        model.addAttribute("usd", usd);
        model.addAttribute("result", usd + " USD = " +vnd + " VND");
        return "index";
    }
}
