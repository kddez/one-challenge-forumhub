package tech.kddez.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kddez.forumhub.domain.course.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
