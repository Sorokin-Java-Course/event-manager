package sorokin.dev.eventmanager.users.api;

import sorokin.dev.eventmanager.users.domain.UserRole;

public record UserDto(
        Long id,
        String login,
        Integer age,
        UserRole role
) {
}
