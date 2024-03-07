package study.miniproject.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.miniproject.company.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
