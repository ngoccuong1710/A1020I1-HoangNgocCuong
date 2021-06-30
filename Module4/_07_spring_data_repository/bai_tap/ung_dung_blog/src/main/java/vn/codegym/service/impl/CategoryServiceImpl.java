package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.repository.CategoryRepesitory;
import vn.codegym.service.CategoryService;

import javax.transaction.Transactional;
import java.util.List;

@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepesitory categoryRepesitory;

    @Override
    public List<Category> findAll() {
        return categoryRepesitory.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepesitory.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepesitory.save(category);
    }

    @Override
    public void remove(Category category) {
        categoryRepesitory.delete(category);
    }

    @Override
    public void update(Category category) {
        categoryRepesitory.save(category);
    }
}
