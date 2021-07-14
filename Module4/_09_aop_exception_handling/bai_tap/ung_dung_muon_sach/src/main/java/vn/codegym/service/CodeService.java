package vn.codegym.service;

import vn.codegym.model.Book;
import vn.codegym.model.Code;

import java.util.List;

public interface CodeService {
    List<Code> findAll();

    Code findById(Integer id);

    void save(Code code);

    List<Code> findAllCodeByBookId(Integer id);

    List<Code> findAvailableCodeByBookId(Integer id);

    List<Code> findUsedCodeByBookId(Integer id);

    void returnBookByCode(Book book, Integer returnCode);
}
