package controller;

import model.Caculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @GetMapping(value = {"/", "caculator"})
    public String showCaculator(){
        return "index";
    }

    @PostMapping(value = "caculator")
    public String caculator(@RequestParam double firstNum, @RequestParam double secondNum,
                            @RequestParam String operator, Model model){
        Caculator caculator = new Caculator(firstNum, secondNum, operator);
        double result = caculator.result();
        model.addAttribute("result", result);
        return "index";
    }
}
