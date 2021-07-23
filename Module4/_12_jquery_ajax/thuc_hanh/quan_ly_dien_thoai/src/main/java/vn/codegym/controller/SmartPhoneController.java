package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.SmartPhone;
import vn.codegym.service.SmartPhoneService;

import java.util.List;
import java.util.Optional;

@Controller
public class SmartPhoneController {
    @Autowired
    private SmartPhoneService smartPhoneService;

    @GetMapping(value = {"/", "/phone"})
    public String showList(Model model) {
        List<SmartPhone> smartPhones = smartPhoneService.findAll();
        model.addAttribute("smartPhones", smartPhones);
        return "phones/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/phones/create");
        modelAndView.addObject("phone", new SmartPhone());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("smartPhone") SmartPhone smartPhone, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create customer success");
        smartPhoneService.save(smartPhone);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("phone", smartPhoneService.findById(id));
        return "phones/edit";
    }

    @PostMapping("/update")
    public String update(SmartPhone smartPhone) {
        smartPhoneService.save(smartPhone);
        return "redirect:/";
    }
}
