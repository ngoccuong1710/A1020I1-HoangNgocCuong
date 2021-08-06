package vn.codegym.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.furama_resort.model.Customer;
import vn.codegym.furama_resort.model.CustomerType;
import vn.codegym.furama_resort.service.CustomerService;
import vn.codegym.furama_resort.service.CustomerTypeService;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @ModelAttribute("types")
    public Iterable<CustomerType> customerTypes(){
        return customerTypeService.findAll();
    }

    @GetMapping(value = {"/customer"})
    public String showList(@RequestParam("keyword") Optional<String> name, Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customerList;
        if (!name.isPresent()){
            customerList = customerService.findAll(pageable);
        }
        else {
            customerList = customerService.findAllByNameContaining(name.get(), pageable);
        }
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/customer/create")
    public String saveCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return "customer/create";
        }
        else {
            String id = "KH-" + ((int)(Math.random()*10000));
            customer.setId(id);
            customerService.save(customer);
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model)  {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/customer/update")
    public String update(Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable("id") String id){
        Customer customer = customerService.findById(id);
        customerService.delete(customer);
        return "redirect:/customer";
    }

}
