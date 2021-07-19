package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Blog;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT * FROM blog join category where blog.category_id = category.id and category.id = :id",
            nativeQuery = true)
    List<Blog> findAllByCategory(@Param("id") int id);

}
