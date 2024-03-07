package study.miniproject.company.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.miniproject.company.dto.request.EmployeeRequestDto;
import study.miniproject.company.dto.request.TeamRequestDto;
import study.miniproject.company.dto.response.EmployeeResponseDto;
import study.miniproject.company.dto.response.TeamResponseDto;
import study.miniproject.company.service.CompanyService;

@RestController
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/api/employee")
    public void saveEmployee(@RequestBody EmployeeRequestDto request) {
        companyService.saveEmployee(request);
    }

    @PostMapping("/api/team")
    public void saveTeam(@RequestBody TeamRequestDto request) {
        companyService.saveTeam(request);
    }

    @GetMapping("/api/employees")
    public List<EmployeeResponseDto> findAllEmployees() {
        return companyService.findAllEmployees();
    }

    @GetMapping("/api/teams")
    public List<TeamResponseDto> findAllTeams() {
        return companyService.findAllTeams();
    }
}
