package tech.kddez.forumhub.domain.course;

public record CourseResponseDTO(Long courseId, String courseName, String categoryName) {

    public CourseResponseDTO(Course course){
        this(course.getCourseId(), course.getCourseName(), course.getCategoryName());
    }

}
