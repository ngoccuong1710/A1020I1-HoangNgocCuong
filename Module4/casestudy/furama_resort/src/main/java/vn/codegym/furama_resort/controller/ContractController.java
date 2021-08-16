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
import vn.codegym.furama_resort.model.*;
import vn.codegym.furama_resort.service.*;

import java.util.Optional;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServiceService attachServiceService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ServiceService serviceService;

    @ModelAttribute("attachServices")
    public Iterable<AttachService> attachServices(){
        return attachServiceService.findAll();
    }

    @ModelAttribute("customers")
    public Iterable<Customer> customers(){
        return customerService.findAll();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> employees(){
        return employeeService.findAll();
    }

    @ModelAttribute("services")
    public Iterable<Service> services(){
        return serviceService.findAll();
    }

    @GetMapping(value = {"/contract"})
    public String showList(@RequestParam("keyword") Optional<String> employee,
                           @RequestParam("keyword") Optional<String> customer,
                           @RequestParam("keyword") Optional<String> service,
                           Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Contract> contractList;
        if (!employee.isPresent() || !customer.isPresent() || !service.isPresent()){
            contractList = contractService.findAll(pageable);
        }
        else {
            contractList = contractService.findAllByEmployeeContainingAndCustomerContainingAndServiceContaining(employee.get(), customer.get(), service.get(), pageable);
        }
        model.addAttribute("contractList", contractList);
        return "contract/list";
    }

    @GetMapping("/contract/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/contract/createContract");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/contract/create")
    public String saveContract(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return "contract/createContract";
        }
        else {
            contractService.save(contract);
            return "redirect:/contract";
        }
    }

    @GetMapping("/contractDetail/create")
    public ModelAndView showCreateContractDetailForm(){
        ModelAndView modelAndView = new ModelAndView("/contract/createContractDetail");
        modelAndView.addObject("contract", contractService.findAll());
        modelAndView.addObject("contractDetail", new ContractDetail());
        return modelAndView;
    }

    @PostMapping("/contractDetail/create")
    public String saveContractDetail(@Validated @ModelAttribute("contractDetail") ContractDetail contractDetail, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return "contract/createContractDetail";
        }
        else {
            contractDetailService.save(contractDetail);
            return "redirect:/contract";
        }
    }
}
