package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.exception.NotAvailableException;
import vn.codegym.exception.NotBorrowException;
import vn.codegym.exception.WrongCodeException;
import vn.codegym.model.Book;
import vn.codegym.service.BookService;
import vn.codegym.service.CodeService;
import vn.codegym.service.StatusService;
import vn.codegym.validate.ReturnCodeWrapper;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    CodeService codeService;

    @Autowired
    StatusService statusService;

    @GetMapping({"/", "/book"})
    public String showList(Model model){
        model.addAttribute("bookList", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/book/create")
    public String create(Model model){
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/book/create")
    public String createBook(Model model, @Validated @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute(book);
            return "book/create";
        }
        bookService.save(book);
        return "redirect:/";
    }
    @GetMapping("/borrow")
    public String borrow(Model model, @RequestParam Integer id) throws NotAvailableException {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("availableCode", bookService.getNextAvailableCode(book));
        return "book/borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute Book book, @RequestParam Integer usedCode) {
        bookService.borrow(book, usedCode);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        bookService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/return")
    public String returnPage(Model model, @RequestParam Integer id, @ModelAttribute ReturnCodeWrapper returnCodeWrapper) throws NotBorrowException {
        Book book = bookService.findById(id);
        if (bookService.checkNoUsedCode(book)) {
            throw new NotBorrowException();
        }
        model.addAttribute("returnCodeWrapper", returnCodeWrapper);
        model.addAttribute("book", book);
        return "book/return";
    }

    @PostMapping("/return")
    public String returnBook(Model model, @ModelAttribute Book book, @Validated @ModelAttribute ReturnCodeWrapper returnCodeWrapper, BindingResult result)
            throws NotAvailableException, WrongCodeException {
        if (result.hasFieldErrors()) {
            model.addAttribute("returnCodeWrapper", returnCodeWrapper);
            model.addAttribute("book", book);
            return "book/return";
        }
        bookService.returnBook(book, Integer.parseInt(returnCodeWrapper.getReturnCode()));
        return "redirect:/";
    }

    @ExceptionHandler(NotAvailableException.class)
    public String notAvailable() {
        return "error/error_not_available";
    }

    @ExceptionHandler(WrongCodeException.class)
    public String wrongCode() {
        return "error/error_wrong_code";
    }

    @ExceptionHandler(NotBorrowException.class)
    public String notBorrow() {
        return "error/error_not_borrow";
    }

}
