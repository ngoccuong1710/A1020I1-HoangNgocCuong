package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.SmartPhone;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone, Integer> {
}
