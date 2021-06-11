package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping(value = "/")
    public String viewIndex(){
        return "index";
    }

    @RequestMapping(value = "/dictionary", method = RequestMethod.POST)
    public String dictionary(@RequestParam("search") String search, ModelMap modelMap){
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");

        String result = dic.get(search);
        if (result != null) {
            modelMap.addAttribute("result", "Từ: " + search + " dịch ra là: " + result);
        } else {
            modelMap.addAttribute("result", "Not found");
        }
        return "index";
    }
}
