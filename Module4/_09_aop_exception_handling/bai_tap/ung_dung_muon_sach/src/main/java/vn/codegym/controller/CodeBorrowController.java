package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.exception.NotAvailableException;
import vn.codegym.exception.WrongCodeException;
import vn.codegym.model.Book;
import vn.codegym.model.Code;
import vn.codegym.service.BookService;
import vn.codegym.service.CodeService;
import vn.codegym.service.StatusService;

import java.util.List;

@Controller
public class CodeBorrowController {
    @Autowired
    BookService bookService;

    @Autowired
    CodeService codeService;

    @Autowired
    StatusService statusService;

    @GetMapping("/borrow/view")
    public String view(Model model) {
        List<Code> codeBorrowList = codeService.findAll();
        model.addAttribute("codeBorrowList", codeBorrowList);
        return "code/view_code_borrow";
    }

    @GetMapping("/returnCode")
    public String returnPage(Model model, @RequestParam Integer id) {

        Code code = codeService.findById(id);
        Book book = code.getBook();

        model.addAttribute("book", book);
        model.addAttribute("code",code);
        return "code/return_book";
    }

    @PostMapping("/returnCode")
    public String returnBook(Model model, @ModelAttribute Book book, @ModelAttribute Code code) throws WrongCodeException, NotAvailableException {
        bookService.returnBook(book,code.getCode());
        return "redirect:/";
    }
}
