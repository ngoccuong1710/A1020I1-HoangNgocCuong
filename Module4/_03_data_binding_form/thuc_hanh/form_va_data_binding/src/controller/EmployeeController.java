package controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/", "/employee"})
public class EmployeeController {
    @RequestMapping(value = {"/", "/showform"}, method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
    public String create(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){
        model.addAttribute("id", employee.getId());
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        return "info";
    }
}
