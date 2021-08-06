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
import vn.codegym.furama_resort.service.DivisionService;
import vn.codegym.furama_resort.service.EducationDegreeService;
import vn.codegym.furama_resort.service.EmployeeService;
import vn.codegym.furama_resort.service.PositionService;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private DivisionService divisionService;

    @ModelAttribute("positions")
    public Iterable<Position> positions(){
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees(){
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public Iterable<Division> divisions(){
        return divisionService.findAll();
    }

    @GetMapping(value = {"/employee"})
    public String showList(@RequestParam("keyword") Optional<String> name, Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employeeList;
        if (!name.isPresent()){
            employeeList = employeeService.findAll(pageable);
        }
        else {
            employeeList = employeeService.findAllByNameContaining(name.get(), pageable);
        }
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }

    @GetMapping("/employee/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/employee/create")
    public String saveEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return "employee/create";
        }
        else {
            String id = "NV-" + ((int)(Math.random()*10000));
            employee.setEmployeeId(id);
            employeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("/employee/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model)  {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/employee/update")
    public String update(Employee employee){
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/delete/{id}")
    public String delete(@PathVariable("id") String id){
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
        return "redirect:/employee";
    }
}
