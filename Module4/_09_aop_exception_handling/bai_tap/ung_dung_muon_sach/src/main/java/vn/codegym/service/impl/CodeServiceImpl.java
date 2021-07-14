package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Book;
import vn.codegym.model.Code;
import vn.codegym.model.Status;
import vn.codegym.repository.BookRepository;
import vn.codegym.repository.CodeRepository;
import vn.codegym.service.CodeService;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CodeRepository codeRepository;

    @Override
    public List<Code> findAll() {
        return codeRepository.findAll();
    }

    @Override
    public Code findById(Integer id) {
        return codeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public List<Code> findAllCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_Id(id);
    }

    @Override
    public List<Code> findAvailableCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id, 1);
    }

    @Override
    public List<Code> findUsedCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id, 2);
    }

    @Override
    public void returnBookByCode(Book book, Integer returnCode) {
        Code code= codeRepository.findById(returnCode).orElse(null);
        book = code.getBook();
        book.returnBook();
        bookRepository.save(book);
        code.setStatus(new Status(1, "available"));
    }
}
