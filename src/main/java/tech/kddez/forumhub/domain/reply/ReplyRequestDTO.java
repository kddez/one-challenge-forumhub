package tech.kddez.forumhub.domain.reply;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReplyRequestDTO(
        @NotBlank
        String message,
        @NotNull
        Long topicId) {
}
