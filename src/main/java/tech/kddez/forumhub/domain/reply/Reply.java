package tech.kddez.forumhub.domain.reply;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import tech.kddez.forumhub.domain.topic.Topic;

import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "replyId")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;
    private String message;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    public Reply(String message, Topic topic) {
        this.message = message;
        this.topic = topic;
    }
}
