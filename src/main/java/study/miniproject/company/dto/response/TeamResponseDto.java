package study.miniproject.company.dto.response;

import study.miniproject.company.entity.Team;

public record TeamResponseDto(String name, String manager, int memberCount) {
    public static TeamResponseDto of(Team team) {
        return new TeamResponseDto(
                team.getName(),
                team.getManager(),
                team.getEmployeeCount()
        );
    }
}
