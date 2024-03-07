package study.miniproject.company.dto.request;

import java.time.LocalDate;
import study.miniproject.company.entity.Role;

public record EmployeeRequestDto(
        String name,
        String teamName,
        Role role,
        LocalDate birthDay,
        LocalDate workStartDate
) {
}
