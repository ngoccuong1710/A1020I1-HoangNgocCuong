package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.repository.BlogRepository;
import vn.codegym.service.BlogService;

import javax.transaction.Transactional;
import java.util.List;

@Service("BlogService")
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAllByCategory(int id) {
        return blogRepository.findAllByCategory(id);
    }


}
