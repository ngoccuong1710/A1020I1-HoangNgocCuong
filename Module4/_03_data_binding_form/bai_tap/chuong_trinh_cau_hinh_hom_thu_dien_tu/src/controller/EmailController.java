package controller;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    @GetMapping(value = {"/", "/formSettingEmail"})
    public ModelAndView settingEmailForm(){
        ModelAndView modelAndView = new ModelAndView("settingEmail");
        modelAndView.addObject("setting", new Email());

        List<String> listLanguage = new ArrayList<String>();
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");
        modelAndView.addObject("listLanguage", listLanguage);

        List<Integer> listPageSize = new ArrayList<>();
        listLanguage.add("5");
        listLanguage.add("10");
        listLanguage.add("15");
        listLanguage.add("25");
        listLanguage.add("50");
        listLanguage.add("100");
        modelAndView.addObject("listPageSize", listPageSize);

        return modelAndView;
    }

    @PostMapping(value = "/settingEmail")
    public ModelAndView settingEmail(@ModelAttribute("email") Email email){
        return new ModelAndView("settingEmail", "email", email);
    }
}
