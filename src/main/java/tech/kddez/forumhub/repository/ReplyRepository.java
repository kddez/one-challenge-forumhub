package tech.kddez.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kddez.forumhub.domain.reply.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
