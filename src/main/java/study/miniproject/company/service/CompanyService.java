package study.miniproject.company.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.miniproject.company.dto.request.EmployeeRequestDto;
import study.miniproject.company.dto.request.TeamRequestDto;
import study.miniproject.company.dto.response.EmployeeResponseDto;
import study.miniproject.company.dto.response.TeamResponseDto;
import study.miniproject.company.entity.Employee;
import study.miniproject.company.entity.Team;
import study.miniproject.company.repository.EmployeeRepository;
import study.miniproject.company.repository.TeamRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public void saveTeam(TeamRequestDto request) {
        teamRepository.save(new Team(request.name()));
    }

    public void saveEmployee(EmployeeRequestDto request) {
        Team team = teamRepository.findByName(request.teamName())
                .orElse(new Team(request.teamName()));

        Employee employee = new Employee(request.name(), team, request.role(), request.birthDay(),
                request.workStartDate());

        employee.getTeam().addManager(employee);

        employeeRepository.save(employee);
    }

    public List<EmployeeResponseDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeResponseDto::of)
                .toList();
    }

    public List<TeamResponseDto> findAllTeams() {
        List<Team> teams = teamRepository.findAll();

        return teams.stream()
                .map(TeamResponseDto::of)
                .toList();
    }
}
