package vn.codegym.controller;

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
import vn.codegym.model.KhuyenMai;
import vn.codegym.service.KhuyenMaiService;

import java.text.ParseException;
import java.util.Optional;

@Controller
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @GetMapping(value = {"/khuyen-mai", "/"})
    public String showList(@RequestParam("keyword") Optional<String> mucGiamGia, Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<KhuyenMai> khuyenMais;
        if (!mucGiamGia.isPresent()){
            khuyenMais = khuyenMaiService.findAll(pageable);
        }
        else {
            khuyenMais = khuyenMaiService.findAllByMucGiamGiaContaining(mucGiamGia.get(), pageable);
        }
        model.addAttribute("khuyenMais", khuyenMais);
        return "list";
    }

    @GetMapping("/khuyen-mai/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("khuyenMai", new KhuyenMai());
        return modelAndView;
    }

    @PostMapping("/khuyen-mai/create")
    public String saveCustomer(@Validated @ModelAttribute("khuyenMai") KhuyenMai khuyenMai, BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        else {
            khuyenMaiService.save(khuyenMai);
            return "redirect:/";
        }
    }

    @GetMapping("/khuyen-mai/edit/{ma}")
    public String edit(@PathVariable("ma") Integer ma, Model model)  {
        KhuyenMai khuyenMai = khuyenMaiService.findById(ma);
        model.addAttribute("khuyenMai", khuyenMai);
        return "edit";
    }

    @PostMapping("/khuyen-mai/update")
    public String update(@Validated KhuyenMai khuyenMai, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }
        else {
            khuyenMaiService.save(khuyenMai);
            return "redirect:/";
        }
    }

    @GetMapping("/khuyen-mai/delete/{ma}")
    public String delete(@PathVariable("ma") Integer ma){
        KhuyenMai khuyenMai = khuyenMaiService.findById(ma);
        khuyenMaiService.delete(khuyenMai);
        return "redirect:/";
    }
}
