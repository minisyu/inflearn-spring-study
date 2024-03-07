package study.miniproject.company.dto.response;

import java.time.LocalDate;
import study.miniproject.company.entity.Employee;
import study.miniproject.company.entity.Role;

public record EmployeeResponseDto(
        String name,
        String teamName,
        Role role,
        LocalDate birthDay,
        LocalDate workStartDate
) {
    public static EmployeeResponseDto of(Employee employee) {
        return new EmployeeResponseDto(
                employee.getName(),
                employee.getTeam().getName(),
                employee.getRole(),
                employee.getBirthDay(),
                employee.getWorkStartDate()
        );
    }
}
