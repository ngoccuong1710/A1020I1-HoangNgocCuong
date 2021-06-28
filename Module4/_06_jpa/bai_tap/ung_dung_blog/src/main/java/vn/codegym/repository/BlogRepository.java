package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;

import java.util.List;

public interface BlogRepository {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(Blog blog);

    void update(Blog blog);
}
