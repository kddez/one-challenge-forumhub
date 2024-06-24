package tech.kddez.forumhub.domain.user;

public record UserResponseDTO(Long userId, String username) {
    public UserResponseDTO(User user) {
        this(user.getUserId(), user.getUsername());
    }
}
