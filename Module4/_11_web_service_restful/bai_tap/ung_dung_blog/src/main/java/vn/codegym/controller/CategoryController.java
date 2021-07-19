package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Category;
import vn.codegym.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"/category"})
    public ResponseEntity<List<Category>> showList(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> saveCustomer(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/category/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable int id) {
        Category currentCategory = categoryService.findById(id);
        if (currentCategory == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentCategory.setName(category.getName());
        categoryService.update(category);
        return new ResponseEntity<>(currentCategory, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> delete(@PathVariable int id){
        Category category = categoryService.findById(id);
        if (category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
