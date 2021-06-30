package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Category;

public interface CategoryRepesitory extends JpaRepository<Category, Integer> {

}
