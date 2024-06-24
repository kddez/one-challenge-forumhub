package tech.kddez.forumhub.domain.topic;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import tech.kddez.forumhub.domain.course.Course;
import tech.kddez.forumhub.domain.reply.Reply;
import tech.kddez.forumhub.domain.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topics")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "topicId")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;
    private String title;
    private String message;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private TopicStatus status;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public Topic(String title, String message, TopicStatus status, Course course, User author){
        this.title = title;
        this.message = message;
        this.status = status;
        this.course = course;
        this.author = author;
    }

    public void attInfo(TopicUpdateDTO updateDTO) {

        if(updateDTO.title() != null){
            this.title = updateDTO.title();
        }

        if(updateDTO.message() != null){
            this.message = updateDTO.message();
        }

    }
}
