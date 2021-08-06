package vn.codegym.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.furama_resort.model.*;
import vn.codegym.furama_resort.service.*;

import java.util.Optional;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes(){
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes(){
        return rentTypeService.findAll();
    }

    @GetMapping(value = {"/service"})
    public String showList(@RequestParam("keyword") Optional<String> name, Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Service> serviceList;
        if (!name.isPresent()){
            serviceList = serviceService.findAll(pageable);
        }
        else {
            serviceList = serviceService.findAllByNameContaining(name.get(), pageable);
        }
        model.addAttribute("serviceList", serviceList);
        return "service/list";
    }

    @GetMapping("/service/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    @PostMapping("/service/create")
    public String saveService(@ModelAttribute("service") Service service) {
        serviceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/service/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model)  {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        return "service/edit";
    }

    @PostMapping("/service/update")
    public String update(Service service){
        serviceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/service/delete/{id}")
    public String delete(@PathVariable("id") String id){
        Service service = serviceService.findById(id);
        serviceService.delete(service);
        return "redirect:/service";
    }
}
