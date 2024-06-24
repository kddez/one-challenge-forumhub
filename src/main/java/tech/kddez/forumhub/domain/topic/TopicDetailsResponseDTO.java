package tech.kddez.forumhub.domain.topic;

import tech.kddez.forumhub.domain.course.CourseResponseDTO;
import tech.kddez.forumhub.domain.reply.ReplyResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record TopicDetailsResponseDTO(Long topicId, String message, LocalDateTime createdAt, TopicStatus status, CourseResponseDTO course, List<ReplyResponseDTO> replies) {

    public TopicDetailsResponseDTO(Topic topic) {
        this(topic.getTopicId(), topic.getMessage(), topic.getCreatedAt(), topic.getStatus(), new CourseResponseDTO(topic.getCourse()), ReplyResponseDTO.toResponseList(topic.getReplies()));
    }
}
