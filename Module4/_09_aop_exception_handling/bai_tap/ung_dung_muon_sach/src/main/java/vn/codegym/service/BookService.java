package vn.codegym.service;

import vn.codegym.exception.NotAvailableException;
import vn.codegym.exception.WrongCodeException;
import vn.codegym.model.Book;
import vn.codegym.model.Code;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void borrow(Book book, Integer usedCode);

    void delete(Integer id);

    Code getNextAvailableCode(Book book) throws NotAvailableException;

    void returnBook(Book book, Integer returnCode) throws NotAvailableException, WrongCodeException;

    public boolean checkNoUsedCode(Book book);

}
