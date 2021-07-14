package vn.codegym.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Range(min = 10000, max = 99999)
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    private Status status;

    public Code() {
    }

    public Code(@Range(min = 10000, max = 99999) int code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Code(@Range(min = 10000, max = 99999) int code, Book book, Status status) {
        this.code = code;
        this.book = book;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
