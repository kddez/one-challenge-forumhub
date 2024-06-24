package tech.kddez.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kddez.forumhub.domain.topic.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
