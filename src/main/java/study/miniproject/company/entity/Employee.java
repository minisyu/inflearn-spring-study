package study.miniproject.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Team team;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate birthDay;

    private LocalDate workStartDate;

    public Employee(String name, Team team, Role role, LocalDate birthDay, LocalDate workStartDate) {
        this.name = name;
        this.team = team;
        this.role = role;
        this.birthDay = birthDay;
        this.workStartDate = workStartDate;
    }
}
