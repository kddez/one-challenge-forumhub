package tech.kddez.forumhub.domain.course;

import jakarta.persistence.*;
import lombok.*;
import tech.kddez.forumhub.domain.topic.Topic;

import java.util.List;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "courseId")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    private String categoryName;
    @OneToMany(mappedBy = "course")
    private List<Topic> topics;

    public Course(CourseRequestDTO request) {
        this.courseName = request.courseName();
        this.categoryName = request.categoryName();
    }

    public void attInfo(CourseRequestDTO dto) {
        if(dto.courseName() != null){
            this.courseName = dto.courseName();
        }

        if (dto.categoryName() != null){
            this.categoryName = dto.categoryName();
        }
    }
}
