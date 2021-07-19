package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.service.BlogService;
import vn.codegym.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping(value = {"/", "/blog"})
    public ResponseEntity<List<Blog>> showList(){
    List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<Blog> saveCustomer(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/blog/{id}")
    public ResponseEntity<Blog> update(@RequestBody Blog blog, @PathVariable int id) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentBlog.setTitle(blog.getTitle());
        currentBlog.setContent(blog.getContent());
        currentBlog.setAuthor(blog.getAuthor());
        blogService.update(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/blog/show/{id}")
    public ResponseEntity<Blog> showinfo(@PathVariable("id") int id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blogInfo", blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
