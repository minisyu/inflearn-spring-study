package study.miniproject.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String manager;

    @OneToMany(mappedBy = "team")
    private final List<Employee> employees = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addManager(Employee employee) {
        if (employee.getRole() == Role.MANAGER) {
            this.manager = employee.getName();
        }
    }

    public int getEmployeeCount() {
        return employees.size();
    }
}
